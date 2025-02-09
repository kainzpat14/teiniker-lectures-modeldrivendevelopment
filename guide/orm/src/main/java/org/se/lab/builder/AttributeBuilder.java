package org.se.lab.builder;

public class AttributeBuilder {
    private String name;
    private EntityBuilder parent;
    private String type;

    public AttributeBuilder(EntityBuilder parent, String name) {
        this.name = name;
        this.parent = parent;
    }

    public EntityBuilder integer() {
        type = "int";
        return parent;
    }

    public EntityBuilder string() {
        type = "String";
        return parent;
    }

    public EntityBuilder reference(String referenceType) {
        type = referenceType;
        return parent;
    }
}
