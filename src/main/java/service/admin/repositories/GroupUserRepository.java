package service.admin.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.group.GroupUsers;
import service.admin.model.group.GroupUsersIdentity;
import service.admin.model.user.User;

import java.util.List;

@Repository
public interface GroupUserRepository extends NaturalRepository <GroupUsers, GroupUsersIdentity> {

    @Query
    List<User> getGroupUsersByGroupCode(String code);

}


