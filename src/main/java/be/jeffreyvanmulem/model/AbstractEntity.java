package be.jeffreyvanmulem.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: Jeffrey
 * Date: 06/01/12
 * Time: 10:22
 * To change this template use File | Settings | File Templates.
 */
@MappedSuperclass
public class AbstractEntity {
    @Id
    @GeneratedValue
    @Column(name = "id")
    protected Long id;

    @Version
    @Column(name = "version")
    protected Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
