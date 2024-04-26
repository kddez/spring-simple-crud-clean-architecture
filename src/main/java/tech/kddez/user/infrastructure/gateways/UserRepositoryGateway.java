package tech.kddez.user.infrastructure.gateways;

import tech.kddez.user.application.gateways.UserGateway;
import tech.kddez.user.domain.entity.User;
import tech.kddez.user.domain.exceptions.UserNotFoundException;
import tech.kddez.user.infrastructure.persistence.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    @Override
    public User getUserById(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        return userEntityMapper.toDomain(user);
    }

    @Override
    public List<User> findAll() {
        var users = userRepository.findAll()
                .stream()
                .map(userEntityMapper::toDomain)
                .collect(Collectors.toList());
        return users;
    }

    @Override
    public void deleteUser(Long id) {
        var user = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);
        userRepository.delete(user);
    }

    @Override
    public User updateUser(Long id, User user) {
        var userEntity = userRepository.findById(id)
                .orElseThrow(UserNotFoundException::new);

        if (user.username() != null){
            userEntity.setUsername(user.username());
        }

        if(user.email() != null){
            userEntity.setEmail(user.email());
        }

        var savedEntity = userRepository.save(userEntity);
        return userEntityMapper.toDomain(savedEntity);
    }

}
