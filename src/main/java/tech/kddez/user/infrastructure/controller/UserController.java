package tech.kddez.user.infrastructure.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.kddez.user.application.usecases.UserInteractor;
import tech.kddez.user.domain.entity.User;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserInteractor userInteractor;
    private final UserDTOMapper mapper;

    public UserController(UserInteractor userInteractor, UserDTOMapper mapper) {
        this.userInteractor = userInteractor;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request){
        User user = mapper.toUser(request);
        User createdUser = userInteractor.createUser(user);
        return ResponseEntity.ok(mapper.toResponse(createdUser));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") Long id){
        User user = userInteractor.getUserById(id);
        return ResponseEntity.ok(mapper.toResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> findAll(){
        List<User> users = userInteractor.findAll();
        return ResponseEntity.ok(users.stream().map(mapper::toResponse).toList());
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable("id") Long id, @RequestBody UserRequest request){
        User user = mapper.toUser(request);
        User updatedUser = userInteractor.updatedUser(id, user);
        return ResponseEntity.ok(mapper.toResponse(updatedUser));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id){
        userInteractor.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
