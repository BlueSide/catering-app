package nl.blueside.cateringapp;

import org.springframework.data.repository.CrudRepository;
import java.time.LocalDateTime;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
public interface UserRepository extends CrudRepository<User, Long>
{
    public User findByEmail(String email);    
}
