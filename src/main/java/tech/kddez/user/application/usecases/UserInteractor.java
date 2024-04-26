package tech.kddez.user.application.usecases;

import tech.kddez.user.application.gateways.UserGateway;
import tech.kddez.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

// Camada Service, mas que não pode ter dependencia com Framework, para que proteja as regras de negócio.
public class UserInteractor {
    private final UserGateway userGateway;

    public UserInteractor(UserGateway userGateway) {
        this.userGateway = userGateway;
    }

    public User createUser(User user) {
        return userGateway.createUser(user);
    }
    public User getUserById(Long id){
        return userGateway.getUserById(id);
    }
    public List<User> findAll(){
        return userGateway.findAll();
    }
    public void deleteUser(Long id){
        userGateway.deleteUser(id);
    }
    public User updatedUser(Long id, User user){
        return userGateway.updateUser(id, user);
    }
}
