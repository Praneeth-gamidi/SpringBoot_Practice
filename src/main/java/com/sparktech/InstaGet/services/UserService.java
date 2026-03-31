package com.sparktech.InstaGet.services;

import com.sparktech.InstaGet.Models.User;
import com.sparktech.InstaGet.Repository.UserRepository;
import com.sparktech.InstaGet.dtos.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<UserDto> findAll() {
        return repo.findAll().stream()
                .map(UserDto::fromUser)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findById(int id) {
        return repo.findById(id).map(UserDto::fromUser);
    }

    public UserDto save(UserDto dto, String password) {
        User saved = repo.save(dto.toUser(password));
        return UserDto.fromUser(saved);
    }

    public UserDto update(int id, UserDto dto) {
        User existing = repo.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        existing.setName(dto.getName());
        existing.setEmail(dto.getEmail());
        return UserDto.fromUser(repo.save(existing));
    }

    public void delete(int id) {
        repo.deleteById(id);
    }
}
