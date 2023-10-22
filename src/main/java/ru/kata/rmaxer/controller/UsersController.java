package ru.kata.rmaxer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.rmaxer.model.User;
import ru.kata.rmaxer.service.UserService;


@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users/users";
    }

    @GetMapping("/user")
    public String getUser(@RequestParam(value = "id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/user";
    }

    @GetMapping("/new")
    public String getNewUser(@ModelAttribute("newUser") User newUser) {
        return "users/new";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("newUser") User newUser) {
        userService.createUser(newUser);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String getEditUser(@RequestParam("id") int id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "users/edit";
    }


    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam(value = "id") int id) {
        userService.removeUser(id);
        return "redirect:/users";
    }
}
