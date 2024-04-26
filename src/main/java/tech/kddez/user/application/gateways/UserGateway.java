package tech.kddez.user.application.gateways;

import tech.kddez.user.domain.entity.User;
//Estrutura genérica que permitirá criar um usuário, criando uma abstração e protejendo as regras de negócio.
public interface UserGateway {
    User createUser(User user);
}
