package io.github.matheusproencaz.calcme.desafio.controller.dto;

import io.github.matheusproencaz.calcme.desafio.model.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;

public class UserDTO implements Serializable {
    private static final long serialVersionUID = -1439927411809032343L;
    @NotEmpty(message = "{name.notEmpty}")
    private String name;
    @NotEmpty(message = "{email.notEmpty}")
    @Email(message = "{email.EmailValidation}")
    private String email;
    @NotEmpty(message = "{phone.notEmpty}")
    private String phone;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
