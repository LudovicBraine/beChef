package com.salty.bechef.service.impl;

import com.salty.bechef.entities.User;
import com.salty.bechef.repository.UserRepository;
import com.salty.bechef.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Number getUserCount() {
        return this.userRepository.count();
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return this.userRepository.findById(id);
    }
}
