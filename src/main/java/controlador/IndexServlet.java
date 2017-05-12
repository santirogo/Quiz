package controlador;
 

import dao.ArtistaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.RequestDispatcher;
import vo.ArtistaVO;
import vo.ObraDeArteVO;
 
/**
 * @author Crunchify.com
 */
 
public class IndexServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // reading the user input
        
        //Se debe incluir validaciones - Lo recuerda: Gestion de Excepciones.
        ArtistaDAO dao = new ArtistaDAO();
        ArtistaVO artista = new ArtistaVO();
        ObraDeArteVO obra = new ObraDeArteVO();
        
        artista.setUsuario(request.getParameter("usuario"));
        String nombre = request.getParameter("nombre");
        String descrip = request.getParameter("descripcion");
        String estilo = request.getParameter("estilo");
        double valor = Double.parseDouble(request.getParameter("valor"));
        obra.setNombre(nombre);
        obra.setDescripcion(descrip);
        obra.setEstilo(estilo);
        obra.setValor(valor);
        obra.setArtista(artista);

        boolean metio = dao.insert(obra);
        
        if (!metio) {
            request.setAttribute("mensaje", "ok");
        }else{
            request.setAttribute("mensaje", "error");
        }
        
        //Listando la informacion  
        
        //request.setAttribute("departamentos", departamentos);
       
       
        //Redireccionando la informacion
        RequestDispatcher redireccion = request.getRequestDispatcher("index.jsp");
        redireccion.forward(request, response);
        
        
        }
}
