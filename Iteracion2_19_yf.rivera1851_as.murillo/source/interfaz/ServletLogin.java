package interfaz;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletLogin extends HttpServlet{

	protected void doGet (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String user = request.getParameter("user");
		String password = request.getParameter("password");
		String rol = request.getParameter("rol");
		
		if ("a".equals(user) && "1".equals(password) && "administrador".equals(rol)) 
			Admin(response, "Administrador");
			
		else if ("a".equals(user) && "1".equals(password) && "gerenteOf".equals(rol)) 
			GerenteOf(response, "Gerente de Oficina");
		
		else if ("a".equals(user) && "1".equals(password) && "cliente".equals(rol)) 
			Cliente(response, "Cliente");
		
		else if ("a".equals(user) && "1".equals(password) && "gerente".equals(rol)) 
			Gerente(response, "Gerente General");
		
		else if ("a".equals(user) && "1".equals(password) && "cajero".equals(rol)) 
			Cajero(response, "Cajero");
			
		else
			response(response, "invalid login");
	
	}
	
	
	private void Admin(HttpServletResponse resp, String msg)
			throws IOException {
		
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"0\" width=\"720\" id=\"table1\">");
		out.println("<h1 align=\"center\">" + msg + "</td>");
		out.println("<form method=\"POST\" action=\"resultado.htm\">");
		out.println("<td width=\"28\">");
		out.println("<p align=\"center\">");
		out.println(" <a href=\"usuario.htm\">");
		out.println("</a></td>");
		out.println("<td><a href=\"AdminRegUsuario.html\">Registrar Usuario</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println(" <td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"oficina.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"AdminRegOficina.html\">Registrar oficina</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"punto.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"AdminPuntoAtencion.html\">Registrar punto de atencion</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"cuenta.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"cuenta.htm\">Consultar Cuentas</a></td>");
        out.println("</tr>");
        out.println("</body>");
        out.println("</html>");

	}
	
	private void GerenteOf(HttpServletResponse resp, String msg)
			throws IOException {
		
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"0\" width=\"720\" id=\"table1\">");
		out.println("<h1 align=\"center\">" + msg + "</td>");
		out.println("<form method=\"POST\" action=\"resultado.htm\">");
		out.println("<td width=\"28\">");
		out.println("<p align=\"center\">");
		out.println(" <a href=\"usuario.htm\">");
		out.println("</a></td>");
		out.println("<td><a href=\"GerenteOfRegCuenta.html\">Registrar Cuenta</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println(" <td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"oficina.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"GerenteOfRegPrestamo.html\">Solicitudes de prestamo</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"cerrarCuenta.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"cerrarCuenta.html\">Solicitudes de Cierres de Cuenta</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("</body>");
        out.println("</html>");

	}
	
	private void Cliente(HttpServletResponse resp, String msg)
			throws IOException {
		
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"0\" width=\"720\" id=\"table1\">");
		out.println("<h1 align=\"center\">" + msg + "</td>");
		out.println("<form method=\"POST\" action=\"resultado.htm\">");
		out.println("<td width=\"28\">");
		out.println("<p align=\"center\">");
		out.println(" <a href=\"usuario.htm\">");
		out.println("</a></td>");
		out.println("<td><a href=\"AAAAAAAAA.html\">Cuentas del titular</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
		out.println("<p align=\"center\">");
		out.println(" <a href=\"usuario.htm\">");
		out.println("</a></td>");
		out.println("<td><a href=\"AAAAAAAAA.html\">Prestamos del titular</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println(" <td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"oficina.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioSolicitudPrestamo.html\">Solicitar Prestamo</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"punto.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioSolicitudCuenta.html\">Solicitar Cuenta</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"cuenta.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioConsignar.html\">Consignar a cuenta</a></td>");
        out.println("</tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"cuenta.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioRetirar.html\">Retirar de cuenta</a></td>");
        out.println("</tr>");
        out.println("</body>");
        out.println("</html>");
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
	
	// TODO
	private void Gerente (HttpServletResponse resp, String msg)
			throws IOException {
		
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"0\" width=\"720\" id=\"table1\">");
		out.println("<h1 align=\"center\">" + msg + "</td>");
		out.println("<form method=\"POST\" action=\"resultado.htm\">");
		out.println("<td width=\"28\">");
		out.println("<p align=\"center\">");
		out.println(" <a href=\"cuenta.htm\">");
		out.println("</a></td>");
		out.println("<td><a href=\"cuenta.htm\">Ver cuentas del Banco</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println(" <td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"oficina.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"Solicitar10MayorMov.html\">Consultar las 10 operaciones de mayor movimiento en el sistema</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("</body>");
        out.println("</html>");

	}
	
	// TODO
	
	private void Cajero(HttpServletResponse resp, String msg)
			throws IOException {
		
		PrintWriter out = resp.getWriter();

		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"0\" width=\"720\" id=\"table1\">");
		out.println("<h1 align=\"center\">" + msg + "</td>");
		out.println("<form method=\"POST\" action=\"resultado.htm\">");
	    out.println(" <td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"oficina.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioSolicitudPrestamo.html\">Solicitar Prestamo</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"punto.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioSolicitudCuenta.html\">Solicitar Cuenta</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"cuenta.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioConsignar.html\">Consignar a cuenta</a></td>");
        out.println("</tr>");
        out.println("<td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"cuenta.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"UsuarioRetirar.html\">Retirar de cuenta</a></td>");
        out.println("</tr>");
        out.println(" <td width=\"28\">");
        out.println("<p align=\"center\"><a href=\"oficina.htm\">");
        out.println("</a></td>");
        out.println("<td><a href=\"Solicitar10MayorMov.html\">Consultar las 10 operaciones de mayor movimiento en el sistema</a></td>");
        out.println("</tr>");
        out.println("<tr>");
        out.println("</body>");
        out.println("</html>");

	}

}
