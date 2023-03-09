package com.example.test_task.entity;

public class UserWithError extends User{
    private String error;

    public UserWithError() {
    }

    public UserWithError(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
