package com.esc.QuanLyAnCa.core.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValidator implements ConstraintValidator<ValidDate, String> {

    private static final String DATE_PATTERN = "yyyy-MM-dd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat(DATE_PATTERN);

    @Override
    public void initialize(ValidDate constraintAnnotation) {
    }

    @Override
    public boolean isValid(String dateStr, ConstraintValidatorContext context) {
        if (dateStr == null) {
            return false;
        }
        try {
            Date date = dateFormat.parse(dateStr);
            // Thêm các kiểm tra tùy chỉnh cho ngày nếu cần
            // Ví dụ: kiểm tra xem ngày có trong quá khứ hay tương lai, etc.
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}