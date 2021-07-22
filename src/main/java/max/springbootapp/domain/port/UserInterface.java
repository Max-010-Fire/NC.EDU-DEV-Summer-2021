package max.springbootapp.domain.port;

import max.springbootapp.domain.model.base.User;

public interface UserInterface {
    User findById(int id);
}
