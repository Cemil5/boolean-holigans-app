package com.cydeo.controller;

import com.cydeo.dto.UserDto;
import com.cydeo.enums.State;
import com.cydeo.service.RoleService;
import com.cydeo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

//        if (bindingResult.hasErrors()){
//            model.addAttribute("roles",roleService.findAll());
//            model.addAttribute("states", State.values());
//            model.addAttribute("users",userService.findAll());
//            return "/user/user-create";
//        }
        model.addAttribute("user",new UserDto());
        model.addAttribute("roles",roleService.findAll());
        model.addAttribute("users",userService.findAll());
        model.addAttribute("states", State.values());
        userService.save(user);

        return "/user/user-create";

    }
}
