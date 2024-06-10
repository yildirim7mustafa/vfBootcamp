package yildirim.vfBootcamp.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yildirim.vfBootcamp.Entity.User;
import yildirim.vfBootcamp.Repository.UserRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    //
    private final UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }
}
