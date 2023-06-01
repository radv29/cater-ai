package com.caterai.personaldetails.domain.enums;

public enum HeightUnit {

    CENTIMETERS("Centimeters"),
    FEET("Feet");

    public final String label;

    private HeightUnit(String label) {
        this.label = label;
    }

}
