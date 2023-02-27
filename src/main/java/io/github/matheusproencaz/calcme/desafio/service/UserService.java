package io.github.matheusproencaz.calcme.desafio.service;

import io.github.matheusproencaz.calcme.desafio.controller.dto.UserDTO;
import io.github.matheusproencaz.calcme.desafio.model.User;
import io.github.matheusproencaz.calcme.desafio.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User createUser(UserDTO dto) {
        return repository.insert(createUserDTO(dto));
    }

    private User createUserDTO(UserDTO user) {
        return new User(user.getName(), user.getEmail(), user.getPhone());
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
