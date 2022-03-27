package com.example.springrestfuldemo.service;

import com.example.springrestfuldemo.dao.UserRepository;
import com.example.springrestfuldemo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User deleteUserById(Long id) {
        User user = null;
        Optional optional = userRepository.findById(id);
        if(optional.isPresent()) {
            user = userRepository.findById(id).get();
            userRepository.deleteById(id);
        }
        return user;
    }

    @Override
    public User updateUserById(Long id, User updateUser) {
        User user = null;
        Optional optional = userRepository.findById(id);
        if(optional.isPresent()){
            user = userRepository.findById(id).get();
            user.setEmail(updateUser.getEmail());
            user.setUsername(updateUser.getUsername());
            user.setPassword(updateUser.getPassword());

        }
        return userRepository.save(user);
    }
}
