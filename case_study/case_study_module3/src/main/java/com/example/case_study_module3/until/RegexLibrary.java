package com.example.case_study_module3.until;

public interface RegexLibrary {
    String PHONE_REGEX = "^(\\d{2})+[-]+(0)+(\\d{9})$";
    String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    String IDCARD = "^[0-9]{12}$";
    String PHONE_NUMBER = "^(\\d{3}[- ]?){2}\\d{4}$";
}
