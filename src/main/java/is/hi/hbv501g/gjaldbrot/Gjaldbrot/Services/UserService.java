package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserService {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByUName(String uName);
    User login(User user);

    User getUserByName(String uName);
}