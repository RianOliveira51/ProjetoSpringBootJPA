package com.example.portaChamados.service;

import com.example.portaChamados.entities.Called;
import com.example.portaChamados.entities.DTO.AddTechniciansToCalledDto;
import com.example.portaChamados.entities.Technicians;
import com.example.portaChamados.entities.enums.CalledStatus;
import com.example.portaChamados.repositories.CalledRepository;
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
public class CalledService {

    @Autowired
    private CalledRepository calledRepository;

    @Autowired
    private TecnicianService tecnicianService;

    public List<Called> findAll(){ return calledRepository.findAll(); }

    public List<Called> findStatus(Integer status){
        return calledRepository.findByStatus(status);
    }


    public Called findById(Integer id){
        Optional<Called> called = calledRepository.findById(id);
        return  called.orElseThrow(() -> new ResourceNotFoundExeption("Called not found"));
    }

    public Called insert(Called called){
        return calledRepository.save(called);
    }

    public void  delete(Integer id){
        try{
            calledRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundExeption(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Called update(Integer id, Called called){
        try{
            Called entity = calledRepository.getReferenceById(id);
            updateData(entity, called);
            return calledRepository.save(entity);
        }catch (EntityNotFoundException e ){
            throw new ResourceNotFoundExeption(id);
        }
    }

    public void updateData(Called entity,Called called){
        entity.setStatus(called.getStatus());
        entity.setText(called.getText());

    }

    public void addTecnicians(AddTechniciansToCalledDto dto){
       Called called = findById(dto.getCalledsId());
       Technicians technicians = tecnicianService.findById(dto.getTechniciansId());
       called.setTechnicians(technicians);
       calledRepository.save(called);
    }
}
