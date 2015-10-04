package interfaz;

import java.io.IOException;


import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Logic.ConsultaDAO;
import face.BancAndes;
import vos.BancoValue;


public class ServletOficina extends HttpServlet{
	

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		PrintWriter respuesta = response.getWriter( );
		
		String id = request.getParameter("id");
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String punto = request.getParameter("punto");
		
		
	    if( id != null && nombre != null && direccion != null && telefono != null && punto != null 
	    	)
	    {

	        try {
				BancAndes.darInstancia().agregarOficina(Double.parseDouble(id), nombre, direccion, telefono, Integer.parseInt(punto));
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        respuestaUsuario(response, respuesta, id, nombre, direccion, telefono, punto);
	    }
	    
	    else {
			response(response, "invalid login");
		}
	}
	
    private void response(HttpServletResponse resp, String msg)
		throws IOException {
	PrintWriter out = resp.getWriter();
	out.println("<html>");
	out.println("<head>");
	out.println("<title>Login result</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<t1>" + msg + "</t1>");
	out.println("</body>");
    }
	
	public void saveUser (HttpServletRequest request) throws Exception, SQLException{

	
	
    }
	
	private void respuestaUsuario(HttpServletResponse resp, PrintWriter respuesta, String id, String nombre, String direccion, String telefono, 
			String punto)
			throws IOException {
		 	
			PrintWriter respuesta1 = resp.getWriter();

		respuesta1.write( "                      <form method=\"POST\" action=\"usuario.htm\">\r\n" );
        respuesta1.write( "                          <table border=\"0\" width=\"100%\" id=\"table5\">\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>id:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"email\" size=\"26\" class=\"normal\" value=\"" + id + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Nombre:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"nombre\" size=\"26\" class=\"normal\" value=\"" + nombre + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>direccion:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"direccion\" size=\"26\" class=\"normal\" value=\"" + direccion + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Telefono:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"telefono\" size=\"26\" class=\"normal\" value=\"" + telefono + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Punto:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"p_cedula\" size=\"26\" class=\"normal\" value=\"" + punto + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\">&nbsp;</td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">&nbsp;</td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>\r\n" );
        respuesta1.write( "                          </table>\r\n" );
        respuesta1.write( "                          <p>\r\n" );
        respuesta1.write( "                          <input type=\"submit\" value=\"Guardar\" name=\"B1\" class=\"normal\">\r\n" );
        respuesta1.write( "                          <input type=\"reset\" value=\"Borrar\" name=\"B2\" class=\"normal\"></p>\r\n" );
        respuesta1.write( "                      </form>\r\n" );

	}
}
