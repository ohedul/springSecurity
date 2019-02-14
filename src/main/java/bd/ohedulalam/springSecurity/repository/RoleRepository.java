package bd.ohedulalam.springSecurity.repository;

import bd.ohedulalam.springSecurity.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
