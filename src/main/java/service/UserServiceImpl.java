package service;

import exception.UserAlreadyExistsException;
import exception.ValidationException;
import model.User;
import repository.InMemoryUserRepository;
import repository.UserRepository;

import java.util.Collection;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new InMemoryUserRepository();

    @Override
    public void add(User user) {
        if (user == null || userRepository.get(user.getId()).isPresent()) {
            throw new ValidationException("Произошла ошибка валидации");
        } else if (userRepository.getByEmail(user.getEmail()).isEmpty()) {
            throw new UserAlreadyExistsException("Пользователь с таким email уже существует");
        } else {
            userRepository.save(user);
        }
    }

    @Override
    public User get(int id) {
        return userRepository.get(id).orElseThrow(() -> new UserAlreadyExistsException("Пользователь не найден"));
    }

    @Override
    public Collection<User> getAll() {
        return userRepository.getAll();
    }

    @Override
    public User getByEmail(String email) {
        return userRepository.getByEmail(email).orElseThrow(() -> new UserAlreadyExistsException("Пользователь не найден"));
    }

    @Override
    public void update(User user) {
        if (user == null || userRepository.get(user.getId()).isPresent()) {
            throw new ValidationException("Произошла ошибка валидации");
        } else {
            userRepository.update(user);
        }
    }

    @Override
    public void delete(User user) {
        if (user == null || userRepository.get(user.getId()).isPresent()) {
            throw new ValidationException("Произошла ошибка валидации");
        } else {
            userRepository.delete(user);
        }
    }
}
