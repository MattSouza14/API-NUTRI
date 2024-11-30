package com.NutriAPI.API_Nutri.model;

import jakarta.persistence.*;


import java.io.Serializable;
import java.math.BigDecimal;
@Entity
@Table(name = "usuarios")
public class PacienteModel implements Serializable {
   // private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(nullable = false, unique = true , length = 100)
    private String email;

    @Column(nullable = false , length = 100)
    private String senha;

    @Column(nullable = true , length = 100)
    private String telefone;

   // @Column(nullable = false , length = 100)
   // private String genero;

    @Column(unique = true, nullable = false)
    private String cpf;

   // @Column
   // private BigDecimal altura;

   // @Column
   // private BigDecimal peso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

   /** public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }**/

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

  /**  public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }**/
}
