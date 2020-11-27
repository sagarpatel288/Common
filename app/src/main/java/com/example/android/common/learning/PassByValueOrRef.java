package com.example.android.common.learning;

class PassByValueOrRef {

    public static void main(String[] args) {
        initialize();
    }

    public static void initialize() {
        StringBuilder stringBuilder = new StringBuilder("mutable");
        String string = "immutable";
        change(stringBuilder, string);
        System.out.println("stringBuilder is: " + stringBuilder);
        System.out.println("string is: " + string);
    }

    public static void change(StringBuilder stringBuilder, String string) {
        if (stringBuilder != null) {
            stringBuilder.append(" appended inside the method");
        }
        if (string != null) {
            string = "inside the method";
        }
        stringBuilder = null;
        string = null;
    }
}
