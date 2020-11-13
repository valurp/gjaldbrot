package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public interface UserService extends UserDetailsService {

    User save(User user);
    User registerNewUser(User user);
    UserDetails loadUserByUsername(final String name);
    void delete(User user);
    List<User> findAll();
    User findByName(String uName);

    User getUserByName(String uName);
}