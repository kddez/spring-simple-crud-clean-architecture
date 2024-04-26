package tech.kddez.user.infrastructure.gateways;

import tech.kddez.user.domain.entity.User;
import tech.kddez.user.infrastructure.persistence.UserEntity;

public class UserEntityMapper {

    UserEntity toEntity(User userDomain){
        return new UserEntity(userDomain.username(), userDomain.password(), userDomain.email());
    }

    User toDomain(UserEntity userEntity){
        return new User(userEntity.getUsername(), userEntity.getPassword(), userEntity.getEmail());
    }

}
