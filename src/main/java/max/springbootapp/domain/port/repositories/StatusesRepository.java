package max.springbootapp.domain.port.repositories;

import max.springbootapp.domain.model.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusesRepository extends JpaRepository<Status, Long> {
}
