package DAO;
import EDA.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author ELIAS MICHALCZUK RIBEIRO DA SILVA
 */
public class BancoDados {
    static Connection c = null;
    
    private boolean conectar(){
        try {
            //Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgres://localhost:3306/bolsadevalores",
                                            "postgres", "postgres");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
        return true;
    }
    
    
    public ArrayList<Paciente> getPacientes(){
        if( !conectar() ) return null;
        ArrayList<Paciente> resultado = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM pacientes";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int codp = rs.getInt("codp");
                String  name = rs.getString("nome");
                String  cpf = rs.getString("cpf");
                int idade  = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                resultado.add( new Paciente(codp, name, cpf, idade, cidade) );
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getPacientes");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    
    public Paciente getPaciente(int codigo){
        if( !conectar() ) return null;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM pacientes WHERE codp = "+codigo;
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int codp = rs.getInt("codp");
                String  name = rs.getString("nome");
                String  cpf = rs.getString("cpf");
                int idade  = rs.getInt("idade");
                String cidade = rs.getString("cidade");
                resultado = new Paciente(codp, name, cpf, idade, cidade);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    
    
    public boolean cadastrarPaciente(Paciente p){
        if( !conectar() ) return false;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "INSERT INTO pacientes (codp, nome, cpf, idade, cidade)"
                    + "VALUES ("+p.codp+", '"+p.nome+"', '"+p.cpf+"', "+p.idade+", '"+p.cidade+"')";
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSERÇÃO: cadastrarPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    
    
    public boolean alterarPaciente(Paciente p){
        if( !conectar() ) return false;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "UPDATE pacientes SET nome = '"+p.nome+"', cpf = '"+p.cpf+"', "
                    + "idade = "+p.idade+", cidade = '"+p.cidade+"' "
                    + "WHERE codp = "+p.codp;
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZAÇÃO: alterarPaciente");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
}
