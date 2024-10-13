package repository;

import model.User;

import java.util.Collection;
import java.util.Optional;

public interface UserRepository {
    void save(User user);
    Optional<User> get(int id);
    Collection<User> getAll();
    Optional<User> getByEmail(String email);
    void update(User user);
    void delete(User user);
}
