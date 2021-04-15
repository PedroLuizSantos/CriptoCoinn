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
@WebServlet("/dot")
public class Dot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	
 	   	request.setAttribute("dot_name", MyServletContextListener.Polkadot.name);
 	   	request.setAttribute("dot_price", MyServletContextListener.Polkadot.market_data.current_price.usd);
 	   	request.setAttribute("dot_marketcap", MyServletContextListener.Polkadot.market_data.market_cap.usd);
 	   	request.setAttribute("dot_volume", MyServletContextListener.Polkadot.market_data.total_volume.usd);
 	   	
 	   	System.out.print("Estou aqui");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("dot.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 
	    }
	}

