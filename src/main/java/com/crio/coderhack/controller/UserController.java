package com.crio.coderhack.controller;
import com.crio.coderhack.model.UserEntity;
import com.crio.coderhack.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@Validated
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public ResponseEntity<Object> registerUser(@RequestBody UserEntity user) {
        UserEntity registeredUser = userService.registerUser(user);
        return new ResponseEntity<>(registeredUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<UserEntity>> getAllUsers() {
        List<UserEntity> users = userService.getAllUsersSortedByScore();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable String userId) {
        Optional<UserEntity> user = userService.getUserById(userId);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{userId}/score")
    public ResponseEntity<Object> updateScore(@PathVariable String userId, @RequestParam int score) {
        if (score < 0 || score > 100) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        UserEntity updatedUser = userService.updateScore(userId, score);
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
