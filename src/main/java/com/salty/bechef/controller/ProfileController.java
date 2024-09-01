package com.salty.bechef.controller;

import com.salty.bechef.entities.dto.UserDTO;
import com.salty.bechef.exception.NotFoundException;
import com.salty.bechef.mapper.UserMapper;
import com.salty.bechef.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/profile")
@RequiredArgsConstructor
public class ProfileController {

    private final UserServiceImpl userService;
    private final UserMapper userMapper;

    @GetMapping("/total")
    public ResponseEntity<Number> getUserTotal() {
        Number userTotal = this.userService.getUserCount();
        return new ResponseEntity<>(userTotal, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {

        try {
            UserDTO userDTO = this.userMapper.userDTOToUser(this.userService.getUserById(id).orElseThrow());
            return new ResponseEntity<>(userDTO, HttpStatus.OK);
        } catch (Exception e) {
            throw new NotFoundException(NotFoundException.NotFoundExceptionType.USER_NOT_FOUND, e);
        }
    }
}

