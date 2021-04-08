package UseCases;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ClassesProjeto.ClassePreco;

public class UseCasePreco {
	
	private HttpServletRequest request;
	private HttpServletResponse response;

	public UseCasePreco(HttpServletRequest request, HttpServletResponse response) {
		
		this.request = request;
		this.response = response;
	}

	public void execute() throws IOException, ServletException {
		
		
		RequestDispatcher rd = request.getRequestDispatcher("front.jsp");
		
		try {
			ClassePreco aumentar = this.createMostrar();
			
			String resposta = String.format("A %s de %s e %s resulta em %s",
					aumentar.getPrecoMoeda());
					
			
			request.setAttribute("resposta", resposta);  
			
		} catch (NullPointerException e) {
			request.setAttribute("resposta", "Um dos valores não foi informado."); 
		} catch (NumberFormatException e) {
			request.setAttribute("resposta", "Um ou mais caractere(s) não são válidos."); 
		}
		rd.forward(request, response);
		
			
		
	}
	
		private ClassePreco createMostrar() throws NullPointerException, NumberFormatException {
		ClassePreco aumentar = new ClassePreco("200");
		String precoMoeda = request.getParameter("preco_Moeda");
		
		return aumentar;
	}
		
		
}


