package com.systems.great.meters;

/**
 * Created by Sergey on 05.08.2017.
 */

public class Field {
    private String name;
    private FieldType type;
    private String defaultValue;
    private String value;
    private String newValue;
    private String oldValue;
    private boolean autoInc;

    public Field(String name, FieldType type, String defaultValue, boolean autoInc) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
        this.autoInc = autoInc;
    }

    public Field(String name, FieldType type, String defaultValue) {
        this.name = name;
        this.type = type;
        this.defaultValue = defaultValue;
        this.autoInc = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FieldType getType() {
        return type;
    }

    public void setType(FieldType type) {
        this.type = type;
    }

    public String getDefaultValue() {
        return defaultValue;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public boolean isAutoInc() {
        return autoInc;
    }

    public void setAutoInc(boolean autoInc) {
        this.autoInc = autoInc;
    }
}
