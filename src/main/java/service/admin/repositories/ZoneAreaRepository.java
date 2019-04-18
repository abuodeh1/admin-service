package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import service.admin.model.location.Areas;
import service.admin.model.location.ZoneArea;
import service.admin.model.location.ZoneAreaIdentity;

import java.util.List;

public interface ZoneAreaRepository extends JpaRepository<ZoneArea, ZoneAreaIdentity> {

    @Query
    List<Areas> getZoneAreaByZoneCode(String code);

}
