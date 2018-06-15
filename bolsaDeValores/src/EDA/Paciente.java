package EDA;

/**
 * @author UDESC
 */
public class Paciente {
    public int codp;
    public String nome;
    public String cpf;
    public int idade;
    public String cidade;
    
    public Paciente(int cod, String nom, String cpf, int ida, String cid){
        codp = cod;
        nome = nom;
        this.cpf = cpf;
        idade = ida;
        cidade = cid;
    }
}
