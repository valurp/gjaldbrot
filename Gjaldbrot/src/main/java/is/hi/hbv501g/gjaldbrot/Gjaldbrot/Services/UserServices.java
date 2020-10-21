package is.hi.hbv501g.gjaldbrot.Gjaldbrot;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void delete(User user);
    List<User> findAll();
    User findByName(String userFName);
    User findByEmail(String userEmail);
    User login(User user);
}