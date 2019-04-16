package service.admin.repositories;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import service.admin.model.user.User;

@Repository
public interface UserRepository extends NaturalRepository<User, Integer>, JpaSpecificationExecutor<User> {





}