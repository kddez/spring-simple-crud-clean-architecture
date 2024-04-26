package tech.kddez.user.infrastructure.gateways;

import tech.kddez.user.domain.entity.User;
import tech.kddez.user.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    UserEntity toEntity(User userDomain){
        return new UserEntity(userDomain.username(), userDomain.email(), userDomain.password());
    }

    User toDomain(UserEntity userEntity){
        return new User(userEntity.getUsername(), userEntity.getUsername(), userEntity.getPassword());
    }

}
