package com.example.portaChamados.service.exceptions;

public class ResourceNotFoundExeption extends RuntimeException{
    public ResourceNotFoundExeption(Object id) {
        super("Usuario não autenticado: " + id);
    }
}
