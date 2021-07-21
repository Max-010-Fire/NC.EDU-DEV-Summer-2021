package max.springbootapp.domain.port.repositories;

import max.springbootapp.domain.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
