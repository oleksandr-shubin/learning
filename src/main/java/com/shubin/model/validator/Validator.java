package com.shubin.model.validator;

public abstract class Validator<T> {
    protected String message;

    public abstract boolean isValid(T value);

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
