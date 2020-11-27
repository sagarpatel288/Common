package com.example.android.common.learning;

enum LearnEnum {

    TYPE1,
    TYPE2("type4");

    public static final String STATIC_FINAL_IN_ENUM = "static final variable in enum";
    public static String staticInEnum = "static variable in enum";
    public String STRING_VALUE = "";

    LearnEnum() {

    }

    LearnEnum(String STRING_VALUE) {
        this.STRING_VALUE = STRING_VALUE;
    }

    public String getSTRING_VALUE() {
        return STRING_VALUE;
    }

    public void setSTRING_VALUE(String STRING_VALUE) {
        this.STRING_VALUE = STRING_VALUE;
    }
}
