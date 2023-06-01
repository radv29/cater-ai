package com.caterai.personaldetails.domain.enums;

public enum WeightUnit {

    KILOGRAMS("Kilograms"),
    POUNDS("Pounds");

    public final String label;

    private WeightUnit(String label) {
        this.label = label;
    }

}
