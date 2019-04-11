package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.lookup.Lookup;

import java.util.List;

@Repository
public interface LookupRepository extends NaturalRepository<Lookup, String>, JpaSpecificationExecutor<Lookup> {

    @Query
    public  List<Lookup> getAllParentsLookup();

    @Query
    List<Lookup> getAllChildesLookup(String id);
    public List<Lookup> getLookupChilds(String id);

    @Query
    public  Lookup getChildLookup(String id, String parent);

    @Query
    Lookup getParentLookup(String code);

    @Query
    List<Lookup> getAllChildLookup();


}
