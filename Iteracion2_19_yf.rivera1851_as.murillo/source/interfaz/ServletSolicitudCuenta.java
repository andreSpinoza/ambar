package interfaz;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import face.BancAndes;

public class ServletSolicitudCuenta extends HttpServlet{
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		PrintWriter respuesta = response.getWriter( );
		
		
		//datos de cliente en caso de que sea una solicitud
				String cliente = request.getParameter("cliente");
				String cedula = request.getParameter("cedula");
				String tipodecuenta = request.getParameter("monto");
				String solicitud = request.getParameter("solicitud");
		
	    if( cliente != null && cedula != null && tipodecuenta != null && solicitud != null)
	    {

	        response(response, "se ha agregado su solicitud");
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
	
	public void saveUser (HttpServletRequest request) throws Exception, SQLException{

	
	
    }
    
	private void respuestaPrestamo(HttpServletResponse resp, PrintWriter respuesta, String cliente, String cedula, double monto, String solicitud)
			throws IOException {
		
		 	
			PrintWriter respuesta1 = resp.getWriter();

		respuesta1.write( "                      <form method=\"POST\" action=\"usuario.htm\">\r\n" );
        respuesta1.write( "                          <table border=\"0\" width=\"100%\" id=\"table5\">\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>id:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"email\" size=\"26\" class=\"normal\" value=\"" + cliente + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>interes:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"nombre\" size=\"26\" class=\"normal\" value=\"" + cedula+ "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>monto:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"direccion\" size=\"26\" class=\"normal\" value=\"" + monto + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>Numero de cuotas:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <input type=\"text\" name=\"telefono\" size=\"26\" class=\"normal\" value=\"" + solicitud + "\"></td>\r\n" );
        respuesta1.write( "                              </tr>\r\n" );
        respuesta1.write( "                              <tr>\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>dia de pago:</b></td>\r\n" );
        respuesta1.write( "                                  <td width=\"80%\">\r\n" );
        respuesta1.write( "                                  <td width=\"18%\" align=\"right\"><b>\r\n" );
        respuesta1.write( "                          </table>\r\n" );
        respuesta1.write( "                          <p>\r\n" );
        respuesta1.write( "                          <input type=\"submit\" value=\"Guardar\" name=\"B1\" class=\"normal\">\r\n" );
        respuesta1.write( "                          <input type=\"reset\" value=\"Borrar\" name=\"B2\" class=\"normal\"></p>\r\n" );
        respuesta1.write( "                      </form>\r\n" );

	}
	


}
