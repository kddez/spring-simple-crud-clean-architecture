package tech.kddez.user.application.gateways;

import tech.kddez.user.domain.entity.User;

import java.util.List;

//Estrutura genérica que dita as funcionalidas do crud de um usuário, criando uma abstração.
public interface UserGateway {
    User createUser(User user);
    User getUserById(Long id);
    List<User> findAll();
    void deleteUser(Long id);
    User updateUser(Long id, User user);
}
