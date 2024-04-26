package tech.kddez.user.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.kddez.user.application.usecases.CreateUserInteractor;
import tech.kddez.user.domain.entity.User;

@RestController
@RequestMapping("users")
public class UserController {

    private final CreateUserInteractor createUser;
    private final UserDTOMapper mapper;

    public UserController(CreateUserInteractor createUser, UserDTOMapper mapper) {
        this.createUser = createUser;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CreateUserResponse> createUser(@RequestBody CreateUserRequest request){
        User user = mapper.toUser(request);
        User createdUser = createUser.createUser(user);
        return ResponseEntity.ok(mapper.toResponse(createdUser));
    }
}
