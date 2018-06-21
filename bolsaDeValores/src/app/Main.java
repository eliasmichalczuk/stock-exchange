package app;

import DAO.Connect;


/**
 * @author UDESC
 */
public class Main{
    private static Connect bd;
    private static BDV bdv;
    private static VisualizarEmpresas empresa;
            
    public static void main(String[] args){
        bd = new Connect();
        
        
        bdv = new BDV();
        bdv.setVisible(true);
        empresa = new VisualizarEmpresas();
        empresa.setVisible(true);
        
        
    }
    
    public static Connect getBD(){
        return bd;
    }
    
    public static void showBDV(){
        bdv.setVisible( true );
    }
    
    public static void showGrafico() throws Exception
    {
        String[] args = {};
        SwingWorkerRealTime.main(args);
    }


    
}
