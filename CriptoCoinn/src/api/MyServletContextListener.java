package api;
import java.io.IOException;

import javax.servlet.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class MyServletContextListener implements ServletContextListener {

	   static Coin Cardano 	= new Coin();
	   static Coin Binance 	= new Coin();
	   static Coin Chiliz 		= new Coin();
	   static Coin Polkadot	= new Coin();
	   static Coin Solana 		= new Coin();

 public void contextInitialized(ServletContextEvent e) {
   
   coinGecko coinGecko = new coinGecko();
   
   Gson gson = new GsonBuilder().serializeNulls().create();
   Coin moeda = new Coin();

   
   
   try {
	   moeda = gson.fromJson(coinGecko.bitcoinInfo(), Coin.class); 
	   moeda.ConverterMarket_Data();
	   moeda.transferirMarket_Data();

	   Cardano = gson.fromJson(coinGecko.cardanoInfo(), Coin.class); 
	   Cardano.ConverterMarket_Data();
	   Cardano.transferirMarket_Data();
	   
	   
	   Binance = gson.fromJson(coinGecko.binanceInfo(), Coin.class); 
	   Binance.ConverterMarket_Data();
	   Binance.transferirMarket_Data();
	   
	   Chiliz = gson.fromJson(coinGecko.chilizInfo(), Coin.class); 
	   Chiliz.ConverterMarket_Data();
	   Chiliz.transferirMarket_Data();
	   
	   Polkadot = gson.fromJson(coinGecko.polkadotInfo(), Coin.class); 
	   Polkadot.ConverterMarket_Data();
	   Polkadot.transferirMarket_Data();
	   
	   Solana = gson.fromJson(coinGecko.solanaInfo(), Coin.class); 
	   Solana.ConverterMarket_Data();
	   Solana.transferirMarket_Data();
	   
} catch (JsonSyntaxException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
} catch (IOException e1) {
	// TODO Auto-generated catch block
	e1.printStackTrace();
}
   System.out.println(Cardano.name);
   System.out.println(Cardano.symbol);
   System.out.println("$" + Cardano.market_data.current_price.usd);
   System.out.println("Market Cap: " + Cardano.market_data.market_cap.usd);
   System.out.println("Total Volume: " + Cardano.market_data.total_volume.usd);
   
   System.out.println("---------------------");
   
   System.out.println(Binance.name);
   System.out.println(Binance.symbol);
   System.out.println("$" + Binance.market_data.current_price.usd);
   System.out.println("Market Cap: " + Binance.market_data.market_cap.usd);
   System.out.println("Total Volume: " + Binance.market_data.total_volume.usd);
   
   System.out.println("---------------------");
   
   System.out.println(Chiliz.name);
   System.out.println(Chiliz.symbol);
   System.out.println("$" + Chiliz.market_data.current_price.usd);
   System.out.println("Market Cap: " + Chiliz.market_data.market_cap.usd);
   System.out.println("Total Volume: " + Chiliz.market_data.total_volume.usd);
   
   System.out.println("---------------------");

   System.out.println(Polkadot.name);
   System.out.println(Polkadot.symbol);
   System.out.println("$" + Polkadot.market_data.current_price.usd);
   System.out.println("Market Cap: " + Polkadot.market_data.market_cap.usd);
   System.out.println("Total Volume: " + Polkadot.market_data.total_volume.usd);
   
   System.out.println("---------------------");
   
   System.out.println(Solana.name);
   System.out.println(Solana.symbol);
   System.out.println("$" + Solana.market_data.current_price.usd);
   System.out.println("Market Cap: " + Solana.market_data.market_cap.usd);
   System.out.println("Total Volume: " + Solana.market_data.total_volume.usd);
 }

 public void contextDestroyed(ServletContextEvent e) {

 }
}