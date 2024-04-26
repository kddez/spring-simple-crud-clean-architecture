package tech.kddez.user.infrastructure.controller;

public record UserRequest(String username, String password, String email) {
}
