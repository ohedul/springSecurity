package bd.ohedulalam.springSecurity.repository;

import bd.ohedulalam.springSecurity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String s);
}
