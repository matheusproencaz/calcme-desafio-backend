package io.github.matheusproencaz.calcme.desafio.repositories;

import io.github.matheusproencaz.calcme.desafio.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
