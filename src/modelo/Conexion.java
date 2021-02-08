package modelo;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Conexion {
    
    private final String baseD = "ReportesAJ";
    private final String userD = "desarrollo";
    private final String passwordD = "holalaparis";
    //private final String urlD = "jdbc:mysql://192.168.10.99/" + baseD;
    private final String urlD = "jdbc:mysql://172.31.10.239/" + baseD;
    private Connection con = null;

    
    
    private ResultSet rs;
    private PreparedStatement ps;
    
    public Connection getConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(urlD,userD, passwordD);
            if(con!=null){
               System.out.println("Conexion establecida"); 
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("No se pudo establecer conexion. Detalle:  "+e);
        }
        return con;
    }
    
    public Connection closeConexion(){
        this.con=null;
        System.out.println("Conexion terminada");
        return con;
        
    }
    
    public Connection openConexion(){
        getConexion();
        return con;
    }
    
      public ResultSet listarRegistros() {
    
            String sql = "SELECT * FROM `queryreport` where estado=1";
        try {
            ps = getConexion().prepareStatement(sql);
            rs = ps.executeQuery();
            closeConexion();
        } catch (Exception e) {
            System.err.println("Error  " + e);
        }
        return rs;
    }
}
