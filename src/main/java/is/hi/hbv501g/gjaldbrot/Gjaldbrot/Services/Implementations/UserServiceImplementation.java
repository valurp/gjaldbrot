package is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.Implementations;

import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Entities.User;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Repositories.UserRepository;
import is.hi.hbv501g.gjaldbrot.Gjaldbrot.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {
    UserRepository repository;

    @Autowired
    public UserServiceImplementation(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(User user) {
        repository.delete(user);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findByUName(String uName) {
        return repository.findByUName(uName);
    }

    @Override
    public User login(User user) {
        User exists = findByUName(user.uName);
        if(exists != null){
            if(exists.password.equals(user.password)){
                System.out.println(user);
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByName(String uName) {
        return repository.getUserByName(uName);
    }
}