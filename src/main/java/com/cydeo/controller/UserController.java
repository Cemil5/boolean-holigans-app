package com.cydeo.controller;

import com.cydeo.dto.UserDto;
import com.cydeo.enums.State;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/create")
    public String createForm(Model model){
        model.addAttribute("user",new UserDto());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("states", State.values());
        model.addAttribute("users",userService.findAll());
        return "/user/user-create";
    }

    @PostMapping("/create")
    public String insertUser(@ModelAttribute("user") UserDto user,Model model){

        userService.save(user);

        return "redirect:/user/create";

    }

    @GetMapping("/update/{username}")
    public String editUser(@PathVariable("username") String username, Model model){

        model.addAttribute("user",userService.findById(username));
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("states", State.values());
        model.addAttribute("users",userService.findAll());

        return "/user/user-update";

    }
    @PostMapping("/update")
    public String updateUser(@ModelAttribute("user") UserDto user, BindingResult bindingResult, Model model){
        if (bindingResult.hasErrors()){
            model.addAttribute("roles",roleService.findAll());
            model.addAttribute("users",userService.findAll());
            return "/user/user-update";
        }

        userService.update(user);

        return "redirect:/user/create";
    }
    @GetMapping("/delete/{username}")
    public String deleteUser(@PathVariable("username") String username){

        userService.deleteById(username);

        return "redirect:/user/create";

    }

}
