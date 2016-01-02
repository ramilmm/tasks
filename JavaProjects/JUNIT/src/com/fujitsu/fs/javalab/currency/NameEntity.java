package com.fujitsu.fs.javalab.currency;

import java.io.Serializable;

public class NameEntity implements Serializable {
    private String name;
    private Long id;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }


    public NameEntity() {
    }

    public NameEntity(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "NameEntity" + "id" + name + '\'' + '}';
    }

    public static NameEntity parse(String entity) throws EntityExeption {
        String[] parts = entity.split(";#", -1);
        if (parts.length != 2) {
            throw new EntityExeption("error parsing " + entity + " invalid format");
        }

        Long id = null;
        try {
            id = Long.parseLong(parts[0]);
        } catch (NumberFormatException e) {
            throw new EntityExeption("error parsing id out of the " + entity + "." + e);
        }

        return new NameEntity(Long.parseLong(parts[0]), parts[1]);
    }

    public static NameEntity parseList(String entity) {
        return null;
    }
}
