package me.project.simpleBlog.service;

import lombok.RequiredArgsConstructor;
import me.project.simpleBlog.domain.User;
import me.project.simpleBlog.dto.AddUserRequest;
import me.project.simpleBlog.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public Long save(AddUserRequest addUserRequest) {
        return userRepository.save(User.builder()
                .email(addUserRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(addUserRequest.getPassword()))
                .build()).getId();
    }
}
