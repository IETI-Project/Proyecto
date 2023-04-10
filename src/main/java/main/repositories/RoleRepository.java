package main.repositories;

import java.util.Optional;

import main.model.Role;
import main.model.RoleEnum;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(RoleEnum name);
}