package br.edu.ifma.adocaoanimais.model;

public class Animal {
	private int id;
    private String nome;
    private String especie;
    private int idade;
    private String sexo;
    private String porte;
    private String status;

    public Animal(int id, String nome, String especie, int idade,
                  String sexo, String porte, String status) {
        this.id = id;
        this.nome = nome;
        this.especie = especie;
        this.idade = idade;
        this.sexo = sexo;
        this.porte = porte;
        this.status = status;
    }

    public Animal(String nome, String especie, int idade,
                  String sexo, String porte, String status) {
        this(0, nome, especie, idade, sexo, porte, status);
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
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

