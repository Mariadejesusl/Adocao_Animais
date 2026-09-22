package br.edu.ifma.adocaoanimais.model;

public class Animal {
	private int id;
    private String nome;
    private String especie;
    private String faixaEtaria;
    private String sexo;
    private String porte;
    private String status;

    public Animal(int id, String nome, String especie, String faixaEtaria,
                  String sexo, String porte, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.faixaEtaria = faixaEtaria;
        this.sexo = sexo;
        this.porte = porte;
        this.status = status;
    }

    public Animal(String nome, String especie, String faixaEtaria,
                  String sexo, String porte, String status) {
        this(0, nome, especie, faixaEtaria, sexo, porte, status);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getPorte() {
        return porte;
    }

    public void setPorte(String porte) {
        this.porte = porte;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nome;
    }
}