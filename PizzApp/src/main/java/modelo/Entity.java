package modelo;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id @GeneratedValue
    private int id;

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }
}
