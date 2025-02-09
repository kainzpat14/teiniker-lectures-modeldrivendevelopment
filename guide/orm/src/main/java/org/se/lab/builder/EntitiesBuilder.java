package org.se.lab.builder;

public class EntitiesBuilder {

    public EntityBuilder entity(String name) {
        return new EntityBuilder(this.name);
    }
}
