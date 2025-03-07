package com.example.portaChamados.entities.enums;

public enum CalledStatus {

    Open(1),
    Assigned(2),
    Pendents(3),
    Closed(4);

    private int code;

    private CalledStatus(int code) {
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static CalledStatus valueOf1(int code){
        for(CalledStatus c : CalledStatus.values()){
            if(c.getCode() == code){
                return c;
            }
        }
        throw new IllegalArgumentException("No enum constant " + code);
    }

}
