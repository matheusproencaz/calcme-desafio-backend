package io.github.matheusproencaz.calcme.desafio.service;

import io.github.matheusproencaz.calcme.desafio.controller.dto.UserDTO;
import io.github.matheusproencaz.calcme.desafio.model.User;
import io.github.matheusproencaz.calcme.desafio.repositories.UserRepository;
import io.github.matheusproencaz.calcme.desafio.service.exception.EmailAlreadyExistsException;
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
        if (findByEmail(dto.getEmail()) != null) {
            throw new EmailAlreadyExistsException("Email já foi cadastrado!");
        }
        return repository.insert(createUserDTO(dto));
    }

    public List<User> findAll() {
        return repository.findAll();
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

    private User createUserDTO(UserDTO user) {
        return new User(user.getName(), user.getEmail(), user.getPhone());
    }
}
