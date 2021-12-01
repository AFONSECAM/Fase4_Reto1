package com.reto1_ciclo4.reto1.Service;

import com.reto1_ciclo4.reto1.Models.User;
import com.reto1_ciclo4.reto1.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll(){
        return userRepository.getAll();
    }

    public Optional<User> getUser(int id){
        return userRepository.getUser(id);
    }

    public User registrar(User user){
        if(user.getId() == null){
            if(emailExists(user.getEmail()) == false){
                return userRepository.save(user);
            }else{
                return user;
            }
        }else{
            return user;
        }
    }

    public boolean emailExists(String email){
        return userRepository.emailExists(email);
    }

    public User iniciarSesion(String email, String password){
        Optional<User> user = userRepository.iniciarSesion(email, password);
        if(user.isEmpty()){
            return new User(email, password, "NO DEFINIDO");
        }else{
            return user.get();
        }
    }
}
