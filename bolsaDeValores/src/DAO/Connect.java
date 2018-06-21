package DAO;
import static DAO.BancoDados.c;
import EDA.Usuario;
import EDA.UsuarioTipo;
import EDA.Movimentacao;
import EDA.Empresa;
import EDA.Paciente;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @author Elias
 */
public class Connect {
    static Connection c = null;
    
    private static boolean conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres",
                                            "postgres", "postgres");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            return false;
        }
        return true;
    }
    
    
    public ArrayList<Usuario> getUsuario()
    {
        if( !conectar() ) return null;
        ArrayList<Usuario> resultado = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM usuario";
            ResultSet rs = stmt.executeQuery(sql);
            while ( rs.next() ) 
            {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                int idade  = rs.getInt("idade");
                String email = rs.getString("email");
                resultado.add( new Usuario( cpf, nome, senha, idade, email));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getUsuario");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
        }
    
    
    
    
    
    public Usuario getUsuario(String codigo){
        if( !conectar() ) return null;
        Usuario resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM usuario WHERE cpf = "+codigo;
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                String cpf = rs.getString("cpf");
                String nome = rs.getString("nome");
                String senha = rs.getString("senha");
                int idade  = rs.getInt("idade");
                String email = rs.getString("email");
                resultado = new Usuario(cpf, nome, senha, idade, email);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getUsuario");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
    
    
    public boolean cadastrarUsuario(Usuario u){
        if( !conectar() ) return false;
        Paciente resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "INSERT INTO usuario (cpf, nome, senha, idade, email)"
                    + "VALUES ('"+u.cpf+"', '"+u.nome+"', '"+u.senha+"', "+u.idade+", '"+u.email+"')";
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSERÇÃO: cadastrarUsuario");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    
    
     public boolean alterarPaciente(Usuario u){
        if( !conectar() ) return false;
        Usuario resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "UPDATE usuario SET cpf = '"+u.cpf+"', nome = '"+u.nome+"', "
                    + "senha = '"+u.senha+"', idade = "+u.idade+", email = '"+u.email+"'  "
                    + "WHERE cpf = "+u.cpf;
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE ATUALIZAÇÃO: alterarUsuario");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    

    public Empresa getEmpresa(int id){
        if( !conectar() ) return null;
        Empresa resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT * FROM empresa WHERE id = "+id;
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int idd = rs.getInt("id");
                String  nome = rs.getString("nome");
                int  capitalSocial = rs.getInt("capitalSocial");
                int ramo_id = rs.getInt("ramo_id");
                resultado = new Empresa(idd, nome, capitalSocial, ramo_id, null);
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
     public ArrayList<Empresa> getEmpresas(){
        if( !conectar() ) return null;
        ArrayList<Empresa> query = new ArrayList();
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT e.id, e.nome, e.capitalSocial, r.descricao FROM empresa as e JOIN ramo as r ON e.ramo_id=r.id";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                int id = rs.getInt("id");
                String  nome = rs.getString("nome");
                int  capitalSocial = rs.getInt("capitalSocial");
                String ramo_desc = rs.getString("descricao");
                query.add (new Empresa(id, nome, capitalSocial, 0, ramo_desc));
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return query;
    }
    
    
    
    public boolean cadastrarEmpresa(Empresa p){
        if( !conectar() ) return false;
        Empresa resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "INSERT INTO empresa (id, nome, capitalSocial)"
                    + "VALUES ("+p.id+", '"+p.nome+"', '"+p.capitalSocial+"')";
            stmt.executeUpdate( sql );
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE INSERÇÃO: cadastrarEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
            return false;
        }
        return true;
    }
    
    
    
    public boolean alterarEmpresa(Empresa p){
        if( !conectar() ) return false;
        Empresa resultado = null;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "UPDATE pacientes SET nome = '"+p.nome+"', capitalSocial = '"+p.capitalSocial+"' "
                    + "WHERE codp = "+p.id;
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
    
    
    public static double getAcao(int empresa_nome){
        if( !conectar() ) return 0;
        double resultado = 0.00;
        try{
            Statement stmt = null;
            stmt = c.createStatement();
            String sql = "SELECT A.valorAcao FROM movimentacao as A JOIN empresa as B WHERE B.nome like = '%"+empresa_nome+"%' LIMIT 1";
            ResultSet rs = stmt.executeQuery( sql );
            while ( rs.next() ) {
                resultado = (double)rs.getInt("valorAcao");
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( "ERRO DURANTE CONSULTA: getEmpresa");
            System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        }
        return resultado;
    }
    
      public static void main(String[] args) {
        Connect test = new Connect();
        double acao = test.getAcao(1);
          System.out.println(acao);
    }

    public boolean cadastrarMovimentacao(Movimentacao m) throws SQLException {
        if( !conectar() ) return false;
        Movimentacao resultado = null;
        try{
        Statement stmt = null;
            stmt = c.createStatement();
            String sql = "INSERT INTO movimentacao (m.movimentacaoTipo_id, empresa_id, valorAcao, valorAcoes)"
                    + "VALUES ("+m.movimentacaoTipo_id+", "+m.empresa_id+", "+m.valorAcao+", "+m.valorAcoes+")";
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

    
}
