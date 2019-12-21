package nz.students.forsdi.chinchilla.dao;

import nz.students.forsdi.chinchilla.entity.User;

import java.util.List;

public interface UserDAO {
    public List<User> getUsers();

    public void saveUser(User theUser);

    public User getUser(int id);

    public void deleteUser(int id);
}
