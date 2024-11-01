package com.example.MolotokSpringSecurtiyApp.controllers;


import com.example.MolotokSpringSecurtiyApp.models.Application;
import com.example.MolotokSpringSecurtiyApp.models.MyUser;
import com.example.MolotokSpringSecurtiyApp.services.AppService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/apps")
@AllArgsConstructor


public class AppController {
    private AppService service;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome to the unprotected page";
    }

    @GetMapping("/all-app")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public List<Application> allApplication() {
        return service.allAplications();
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public Application applicationByID(@PathVariable int id) {
        return service.applicationByID(id);
    }



@PostMapping("/new-user")
        public  String addUser(@RequestBody MyUser user){
        service.addUser(user);
        return  "User is saved";
}
}
