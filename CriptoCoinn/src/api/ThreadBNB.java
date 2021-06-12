package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ThreadBNB extends Thread {
	
	private Coin Binance;

	public ThreadBNB(Coin Binance) {

		this.Binance = Binance;
	}

	@Override
	public void run() {

		coinGecko coinGecko = new coinGecko();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Coin moeda = new Coin();

		try {

			moeda = gson.fromJson(coinGecko.bitcoinInfo(), Coin.class);
			moeda.ConverterMarket_Data();
			moeda.transferirMarket_Data();

			Binance = gson.fromJson(coinGecko.binanceInfo(), Coin.class);
			Binance.ConverterMarket_Data();
			Binance.transferirMarket_Data();

			System.out.println("THREAD BNB OK!" + Binance);

		} catch (Exception e) {

			e.printStackTrace();
		}
	}
}
