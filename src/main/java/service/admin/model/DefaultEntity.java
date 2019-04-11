package service.admin.model;

import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.util.Objects;

@Audited
@MappedSuperclass
public abstract class DefaultEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    public int id;
    @NaturalId
    @Column(unique = true, nullable = false, updatable = false, length = 100)
    public String code;
    public String name;
    public boolean enabled;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DefaultEntity)) {
            return false;
        }
        DefaultEntity naturalIdProduct = (DefaultEntity) o;
        return Objects.equals(getCode(), naturalIdProduct.getCode());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getCode());
    }
    
}
