package max.springbootapp.port.adapter.dao;

import max.springbootapp.port.adapter.entities.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<RoleEntity, Long> {
}
