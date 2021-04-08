package api;
import java.io.IOException;

import javax.servlet.*;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class MyServletContextListener implements ServletContextListener {

	   static Coin Cardano 	= new Coin();
	   static Coin Binance 	= new Coin();
	   static Coin Chiliz 	= new Coin();
	   static Coin Polkadot	= new Coin();
	   static Coin Solana 	= new Coin();

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
 }

 public void contextDestroyed(ServletContextEvent e) {

 }
}