package com.dailydiary.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationFormDTO {

    @NotNull(message = "Login can't be empty")
    @NotBlank
    @Size(min = 6, max = 20, message = "6 - 20 characters")
    private String username;
    @NotNull(message = "Email can't be empty")
    @Email(message = "Incorrect email")
    private String email;
    @NotNull(message = "Password can't be empty")
    @NotBlank(message = "Password can't be empty")
    @Pattern(regexp = "\\A(?=\\S*?[0-9])(?=\\S*?[a-z])(?=\\S*?[A-Z])(?=\\S*?)\\S{8,}\\z", message = "One uppercase, one lowercase, and a number, at least 8 characters")
    private String password;
    @NotNull(message = "Re-enter the password")
    @NotBlank(message = "Re-enter the password")
    private String confirmedPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmedPassword() {
        return confirmedPassword;
    }

    public void setConfirmedPassword(String confirmedPassword) {
        this.confirmedPassword = confirmedPassword;
    }
}
