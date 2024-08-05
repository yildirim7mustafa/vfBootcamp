package yildirim.vfBootcamp.Controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import yildirim.vfBootcamp.Entity.User;
import yildirim.vfBootcamp.Repository.UserRepository;
import yildirim.vfBootcamp.Service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;

    // get all users
    @GetMapping("getAllUsersssss")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("addUser")
    public ResponseEntity<User> addNews(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }
}
