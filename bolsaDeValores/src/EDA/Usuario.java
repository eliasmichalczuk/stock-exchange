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
    public int id;
    public String cpf;
    public String cnpj;
    public String nome;
    public String senha;
    public String email;

    public Usuario(int id, String cpf, String cnpj, String nome, String senha, String email) {
        this.id = id;
        this.cpf = cpf;
        this.cnpj = cnpj;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }
}
