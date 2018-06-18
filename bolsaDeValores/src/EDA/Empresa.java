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
public class Empresa {
    public int id;
    public String nome;
    public int capitalSocial;
    public int ramo_id;
    public String ramo_desc;

    public Empresa(int id, String nome, int capitalSocial, int ramo_id, String ramo_desc) {
        this.id = id;
        this.nome = nome;
        this.capitalSocial = capitalSocial;
        this.ramo_id = ramo_id;
        this.ramo_desc = ramo_desc;
    }
}
