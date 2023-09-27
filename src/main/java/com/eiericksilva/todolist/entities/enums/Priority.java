package com.eiericksilva.todolist.entities.enums;

public enum Priority {
    ONE(1), TWO(2), THREE(3), FOUR(4);

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
