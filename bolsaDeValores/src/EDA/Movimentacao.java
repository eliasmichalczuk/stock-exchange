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
public class Movimentacao {
    public int movimentacaoTipo_id;
    public int empresa_id;
    public double valorAcao;
    public int valorAcoes;

    public Movimentacao(int movimentacaoTipo_id, int empresa_id, double valorAcao, int valorAcoes) {
        this.movimentacaoTipo_id = movimentacaoTipo_id;
        this.empresa_id = empresa_id;
        this.valorAcao = valorAcao;
        this.valorAcoes = valorAcoes;
    }
    
    
}
