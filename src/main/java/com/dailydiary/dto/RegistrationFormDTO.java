package com.dailydiary.dto;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegistrationFormDTO {

    @NotNull(message = "enter login")
    @NotBlank
    @Size(min = 3, max = 12, message = "Login must contain blah blah")
    private String username;
    @NotNull(message = "enter")
    @Email(message = "incorrect")
    private String email;
    @NotNull(message = "enter")
    @NotBlank(message = "ENTER!")
    private String password;
    @NotNull(message = "re-enter")
    @NotBlank(message = "not empty")
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
