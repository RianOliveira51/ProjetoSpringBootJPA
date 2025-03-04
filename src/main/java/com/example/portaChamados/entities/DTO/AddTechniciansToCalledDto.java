package com.example.portaChamados.entities.DTO;

import java.util.Objects;

public class AddTechniciansToCalledDto {
    private int techniciansId;
    private int calledsId;

    public int getTechniciansId() {
        return techniciansId;
    }

    public void setTechniciansId(int techniciansId) {
        this.techniciansId = techniciansId;
    }

    public int getCalledsId() {
        return calledsId;
    }
}
