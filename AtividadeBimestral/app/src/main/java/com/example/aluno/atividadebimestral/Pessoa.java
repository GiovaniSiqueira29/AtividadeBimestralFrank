package com.example.aluno.atividadebimestral;

import com.orm.SugarRecord;

public class Pessoa extends SugarRecord {

    private String nome;
    private Integer idade;
    private String qtdeDepositoEncontrado;
    private double multa;

    public Pessoa() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getQtdeDepositoEncontrado() {
        return qtdeDepositoEncontrado;
    }

    public void setQtdeDepositoEncontrado(String qtdeDepositoEncontrado) {
        this.qtdeDepositoEncontrado = qtdeDepositoEncontrado;
    }

    public double getMulta() {
        return multa;
    }

    public void setMulta(double multa) {
        this.multa = multa;
    }
}
