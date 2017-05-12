package dao;
import vo.ObraDeArteVO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import vo.ArtistaVO;
import vo.UsuarioVO;

/**
 * @author Isabel-Fabian
 * @since 12/08/2015
 * @version 2
 * Clase que permite la gestion de la tabla Depto en la base de datos.
 * 
 * CREATE TABLE Depto(
 *     id_depto integer,
 *     nom_depto varchar(40),
 *     PRIMARY KEY(id_depto)
 * );
 */
 

public class ArtistaDAO {

        /**
	 * Funcion que permite realizar la insercion de un nuevo registro en la tabla Departamento
	 * @param Departamento recibe un objeto de tipo Departamento 
	 * @return boolean retorna true si la operacion de insercion es exitosa.
	 */
	public boolean insert(ObraDeArteVO t) {
		boolean result=false;
		Connection connection=null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
	    String query = " insert into Obra_De_Arte (nombre,descripcion,estilo,valor,usuario)"  + " values (?,?,?,?,?)";
        PreparedStatement preparedStmt=null;
	    try {
			preparedStmt = connection.prepareStatement(query);
                        preparedStmt.setString(1, t.getNombre());
                        preparedStmt.setString(2, t.getDescripcion());
                        preparedStmt.setString(3, t.getEstilo());
                        preparedStmt.setDouble(4, t.getValor());
                        preparedStmt.setString(5, t.getArtista().getUsuario());
			result= preparedStmt.execute();
	    } catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
        
        public ArrayList artistasConMasDe10000DeGanancias(){
            ArrayList registros = null;
            
            String query = "SELECT nombre, sum (valor) as val FROM Artistas JOIN Obra_De_Arte using (usuario) GROUP BY (nombre) having val > 10000";
            
            Connection connection = null;
            try {
                connection = Conexion.getConnection();
            } catch (URISyntaxException ex) {
                Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            Statement st;
            try {
                st = connection.createStatement();
                ResultSet rs = st.executeQuery(query);
                while (rs.next()){
	    	if(registros == null){
	    		registros= new ArrayList();
	    	}
	      
                String nombre = rs.getString("nombre");
                registros.add(nombre);
                double val = rs.getInt("val");
                registros.add(val);
	    }
	    st.close();
            } catch (SQLException ex) {
                Logger.getLogger(ArtistaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            return registros;
        }
}
