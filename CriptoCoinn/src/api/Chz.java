package api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ada
 */
@WebServlet("/chz")
public class Chz extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Chz() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	
 	   	request.setAttribute("chz_name", MyServletContextListener.Chiliz.name);
 	   	request.setAttribute("chz_price", MyServletContextListener.Chiliz.market_data.current_price.usd);
 	   	request.setAttribute("chz_marketcap", MyServletContextListener.Chiliz.market_data.market_cap.usd);
 	   	request.setAttribute("chz_volume", MyServletContextListener.Chiliz.market_data.total_volume.usd);
 	   	
 	   	request.setAttribute("chz_variacaoDiaria_porcentagem", MyServletContextListener.Chiliz.variacaoDiariaPorcentagem);
		request.setAttribute("chz_variacaoMensal_porcentagem", MyServletContextListener.Chiliz.variacaoMensalPorcentagem);
		request.setAttribute("chz_analise", MyServletContextListener.Chiliz.analise);
 	   	
 	   	
 	   	
 	   	//System.out.print("Carregando CHZ/");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("chz.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 
	    }
	}


