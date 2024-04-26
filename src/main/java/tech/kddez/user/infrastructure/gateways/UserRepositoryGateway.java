package tech.kddez.user.infrastructure.gateways;

import tech.kddez.user.application.gateways.UserGateway;
import tech.kddez.user.domain.entity.User;
import tech.kddez.user.infrastructure.persistence.UserRepository;
//Implementa a interface UserGateway, que é uma estrutura genérica.
public class UserRepositoryGateway implements UserGateway {

    private  final UserRepository userRepository;
    private final UserEntityMapper userEntityMapper;

    public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        this.userRepository = userRepository;
        this.userEntityMapper = userEntityMapper;
    }

    @Override
    public User createUser(User user) {
        var userEntity = userEntityMapper.toEntity(user);
        var savedEntity = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedEntity);
    }

}
