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
@WebServlet("/bnb")
public class Bnb extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Bnb() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
    	
 	   	request.setAttribute("bnb_name", MyServletContextListener.Binance.name);
 	   	request.setAttribute("bnb_price", MyServletContextListener.Binance.market_data.current_price.usd);
 	   	request.setAttribute("bnb_marketcap", MyServletContextListener.Binance.market_data.market_cap.usd);
 	   	request.setAttribute("bnb_volume", MyServletContextListener.Binance.market_data.total_volume.usd);
 	   	
 	   	System.out.print("CarregandoBNB/");
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("bnb.jsp");
        requestDispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	 
	    }
	}

