package tech.kddez.user.infrastructure.controller;

public record CreateUserRequest(String username, String password, String email) {
}
