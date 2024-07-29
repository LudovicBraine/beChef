package com.salty.bechef.service;

import com.salty.bechef.entities.User;

import java.util.Optional;

public interface UserService {
    Number getUserCount();
    Optional<User> getUserById(Long id);
}
