package maudev.portfolio.user.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import maudev.portfolio.user.entity.User;
import maudev.portfolio.user.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    
    private final UserRepository userRepository;
    @Override
    public User createUser(User user) {
        user.setStatus("CREATED");
        user.setCreateat(new Date());
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(Long id) {
       
        User userDB = getUser(id);

        if (userDB == null) {
            return null;
        }

        userDB.setStatus("DELETED");
        return userRepository.save(userDB);
    }

    @Override
    public List<User> getAllUsers() {
        
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        User user = userRepository.findById(id).orElse(null);

        if (user == null) {
            return null;
        }
        return user;
    }

    @Override
    public User updateUser(User user) {
        User userDB = getUser(user.getId());

        if (userDB == null) {
            return null;
        }
        userDB.setName(user.getName());
        userDB.setLastname(user.getLastname());
        userDB.setAboutme(user.getAboutme());
        userDB.setJobposition(user.getJobposition());

        return userRepository.save(userDB);
    }

    @Override
    public User getUserActive(Long id) {
        User userDB = userRepository.findByIdAndStatus(id, "CREATED");
        
        if(userDB == null){
            return null;
        }

        return userDB;
    }

    

    
    
}
