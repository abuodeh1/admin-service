package service.admin.model.lookup;


import org.hibernate.annotations.NaturalId;
import org.hibernate.envers.Audited;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@NamedQueries({
        @NamedQuery(name = "Lookup.getAllParentsLookup", query = "select c from Lookup c where c.parent='0'"),
        @NamedQuery(name = "Lookup.getParentLookup", query = "select c from Lookup c where c.code=?1 and c.parent='0'"),
        @NamedQuery(name = "Lookup.getLookupChilds", query = "select c  from Lookup c where c.parent=?1"),
        @NamedQuery(name = "Lookup.getChildLookup", query = "select c.name  from Lookup c where c.code=?1 and c.parent=?2 "),
        @NamedQuery(name = "Lookup.getAllChildLookup", query = "select c  from Lookup c where   c.parent!='0' ")
})
@Audited
@EntityListeners(value = AuditingEntityListener.class)
@Entity(name="Lookup")
public class Lookup {

    @Id
    @Column(unique = true, nullable = false, updatable = false, length = 100)
    public String code;
    public String name;
    public String nameAr;
    public boolean enabled;
    private String description;
    private String descriptionAr;
    private String parent;
    private boolean preferred;
    @Transient
    private List<Lookup> childList;

    public Lookup() {
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

    public String getNameAr() {
        return nameAr;
    }

    public void setNameAr(String nameAr) {
        this.nameAr = nameAr;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescriptionAr() {
        return descriptionAr;
    }

    public void setDescriptionAr(String descriptionAr) {
        this.descriptionAr = descriptionAr;
    }

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public boolean isPreferred() {
        return preferred;
    }

    public void setPreferred(boolean preferred) {
        this.preferred = preferred;
    }

    public List<Lookup> getChildList() {
        return childList;
    }

    public void setChildList(List<Lookup> childList) {
        this.childList = childList;
    }

}