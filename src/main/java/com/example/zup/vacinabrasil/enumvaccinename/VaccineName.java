package com.example.zup.vacinabrasil.enumvaccinename;

public enum VaccineName {
    ASTRAZENECA(1), CORONAVAC(2);
    private final int valor;
    VaccineName(int valor){
        this.valor = valor;
    }
}
