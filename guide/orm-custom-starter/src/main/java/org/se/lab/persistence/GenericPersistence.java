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
        //TODO: implement
    }

    public void insert(Object obj) {
        //TODO: implement
    }

    public void update(Object obj) {
        //TODO: implement
    }

    public void delete(Object obj) {
        //TODO: implement
    }

    public <T> T findById(Class<T> clazz, Object id) {
        //TODO: implement
    }


}
