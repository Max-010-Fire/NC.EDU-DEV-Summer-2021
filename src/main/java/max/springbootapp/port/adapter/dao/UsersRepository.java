package max.springbootapp.port.adapter.dao;

import max.springbootapp.domain.port.UserInterface;
import max.springbootapp.port.adapter.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<UserEntity, Long>, UserInterface {
}
