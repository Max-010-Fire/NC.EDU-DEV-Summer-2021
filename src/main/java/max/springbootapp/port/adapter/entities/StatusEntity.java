package max.springbootapp.port.adapter.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="statuses")
public class StatusEntity {
    @Id
    @GeneratedValue
    private long id;

    private String statusName;

    public long getId() {
        return id;
    }

    public String getStatusName() {
        return statusName;
    }
}
