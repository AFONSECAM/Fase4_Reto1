package com.reto1_ciclo4.reto1.Controller;

import com.reto1_ciclo4.reto1.Models.User;
import com.reto1_ciclo4.reto1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return userService.registrar(user);
    }

    @GetMapping("/{email}/{password}")
    public User iniciarSesion(@PathVariable("email") String email, @PathVariable("password") String password){
        return userService.iniciarSesion(email, password);
    }

    @GetMapping("/{email}")
    public boolean emailExists(@PathVariable("email") String email){
        return userService.emailExists(email);
    }
}
