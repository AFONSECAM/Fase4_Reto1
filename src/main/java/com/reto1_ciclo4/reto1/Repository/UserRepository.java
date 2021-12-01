package com.reto1_ciclo4.reto1.Repository;

import com.reto1_ciclo4.reto1.Interfaces.UserCrudRepository;
import com.reto1_ciclo4.reto1.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {
    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll(){
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id){
        return userCrudRepository.findById(id);
    }

    public User save(User u){
        return userCrudRepository.save(u);
    }

    public boolean emailExists(String email){
        Optional<User> user = userCrudRepository.findByEmail(email);
        return !user.isEmpty();
    }

    public Optional<User> iniciarSesion(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}
