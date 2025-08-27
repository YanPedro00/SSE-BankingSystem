package com.banksse;

public class BankUserInformation {
    private  String name;
    private  String cpf;
    private  Integer cep;
    private  String birthday;

    public BankUserInformation(String name, String cpf, Integer cep, String birthday){
        this.name = name;
        this.cpf = cpf;
        this.cep = cep;
        this.birthday = birthday;
    }
}