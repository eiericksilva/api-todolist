package com.eiericksilva.todolist.entities.enums;

public enum Category {
    STUDY(1),
    WORK(2),
    CHURCH(3),
    HEALTH(4),
    HOME(5);

    private int code;

    private Category(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Category valueOf(int code) {
        for (Category value : Category.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid OrderStatus Code");
    }

}
