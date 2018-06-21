/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EDA;

/**
 *
 * @author Elias
 */
public class Usuario {
    public String cpf;
    public String nome;
    public String senha;
    public int idade;
    public String email;

    public Usuario( String cpf, String nome, String senha, int idade, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.email = email;
    }

}
