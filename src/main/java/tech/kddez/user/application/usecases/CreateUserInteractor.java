package tech.kddez.user.application.usecases;

import tech.kddez.user.application.gateways.UserGateway;
import tech.kddez.user.domain.entity.User;
// Camada Service, mas que não pode ter dependencia com Framework, para que proteja as regras de negócio.
public class CreateUserInteractor {
    private final UserGateway userGateway;

    public CreateUserInteractor(UserGateway createUser) {
        this.userGateway = createUser;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }

}
