package max.springbootapp.domain.model.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private long id;

    private String roleName;

    public long getId() {
        return id;
    }

    public String getRoleName() {
        return roleName;
    }
}
