package main.repositories;

import main.model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Component("userRepository")
public interface UserRepository extends MongoRepository <User, ObjectId>{
    Optional<User> findByEmail(String email);
}
