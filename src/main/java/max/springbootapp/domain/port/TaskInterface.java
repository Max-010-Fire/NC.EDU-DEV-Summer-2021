package max.springbootapp.domain.port;

import max.springbootapp.domain.model.base.Task;

import java.util.List;

public interface TaskInterface {
    List<Task> findByUserId(int userId);
}
