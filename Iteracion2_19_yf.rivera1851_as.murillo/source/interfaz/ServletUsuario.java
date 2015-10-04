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


public class ServletUsuario extends HttpServlet{
	

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		
		PrintWriter respuesta = response.getWriter( );
		
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		String direccion = request.getParameter("direccion");
		String telefono = request.getParameter("telefono");
		String p_cedula = request.getParameter("p_cedula");
		String nacionalidad = request.getParameter("nacionalidad");
		String ciudad = request.getParameter("ciudad");
		String departamento = request.getParameter("departamento");
		String codigoPostal = request.getParameter("codigoPostal");
		String rol = request.getParameter("rol");
		
		
	    if( email != null && nombre != null && direccion != null && telefono != null && p_cedula != null 
	    		&& nacionalidad != null && ciudad != null && ciudad != null && departamento != null
	    		&& codigoPostal != null && rol != null )
	    {

	        try {
				BancAndes.darInstancia().agregarUsuario(email, nombre, direccion, telefono, Integer.parseInt(p_cedula),
						nacionalidad, ciudad, departamento, Integer.parseInt(codigoPostal), rol);
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        respuestaUsuario(response, respuesta, email, nombre, direccion, telefono, p_cedula, nacionalidad, ciudad, departamento, codigoPostal, rol);
	    }
	    
	    else {
			response(response, "invalid login");
		}
	}
	
    private void response(HttpServletResponse resp, String msg)
		throws IOException {
	PrintWriter out = resp.getWriter();
	out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\"" +
		" \"http://www.w3.org/TR/html4/loose.dtd\">");
	out.println("<html>");
	out.println("<head>");
	out.println("<meta http-equiv=\"Content-Type\" content=\"text/html; " +
		"charset=ISO-8859-1\">");
	out.println("<title>Login result</title>");
	out.println("</head>");
	out.println("<body>");
	out.println("<t1>" + msg + "</t1>");
	out.println("</body>");
    }
	    
	private void respuestaUsuario(HttpServletResponse resp, PrintWriter respuesta1, String email, String nombre, String direccion, String telefono, 
			String p_cedula, String nacionalidad, String ciudad, String departamento, String codigoPostal, String rol)
			throws IOException {

		respuesta1.write( "                      <form method=\"POST\" action=\"usuario.htm\">\r\n" );
        respuesta1.write( "                          <table border=\"0\" width=\"100%\" id=\"table5\">\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Email:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"email\" size=\"26\" class=\"normal\" value=\"" + email + "\"></td>\r\n" );
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
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Cedula:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"p_cedula\" size=\"26\" class=\"normal\" value=\"" + p_cedula + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Nacionalidad:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"nacionalidad\" size=\"26\" class=\"normal\" value=\"" + nacionalidad + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Ciudad:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"ciudad\" size=\"26\" class=\"normal\" value=\"" + ciudad + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Departamento:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"departamento\" size=\"26\" class=\"normal\" value=\"" + departamento + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Codigo Postal:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"CodigoPostal\" size=\"26\" class=\"normal\" value=\"" + codigoPostal + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );                                
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Rol:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <select size=\"1\" name=\"curso\" class=\"normal\">\r\n" );
        respuesta1.write( "                                  <option value=\"administrador\"" + ( "administrador".equals( rol ) ? " selected" : "" ) + ">administrador</option>\r\n" );
        respuesta1.write( "                                  <option value=\"gerente\"" + ( "gerente".equals( rol ) ? " selected" : "" ) + ">gerente</option>\r\n" );
        respuesta1.write( "                                  <option value=\"gerenteOficina\"" + ( "gerenteOficina".equals( rol ) ? " selected" : "" ) + ">gerente oficina</option>\r\n" );
        respuesta1.write( "                                  <option value=\"cajero\"" + ( "cajero".equals( rol ) ? " selected" : "" ) + ">cajero</option>\r\n" );
        respuesta1.write( "                                  <option value=\"usuario\"" + ( "usuario".equals( rol ) ? " selected" : "" ) + ">usuario</option>\r\n" );
        respuesta1.write( "                                  </select></td>\r\n" );
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
