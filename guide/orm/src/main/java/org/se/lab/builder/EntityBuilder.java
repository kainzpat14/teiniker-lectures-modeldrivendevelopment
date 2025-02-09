package org.se.lab.builder;

public class EntityBuilder {
    private String name;
    private EntitiesBuilder parent;

    public EntityBuilder(EntitiesBuilder parent, String name) {
        this.name = name;
        this.parent = parent;
    }

    public AttributeBuilder attribute(String name) {
        return new AttributeBuilder(this,name);
    }

    public EntityBuilder entity(String name) {
        return parent.entity(name);
    }

    public void generate() {
        //TODO: implement
    }
}
