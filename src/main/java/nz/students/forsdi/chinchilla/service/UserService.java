package nz.students.forsdi.chinchilla.service;

import nz.students.forsdi.chinchilla.entity.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();

    public void saveUser(User theUser);

    public User getUser(int theId);

    public void deleteUser(int theId);
}
