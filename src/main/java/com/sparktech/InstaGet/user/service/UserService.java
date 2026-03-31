package com.sparktech.InstaGet.user.service;

import com.sparktech.InstaGet.user.dto.UserMapper;
import com.sparktech.InstaGet.user.dto.UserRequestDto;
import com.sparktech.InstaGet.user.dto.UserResponseDto;
import com.sparktech.InstaGet.user.entity.User;
import com.sparktech.InstaGet.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    @Autowired
    private UserMapper userMapper;

    public List<UserResponseDto> findAll() {
        return repo.findAll().stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<UserResponseDto> findById(int id) {
        return repo.findById(id).map(userMapper::toDto);
    }

    public UserResponseDto save(UserRequestDto dto) {
        User saved = repo.save(userMapper.toEntity(dto));
        return userMapper.toDto(saved);
    }

    public UserResponseDto update(int id, UserRequestDto dto) {
        User existing = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        if (dto.getPassword() != null) {
            existing.setPassword(dto.getPassword());
        }
        return userMapper.toDto(repo.save(existing));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
