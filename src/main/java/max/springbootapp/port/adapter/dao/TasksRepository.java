package max.springbootapp.port.adapter.dao;

import max.springbootapp.domain.port.TaskInterface;
import max.springbootapp.port.adapter.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TasksRepository extends JpaRepository<TaskEntity, Long>, TaskInterface {
}
