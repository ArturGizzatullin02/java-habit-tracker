package repository;

import model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    Map<Integer, User> users = new HashMap<>();
    private int id = 0;

    public InMemoryUserRepository() {
    }

    private int generateId() {
        return id++;
    }

    @Override
    public void save(User user) {
        user.setId(generateId());
        users.put(user.getId(), user);
    }

    @Override
    public Optional<User> get(int id) {
        return Optional.ofNullable(users.get(id));
    }

    @Override
    public Collection<User> getAll() {
        return List.copyOf(users.values());
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return users.values().stream()
                .filter(user -> user.getEmail().equals(email))
                .findFirst();
    }

    @Override
    public void update(User user) {
        user.setName(user.getName());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
    }

    @Override
    public void delete(User user) {
        users.remove(user.getId());
    }
}
