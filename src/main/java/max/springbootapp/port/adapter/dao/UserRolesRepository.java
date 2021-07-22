package max.springbootapp.port.adapter.dao;

import max.springbootapp.port.adapter.entities.UserRolesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRolesRepository extends JpaRepository<UserRolesEntity, Long> {
}
