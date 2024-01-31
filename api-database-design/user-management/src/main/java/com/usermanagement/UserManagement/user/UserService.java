package com.usermanagement.UserManagement.user;

// import com.usermanagement.UserManagement.mail.GoogleMailService;
import com.usermanagement.UserManagement.mail.MailService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserService {
    List<User> users = new ArrayList<>(
            List.of(
                    new User(1,"user1",25,true),
                    new User(2,"user2",26,false),
                    new User(3,"user3",27,true)
            )
    );

    private final MailService mailService;

    public UserService(@Qualifier("googleMail") MailService mailService) {
        // spring auto inject MailService
        // this.googleMailService = new GoogleMailService();
        // this.googleMailService.setUrl("mail.google.com");
        // this.googleMailService.setPort("42");
        this.mailService = mailService;
    }

    public List<User> getUsers(Optional<Boolean> active) {
        if (active.isPresent()) {
            return users.stream().filter(u -> u.getActive() == active.get()).toList();
        }
        return users;
    }

    public User createUser(UserRequest request) {
        Optional<Integer> maxId = users.stream().map(User::getId).max(Integer::compareTo);
        // optional id มีโอกาสที่จะไม่มีข้อมูล
        int nextId = maxId.orElse(0) + 1; // not have maxId = 0 + 1 else maxId + 1
        User user = new User(nextId, request.name(), request.age(), true);
        users.add(user);

        // send email
        mailService.sendEmail("dev@gmail.com", "user created");
        return user;
    }

    public void editUser(int id, UserRequest request) {
        Optional<User> user = users.stream().filter(u -> u.getId() == id).findFirst();

        if (user.isPresent()) {
            User u = user.get();
            u.setName(request.name());
        }
    }

    public void deleteUser(int id) {
        users.removeIf(u -> u.getId() == id);
    }
}
