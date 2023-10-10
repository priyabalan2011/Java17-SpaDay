package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
    @NotBlank(message = "Username should be required")
    @Size(min=5, max=15, message = "UserName must be between 5 and 15 characters")
    @NotNull
    private String username;
    //@NotBlank(message = "Email should be required")
    @Email(message = "Invalid email. Try again.")
    private String email;
    @NotBlank(message = "Password should be required")
    @Size(min=6,message = "Password should be 6 character length")
    @NotNull
    private String password;

    public User() {

    }

    public User(String username, String email, String password) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
    }

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
}

