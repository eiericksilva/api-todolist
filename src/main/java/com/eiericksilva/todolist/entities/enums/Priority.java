package com.eiericksilva.todolist.entities.enums;

public enum Priority {
    LOW(1, "Low"),
    MEDIUM(2, "Medium"),
    HIGH(3, "High"),
    VERY_HIGH(4, "Very High");

    private Priority(int priorityCode, String priorityDescription) {
        this.priorityCode = priorityCode;
        this.priorityDescription = priorityDescription;
    }

    private final int priorityCode;
    private final String priorityDescription;

    public int getPriorityCode() {
        return priorityCode;
    }
    public String getPriorityDescription() {
        return priorityDescription;
    }

    public static Priority valueOf(int priorityCode) {
        for (Priority value : Priority.values()) {
            if (value.getPriorityCode() == priorityCode) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Priority Code");
    }
}
