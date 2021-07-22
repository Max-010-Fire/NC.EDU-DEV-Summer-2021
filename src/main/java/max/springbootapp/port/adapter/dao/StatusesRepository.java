package max.springbootapp.port.adapter.dao;

import max.springbootapp.port.adapter.entities.StatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusesRepository extends JpaRepository<StatusEntity, Long> {
}
