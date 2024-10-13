package service;

import model.User;

import java.util.Collection;

public interface UserService {
    void add(User user);
    User get(int id);
    Collection<User> getAll();
    User getByEmail(String email);
    void update(User user);
    void delete(User user);
}
