package tech.kddez.user.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.kddez.user.application.gateways.UserGateway;
import tech.kddez.user.application.usecases.CreateUserInteractor;
import tech.kddez.user.infrastructure.controller.UserDTOMapper;
import tech.kddez.user.infrastructure.gateways.UserEntityMapper;
import tech.kddez.user.infrastructure.gateways.UserRepositoryGateway;
import tech.kddez.user.infrastructure.persistence.UserRepository;

@Configuration
public class UserConfig {

    @Bean
    CreateUserInteractor createUserCase(UserGateway userGateway) {
        return new CreateUserInteractor(userGateway);
    }

    @Bean
    UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
        return new UserRepositoryGateway(userRepository, userEntityMapper);
    }

    @Bean
    UserEntityMapper userEntityMapper() {
        return new UserEntityMapper();
    }

    @Bean
    UserDTOMapper userDTOMapper() {
        return new UserDTOMapper();
    }

}
