package nz.students.forsdi.chinchilla.rest;

import nz.students.forsdi.chinchilla.entity.User;
import nz.students.forsdi.chinchilla.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {
    @Autowired
    private UserService userService;

    @GetMapping("")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable int userId) {
        User theUser = userService.getUser(userId);
        if (theUser == null) {
            throw new EntityNotFoundException("User id not found:" + userId);
        }
        return theUser;
    }

    @PostMapping("")
    public User addUser(@RequestBody User theUser) {
        //set id to 0 to create a new user instead of update
        theUser.setId(0);
        userService.saveUser(theUser);
        return theUser;
    }

    @PutMapping("")
    public User updateUser(@RequestBody User theUser) {
        userService.saveUser(theUser);
        return theUser;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable int userId) {
        User theUser = userService.getUser(userId);
        if (theUser == null) {
            throw new EntityNotFoundException("User id not found:" + userId);
        }
        userService.deleteUser(userId);
        return "Deleted user id - " + userId;
    }
}
