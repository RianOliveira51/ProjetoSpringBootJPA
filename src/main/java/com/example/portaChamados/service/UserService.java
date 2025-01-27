package com.example.portaChamados.service;

import com.example.portaChamados.entities.User;
import com.example.portaChamados.repositories.UserRepository;
import com.example.portaChamados.service.exceptions.DatabaseException;
import com.example.portaChamados.service.exceptions.ResourceNotFoundExeption;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findALL() {
        return userRepository.findAll();
    }

    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundExeption(id));
    }

    public User insert(User obj) {
        return obj = userRepository.save(obj);
    }

    public void delete(Integer id) {
        try {
            userRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundExeption(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public User update(Integer id, User obj) {
        try{
            User entity = userRepository.getReferenceById(id);
            updateData(entity, obj);
            return userRepository.save(entity);
        }catch (EntityNotFoundException e ){
            throw new ResourceNotFoundExeption(id);
        }
    }

   public void updateData( User entity, User obj){
        entity.setName(obj.getName());
        entity.getUsername();
        entity.setPassword(obj.getPassword());
   }

}
