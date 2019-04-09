package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.lookup.Lookup;

import java.util.List;
import java.util.Optional;

@Repository
public interface LookupRepository extends JpaRepository<Lookup, String>, JpaSpecificationExecutor<Lookup> {

    Optional<Lookup> findLookupByCode(String code);

    @Query
    public  List<Lookup> getAllParentsLookup();

    @Query
    public List<Lookup> getAllChildsLookup(String id);

    @Query
    public  Lookup getChildLookup(String id, String parent);

    @Query
    Lookup getParentLookup(String code);
}
