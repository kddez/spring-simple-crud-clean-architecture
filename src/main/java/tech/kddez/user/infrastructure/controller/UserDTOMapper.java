package tech.kddez.user.infrastructure.controller;

import tech.kddez.user.domain.entity.User;

public class UserDTOMapper {

    public User toUser(UserRequest request){
        return new User(request.username(), request.password(), request.email());
    }

    public UserResponse toResponse(User user){
        return new UserResponse(user.username(), user.email());
    }

}
