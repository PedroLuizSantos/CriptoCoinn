package api;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ada")

public class Ada extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public Ada() {
		
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		

		response.getWriter().append("Served at: ").append(request.getContextPath());

		request.setAttribute("ada_name", MyServletContextListener.Cardano.name);
		request.setAttribute("ada_price", MyServletContextListener.Cardano.market_data.current_price.usd);
		request.setAttribute("ada_marketcap", MyServletContextListener.Cardano.market_data.market_cap.usd);
		request.setAttribute("ada_volume", MyServletContextListener.Cardano.market_data.total_volume.usd);
		request.setAttribute("ada_variacaoDiaria", MyServletContextListener.Cardano.daily_values.prices);

		
		//System.out.print("Carregando ADA/");
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("ada.jsp");
		requestDispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
	}		
}

