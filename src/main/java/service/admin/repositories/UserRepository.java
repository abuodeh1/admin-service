package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import service.admin.model.user.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    Optional<User> findUserByCode(String username);

    @Query(
            value = "SELECT code FROM privileges INNER JOIN roleprivilege on roleprivilege.privilege_id = privileges.id AND roleprivilege.role_id in (select role_id from userroles where user_id = (select user_id from users where username = ?1))",
            nativeQuery = true)
    List<String> getPriviledgeCodes(String username);

}