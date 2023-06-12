package com.example.case_study_module3.until;
public class InputUntil {
    public static boolean inputRegex(String value, String regex) {
        if (value.matches(regex)) {
            return false;
        }
        return true;
    }
    public static boolean inputDouble(String value) {
        double result = 0;
        try {
            result = Double.parseDouble(value);
        } catch (Exception e) {
            return true;
        }
        return false;
    }
}
