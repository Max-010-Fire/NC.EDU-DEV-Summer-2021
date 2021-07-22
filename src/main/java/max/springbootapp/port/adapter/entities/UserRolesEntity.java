package max.springbootapp.port.adapter.entities;

import javax.persistence.*;

@Entity
@Table(name = "user_roles")
public class UserRolesEntity {
    @Id
    @GeneratedValue
    private long id;

    private long userId;
    private long roleId;

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public long getUserId() {
        return userId;
    }

    public long getRoleId() {
        return roleId;
    }
}
