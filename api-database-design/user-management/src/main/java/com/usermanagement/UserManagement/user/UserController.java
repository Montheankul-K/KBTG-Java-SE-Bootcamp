package com.usermanagement.UserManagement.user;

// import com.usermanagement.UserManagement.mail.GoogleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    List<User> users = new ArrayList<>(
            List.of(
                    new User(1,"user1",25,true),
                    new User(2,"user2",26,false),
                    new User(3,"user3",27,true)
            )
    );

    private final UserService userService;
    // controller depend on service
    @Autowired
    public UserController(UserService userService) {
        // GoogleMailService googleMailService = new GoogleMailService();
        // this.userService = new UserService(googleMailService);
        this.userService = userService;
    }

    @GetMapping("api/users") // repersent http get method
    public List<User> getUsers(@RequestParam("active") Optional<Boolean> active) {
        return userService.getUsers(active);
    }

    @PostMapping("api/users") // represent http post method
    public User createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @PutMapping("api/users/{id}") // repersent to http put method
    public void editUser(@PathVariable("id") int id, @RequestBody UserRequest request) {
        userService.editUser(id, request);
    }

    @DeleteMapping("api/users/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
    }
}

// defind contract for request body
record UserRequest(String name, int age) {}

class User {
    private int id;
    private String name;
    private int age;
    private Boolean active;

    public User(int id, String name, int age, Boolean active) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.active = active;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Boolean getActive() {
        return active;
    }

    public void setName(String name) {
        this.name = name;
    }
}
