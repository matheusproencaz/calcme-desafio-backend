package io.github.matheusproencaz.calcme.desafio.controller;

import io.github.matheusproencaz.calcme.desafio.controller.dto.UserDTO;
import io.github.matheusproencaz.calcme.desafio.model.User;
import io.github.matheusproencaz.calcme.desafio.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    UserService service;

    @Autowired
    private UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody UserDTO dto) {
        return service.createUser(dto);
    }

    @GetMapping
    public List<User> findAllUsers() {
        return service.findAll();
    }
}
