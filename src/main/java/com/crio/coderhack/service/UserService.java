package com.crio.coderhack.service;

import com.crio.coderhack.model.UserEntity;
import com.crio.coderhack.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    public UserEntity registerUser(UserEntity user) {
        user.setScore(0);
        user.setBadges(new HashSet<>());
        return userRepository.save(user);
    }

    public List<UserEntity> getAllUsersSortedByScore() {
        List<UserEntity> users = userRepository.findAll();
        users.sort((u1, u2) -> Integer.compare(u2.getScore(), u1.getScore()));
        return users;
    }

    public Optional<UserEntity> getUserById(String userId) {
        return userRepository.findById(userId);
    }

    public UserEntity updateScore(String userId, int newScore) {
        Optional<UserEntity> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            UserEntity user = userOptional.get();
            user.setScore(newScore);
            return userRepository.save(user);
        }
        throw new IllegalArgumentException("User not found");
    }

    public void deleteUserById(String userId) {
        userRepository.deleteById(userId);
    }
}
