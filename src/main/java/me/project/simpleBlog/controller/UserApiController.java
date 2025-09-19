package me.project.simpleBlog.controller;

import lombok.RequiredArgsConstructor;
import me.project.simpleBlog.dto.AddUserRequest;
import me.project.simpleBlog.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserApiController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(AddUserRequest addUserRequest) {
        userService.save(addUserRequest);
        return "redirect:/login";
    }
}
