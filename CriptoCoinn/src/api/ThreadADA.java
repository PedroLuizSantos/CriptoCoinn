package api;

import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ThreadADA extends Thread {

	private Coin Cardano;

	public ThreadADA(Coin Cardano) {

		this.Cardano = Cardano;
	}

	@Override
	public void run() {

		while (true) {
			coinGecko coinGecko = new coinGecko();
			Gson gson = new GsonBuilder().serializeNulls().create();
			Coin moeda = new Coin();

			long timeTo = Instant.now().getEpochSecond();
			long timeFromDaily = timeTo - 86400;
			long timeFromWeekly = timeTo - 604800;
			long timeFromMonthly = timeTo - 2592000;

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

				ThreadADA.sleep(60000); //dormir por 1 minutos.

				Cardano.current_price_usd = Cardano.current_price_usd;
				Cardano.market_data.market_cap.usd = Cardano.market_data.market_cap.usd;
				Cardano.market_data.total_volume.usd = Cardano.market_data.total_volume.usd;
				Cardano.daily_values.prices = Cardano.daily_values.prices;
				
				
				
				System.out.println("THREAD ADA OK!");

				MyServletContextListener.Cardano = this.Cardano;

			} catch (Exception e) {

				e.printStackTrace();
			}

		}
	}
}
