package com.caterai.personaldetails.domain.enums;

public enum Gender {

    MALE ("Male"),
    FEMALE ("Female");

    public final String label;

    private Gender(String label) {
        this.label = label;
    }
}
