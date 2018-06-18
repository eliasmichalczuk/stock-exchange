package app;

import DAO.Connect;


/**
 * @author UDESC
 */
public class Main {
    private static Connect bd;
    private static BDV window;
    private static VisualizarEmpresas empresa;
            
    public static void main(String[] args){
        bd = new Connect();
        window = new BDV();
        window.setVisible( true );
        empresa = new VisualizarEmpresas();
        empresa.setVisible(true);
    }
    
    public static Connect getBD(){
        return bd;
    }
    
    public static void showBDV(){
        window.setVisible( true );
    }
    
}
