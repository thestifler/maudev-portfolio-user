package maudev.portfolio.user.service;

import java.util.List;

import maudev.portfolio.user.entity.User;

public interface UserService {
    
    public List<User> getAllUsers();
    public User getUser(Long id);

    public User createUser(User user);
    public User updateUser(User user);
    public User deleteUser(Long id);
}
