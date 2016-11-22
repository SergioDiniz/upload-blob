package br.com.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.sessionbeans.UsuarioIT;

/**
 * Servlet implementation class LoadImagem
 */
@WebServlet("/imagem/*")
public class LoadImagem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private UsuarioIT dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoadImagem() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id = Long.parseLong(request.getParameter("id"));
		byte[] imagem = dao.findUsuario(id).getFoto();
//		response.setContentType("imagem/jpg");
		ServletOutputStream out = response.getOutputStream();
		out.write(imagem);
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
