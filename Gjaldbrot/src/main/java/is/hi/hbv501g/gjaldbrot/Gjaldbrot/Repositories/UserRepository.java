package is.hi.hbv501.gjaldbrot.Gjaldbrot.Repositories;

import is.hi.hbv501.gjaldbrot.Gjaldbrot.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService extends JpaRepository<User, Long> {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByName(String userFName);
    User findByEmail(String userEmail);
    User login(User user);
}