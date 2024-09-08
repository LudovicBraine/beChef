package com.salty.bechef.mapper;

import com.salty.bechef.entities.User;
import com.salty.bechef.entities.dto.UserDTO;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel =  "spring")
public interface UserMapper  {
    @Mapping(target="id", source ="user.id")
    @Mapping(target="firstname", source="user.firstname")
    @Mapping(target="lastname", source="user.lastname")
    @Mapping(target="email", source="user.email")
    UserDTO userDTOToUser(User user);

    @InheritInverseConfiguration
    User userToUserDTO(UserDTO userDTO);

    List<UserDTO> listUserToListUserDTO(List<User> userList);

    List<User> listUserDTOToListUser(List<UserDTO> userDTOList);
}
