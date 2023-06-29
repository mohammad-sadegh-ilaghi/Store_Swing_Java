package org.example.Rules;

public enum RulesUser {

    ADMIN("ADMIN"),
    USER("USER");
    private final String stringValue;


    RulesUser(String user) {
        this.stringValue = user;
    }

    public String toString() {
        return stringValue;
    }
    public String getStringValue() {
        return stringValue;
    }

}
