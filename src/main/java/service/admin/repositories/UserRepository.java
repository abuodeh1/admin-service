package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.user.User;

import java.util.Optional;

@Repository
public interface UserRepository extends NaturalRepository<User, String>, JpaSpecificationExecutor<User> {

    @Override
    Optional<User> findBySimpleNaturalId(String naturalId);

}