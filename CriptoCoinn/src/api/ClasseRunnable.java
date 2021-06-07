package api;

import java.io.IOException;
import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class ClasseRunnable implements Runnable {

	static Coin Cardano = new Coin();
	coinGecko coinGecko = new coinGecko();

	Gson gson = new GsonBuilder().serializeNulls().create();
	Coin moeda = new Coin();

	long timeTo = Instant.now().getEpochSecond();
	long timeFromDaily = timeTo - 86400;
	long timeFromWeekly = timeTo - 604800;
	long timeFromMonthly = timeTo - 2592000;
	
	@Override
	public void run() {
		System.out.println("Rodando ADA API");
		
		try {
		moeda = gson.fromJson(coinGecko.bitcoinInfo(), Coin.class);
		moeda.ConverterMarket_Data();
		moeda.transferirMarket_Data();
		
		Cardano = gson.fromJson(coinGecko.cardanoInfo(), Coin.class);
		Cardano.ConverterMarket_Data();
		Cardano.transferirMarket_Data();
		Cardano.daily_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromDaily, timeTo),
				Coin.market_values.class);
		Cardano.weekly_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromWeekly, timeTo),
				Coin.market_values.class);
		Cardano.monthly_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromMonthly, timeTo),
				Coin.market_values.class);
		
		} catch (JsonSyntaxException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
			
			e1.printStackTrace();
		}
	}

}
