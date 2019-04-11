package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.lookup.Lookup;

import java.util.List;

@Repository
public interface LookupRepository extends NaturalRepository<Lookup, String>, JpaSpecificationExecutor<Lookup> {

    @Query
    List<Lookup> getAllParentsLookup();

    @Query
    List<Lookup> getAllChildesLookup(String id);

    @Query
    Lookup getParentLookup(String code);
}
