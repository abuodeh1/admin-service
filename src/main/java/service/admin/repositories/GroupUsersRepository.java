package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import service.admin.model.group.GroupUsers;
import service.admin.model.group.GroupUsersIdentity;

public interface GroupUsersRepository extends JpaRepository<GroupUsers, GroupUsersIdentity> {

//    @Query(value = "",
//            nativeQuery = true)
//    List<User> getGroupUsers(String code);




}
