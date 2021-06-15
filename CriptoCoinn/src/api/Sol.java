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
@WebServlet("/sol")
public class Sol extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sol() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	
 	   	request.setAttribute("sol_name", MyServletContextListener. Solana.name);
 	   	request.setAttribute("sol_price", MyServletContextListener. Solana.market_data.current_price.usd);
 	   	request.setAttribute("sol_marketcap", MyServletContextListener. Solana.market_data.market_cap.usd);
 	   	request.setAttribute("sol_volume", MyServletContextListener. Solana.market_data.total_volume.usd);
 	   	
 		request.setAttribute("sol_variacaoDiaria_porcentagem", MyServletContextListener.Solana.variacaoDiariaPorcentagem);
		request.setAttribute("sol_variacaoMensal_porcentagem", MyServletContextListener.Solana.variacaoMensalPorcentagem);
		request.setAttribute("sol_analise", MyServletContextListener.Solana.analise);
 	   	
 	   	//System.out.print("Carrregando SOL/");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("sol.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 
	    }
	}

