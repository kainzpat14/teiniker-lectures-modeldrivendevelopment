package org.se.lab.persistence;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.FieldUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class GenericPersistence {

    protected Connection connection;

    public GenericPersistence(Connection connection) {
        this.connection = connection;
    }

    public void createTable(Class<?> clazz) {
        String tableName = determineTableName(clazz);
        //ID INT PRIMARY KEY
        List<String> fieldCreates = determineFieldCreateStrings(clazz);
        //CREATE TABLE IF NOT EXISTS USER (ID INT PRIMARY KEY, USERNAME VARCHAR(255), PASSWORD VARCHAR(255))
        String sql = String.format("CREATE TABLE IF NOT EXISTS %s (%s)", tableName, String.join(",", fieldCreates));
        executeSql(sql, new ArrayList<>());
    }

    public void insert(Object obj) {
        String tableName = determineTableName(obj);
        List<Object> values = determineFieldValues(obj);
        List<String> fieldNames = determineFieldNames(obj.getClass());
        //INSERT INTO USER (ID, USERNAME, PASSWORD) VALUES (?,?,?)
        String sql = String.format("INSERT INTO %s (%s) VALUES (%s)", tableName, String.join(",", fieldNames), values.stream().map(v -> "?").collect(Collectors.joining(",")));
        executeSql(sql, values);
    }

    public void update(Object obj) {
        String tableName = determineTableName(obj);
        List<Object> values = determineFieldValues(obj);
        List<String> fieldNames = determineFieldNames(obj.getClass());
        //UPDATE USER SET ID=?, USERNAME=?, PASSWORD=? WHERE ID=?
        String sql = String.format("UPDATE %s SET %s WHERE ID=?", tableName, fieldNames.stream().map(f -> f + "=?").collect(Collectors.joining(",")));
        values.add(findId(obj));
        executeSql(sql, values);
    }

    public void delete(Object obj) {
        String tableName = determineTableName(obj);
        //DELETE FROM USER WHERE ID=?
        String sql = String.format("DELETE FROM %s WHERE ID=?", tableName);
        executeSql(sql, Collections.singletonList(findId(obj)));
    }

    public <T> T findById(Class<T> clazz, Object id) {
        String tableName = determineTableName(clazz);
        //SELECT * FROM USER WHERE ID=?
        String sql = String.format("SELECT * FROM %s WHERE ID=?", tableName);
        System.out.println(sql);
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setObject(1, id);
            preparedStatement.execute();
            List<T> result = resultSetToClazzes(clazz, preparedStatement);
            return result.isEmpty() ? null : result.get(0);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    private List<String> determineFieldCreateStrings(Class<?> clazz) {
        List<String> fieldCreates = new ArrayList<>();
        List<Field> fields = FieldUtils.getAllFieldsList(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = determineFieldName(field);
            String fieldType = determineFieldType(field);
            boolean isId = isId(field);
            if (isId) {
                fieldCreates.add(String.format("%s %s PRIMARY KEY", fieldName, fieldType));
            } else {
                fieldCreates.add(String.format("%s %s", fieldName, fieldType));
            }
        }
        return fieldCreates;
    }

    private String determineFieldType(Field field) {
        Column column = field.getAnnotation(Column.class);
        if (column != null && !StringUtils.isEmpty(column.columnDefinition())) {
            return column.columnDefinition();
        }
        ManyToOne manyToOne = field.getAnnotation(ManyToOne.class);
        if (manyToOne != null) {
            return determineFieldType(findIdField(field.getType()));
        } else {
            if (field.getType().equals(String.class)) {
                return "VARCHAR(255)";
            } else if (field.getType().equals(Integer.class) || field.getType().equals(int.class)) {
                return "INT";
            } else {
                throw new UnsupportedOperationException("Unsupported field type: " + field.getType());
            }
        }
    }

    @SuppressWarnings("unchecked")
    private <T> List<T> resultSetToClazzes(Class<T> clazz, PreparedStatement preparedStatement) throws SQLException {
        List<T> result;
        try (ResultSet resultSet = preparedStatement.getResultSet()) {
            result = new ArrayList<>();
            while (resultSet.next()) {
                Object resultObj = convertRowToClazz(clazz, resultSet);
                result.add((T) resultObj);
            }
        }
        return result;
    }

    private <T> Object convertRowToClazz(Class<T> clazz, ResultSet resultSet) {
        try {
            Object resultObj = clazz.getConstructor().newInstance();
            List<Field> fields = FieldUtils.getAllFieldsList(clazz);
            for (Field field : fields) {
                field.setAccessible(true);
                String fieldName = determineFieldName(field);
                Object rawValue = resultSet.getObject(fieldName);
                Object value = convertTableValueToFieldValue(field, rawValue);
                field.set(resultObj, value);
            }
            return resultObj;
        } catch (IllegalAccessException | NoSuchMethodException | InstantiationException | InvocationTargetException |
                 SQLException ex) {
            throw new RuntimeException("Error converting row to class", ex);
        }
    }

    private Object convertTableValueToFieldValue(Field field, Object rawValue) {
        Object value;
        ManyToOne manyToOne = field.getAnnotation(ManyToOne.class);
        if (manyToOne != null) {
            value = findById(field.getType(), rawValue);
        } else {
            value = rawValue;
        }
        return value;
    }

    private String determineTableName(Object obj) {
        Class<?> clazz = obj.getClass();
        return determineTableName(clazz);
    }

    private String determineTableName(Class<?> clazz) {
        Entity entity = clazz.getAnnotation(Entity.class);
        return StringUtils.isEmpty(entity.name()) ? clazz.getSimpleName().toUpperCase() : entity.name();
    }


    private void executeSql(String sql, List<Object> values) {
        System.out.println(sql);
        try (CallableStatement statement = connection.prepareCall(sql)) {
            int i = 1;
            for (Object value : values) {
                statement.setObject(i++, value);
            }
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException("Error executing SQL", e);
        }
    }

    private List<Object> determineFieldValues(Object obj) {
        List<Object> values = new ArrayList<>();
        try {
            List<Field> fields = FieldUtils.getAllFieldsList(obj.getClass());
            for (Field field : fields) {
                field.setAccessible(true);
                Object value = determineValue(obj, field);
                values.add(value);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error determining field names and values", e);
        }
        return values;
    }

    private List<String> determineFieldNames(Class<?> clazz) {
        List<Field> fields = FieldUtils.getAllFieldsList(clazz);
        return fields.stream().map(this::determineFieldName).collect(Collectors.toList());
    }

    private Object determineValue(Object obj, Field field) throws IllegalAccessException {
        Object value;
        ManyToOne manyToOne = field.getAnnotation(ManyToOne.class);
        if (manyToOne != null) {
            Object otherEntity = field.get(obj);
            value = findId(otherEntity);
        } else {
            value = field.get(obj);
        }
        return value;
    }

    private Object findId(Object otherEntity) {
        try {
            Field field = findIdField(otherEntity.getClass());
            return field.get(otherEntity);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Error determining field names and values", e);
        }
    }

    private Field findIdField(Class<?> clazz) {
        List<Field> fields = FieldUtils.getAllFieldsList(clazz);
        for (Field field : fields) {
            field.setAccessible(true);
            if (isId(field)) {
                return field;
            }
        }
        throw new IllegalArgumentException("No @Id field found in entity");
    }

    private boolean isId(Field field) {
        Id id = field.getAnnotation(Id.class);
        return id != null;
    }

    private String determineFieldName(Field field) {
        Column column = field.getAnnotation(Column.class);
        if (column != null) {
            return column.name();
        }
        ManyToOne manyToOne = field.getAnnotation(ManyToOne.class);
        if (manyToOne != null) {
            return field.getName().toUpperCase() + "_ID";
        }
        return field.getName().toUpperCase();
    }
}
