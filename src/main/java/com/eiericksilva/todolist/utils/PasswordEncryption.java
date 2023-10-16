package com.eiericksilva.todolist.utils;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordEncryption {
    private PasswordEncryption() {
    }

    public static String encryptPassword(String password) {

        return BCrypt.withDefaults().hashToString(12, password.toCharArray());

    }
}
