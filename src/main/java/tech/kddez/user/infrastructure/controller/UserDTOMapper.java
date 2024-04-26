package tech.kddez.user.infrastructure.controller;

import tech.kddez.user.domain.entity.User;

public class UserDTOMapper {

    public User toUser(CreateUserRequest request){
        return new User(request.username(), request.password(), request.email());
    }

    public CreateUserResponse toResponse(User user){
        return new CreateUserResponse(user.username(), user.email());
    }

}
