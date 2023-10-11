package com.esc.QuanLyAnCa.core.validate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumber, String> {

    @Override
    public void initialize(PhoneNumber constraintAnnotation) {
    }

    @Override
    public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
        // Thực hiện kiểm tra logic cho số điện thoại ở đây.
        // Ví dụ: kiểm tra định dạng, chiều dài, etc.
        if (phoneNumber == null) {
            return false;
        }
        // Đây là một ví dụ đơn giản, bạn có thể tùy chỉnh theo nhu cầu.
        return phoneNumber.matches("^\\d{10}$");
    }
}
