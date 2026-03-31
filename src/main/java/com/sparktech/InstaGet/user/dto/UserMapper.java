package com.sparktech.InstaGet.user.dto;

import com.sparktech.InstaGet.user.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    // Converts UserRequestDto -> User entity
    public User toEntity(UserRequestDto dto) {
        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        return user;
    }

    // Converts User entity -> UserResponseDto
    public UserResponseDto toDto(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
