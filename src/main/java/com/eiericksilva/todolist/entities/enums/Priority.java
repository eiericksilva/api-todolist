package com.eiericksilva.todolist.entities.enums;

public enum Priority {
    LOW(1), MEDIUM(2), HIGH(3), VERY_HIGH(4);

    private int code;

    private Priority(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Priority valueOf(int code) {
        for (Priority value : Priority.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }

}
