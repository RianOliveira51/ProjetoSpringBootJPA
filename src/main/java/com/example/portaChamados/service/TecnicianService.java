package com.example.portaChamados.service;

import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.repositories.TechniciansRepository;
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
public class TecnicianService {

   @Autowired
    private TechniciansRepository techniciansRepository;

   public List<Technicians> findAll() {
       return techniciansRepository.findAll();
   }

   public Technicians findById(Integer id) {
       Optional<Technicians> obj = techniciansRepository.findById(id);
       return obj.orElseThrow(() -> new ResourceNotFoundExeption("Technician not found"));
   }

    public Technicians insert(Technicians obj) {
        return obj = techniciansRepository.save(obj);
    }

    public void delete(Integer id) {
        try {
            techniciansRepository.deleteById(id);
        }catch(EmptyResultDataAccessException e){
            throw new ResourceNotFoundExeption(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Technicians update(Integer id, Technicians obj) {
        try{
            Technicians entity = techniciansRepository.getReferenceById(id);
            updateData(entity, obj);
            return techniciansRepository.save(entity);
        }catch (EntityNotFoundException e ){
            throw new ResourceNotFoundExeption(id);
        }
    }

    public void updateData( Technicians entity, Technicians obj){
        entity.setName(obj.getName());
        entity.getLogin();
        entity.setPassword(obj.getPassword());
    }

    public Technicians loadUserBylogin(String login, String password) throws ResourceNotFoundExeption {
       Technicians th = techniciansRepository.findByLoginAndPassword(login,password);
       if(th == null){
           throw new ResourceNotFoundExeption("Usuario não encontrado" + login);
       }
       return th;
    }
}
