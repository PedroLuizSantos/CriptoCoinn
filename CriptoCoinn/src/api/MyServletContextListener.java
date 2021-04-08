package api;
import java.io.IOException;

import javax.servlet.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class MyServletContextListener implements ServletContextListener {

 public void contextInitialized(ServletContextEvent e) {
   System.out.println("Cheguei");
   
   coinGecko coinGecko = new coinGecko();
   
   //Gson gson = new Gson();
   Gson gson = new GsonBuilder().serializeNulls().create();
   Coin moeda = new Coin();
   
   
   try {
	   moeda = gson.fromJson(coinGecko.bitcoinInfo(), Coin.class); 
	   moeda.ConverterMarket_Data();
	   moeda.transferirMarket_Data();
} catch (JsonSyntaxException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
   System.out.println(moeda.name);
   System.out.println(moeda.symbol);
   System.out.println("$" + moeda.market_data.current_price.usd);
   System.out.println("Market Cap: " + moeda.market_data.market_cap.usd);
   System.out.println("Total Volume: " + moeda.market_data.total_volume.usd);
 }

 public void contextDestroyed(ServletContextEvent e) {

 }
}