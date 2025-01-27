package com.example.portaChamados.entities.enums;

public enum CalledStatus {
    Open(1),
    Assigned(2),
    Pendants(3),
    Closed(4);

    private int cod;

    private CalledStatus(int cod) { this.cod = cod;}

    public int getCod() { return cod; }

    public static CalledStatus valuefOf(int code){
        for(CalledStatus c : CalledStatus.values()){
            if(c.getCod() == code){
                return c;
            }
        }
        throw new IllegalArgumentException("Status não existe " + code);
    }
}
