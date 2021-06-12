package api;

import java.time.Instant;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyServletContextListener implements ServletContextListener {

	static Coin Cardano = new Coin();
	static Coin Binance = new Coin();
	static Coin Chiliz = new Coin();
	static Coin Polkadot = new Coin();
	static Coin Solana = new Coin();

	public void contextInitialized(ServletContextEvent e) {

		coinGecko coinGecko = new coinGecko();
		Gson gson = new GsonBuilder().serializeNulls().create();
		Coin moeda = new Coin();

		long timeTo = Instant.now().getEpochSecond();
		long timeFromDaily = timeTo - 86400;
		long timeFromWeekly = timeTo - 604800;
		long timeFromMonthly = timeTo - 2592000;

		try {

			Thread threadADA = new ThreadADA(Cardano);
			threadADA.start();

			Thread threadBNB = new ThreadBNB(Binance);
			threadBNB.start();

			moeda = gson.fromJson(coinGecko.bitcoinInfo(), Coin.class);
			moeda.ConverterMarket_Data();
			moeda.transferirMarket_Data();

			Cardano.daily_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromDaily, timeTo),
					Coin.market_values.class);
			Cardano.weekly_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromWeekly, timeTo),
					Coin.market_values.class);
			Cardano.monthly_values = gson.fromJson(coinGecko.cardanoMarketValues(timeFromMonthly, timeTo),
					Coin.market_values.class);

			/*
			 * Mostrando Valores for(int i = 0; i < Cardano.daily_values.prices.size(); i =
			 * i + 72) { System.out.println(Cardano.daily_values.prices.get(i)[1]); }
			 * System.out.println(Cardano.daily_values.prices.size());
			 * 
			 * for(int i = 0; i < Cardano.weekly_values.prices.size(); i = i + 24) {
			 * System.out.println(Cardano.weekly_values.prices.get(i)[1]); }
			 * System.out.println(Cardano.weekly_values.prices.size());
			 * 
			 * for(int i = 0; i < Cardano.monthly_values.prices.size(); i = i + 24) {
			 * System.out.println(Cardano.monthly_values.prices.get(i)[1]); }
			 * System.out.println(Cardano.monthly_values.prices.size());
			 */

			Chiliz = gson.fromJson(coinGecko.chilizInfo(), Coin.class);
			Chiliz.ConverterMarket_Data();
			Chiliz.transferirMarket_Data();

			Polkadot = gson.fromJson(coinGecko.polkadotInfo(), Coin.class);
			Polkadot.ConverterMarket_Data();
			Polkadot.transferirMarket_Data();

			Solana = gson.fromJson(coinGecko.solanaInfo(), Coin.class);
			Solana.ConverterMarket_Data();
			Solana.transferirMarket_Data();

		} catch (Exception e1) {
			e1.printStackTrace();
		}

		// Calcular variação
		double variacaoDiaria = 0;
		double variacaoSemanal = 0;
		double variacaoMensal = 0;

		try {

			variacaoDiaria = calcularVariacao(Cardano.daily_values.prices.get(0)[1],
					Cardano.daily_values.prices.get(Cardano.daily_values.prices.size() - 1)[1]);
			variacaoSemanal = calcularVariacao(Cardano.weekly_values.prices.get(0)[1],
					Cardano.weekly_values.prices.get(Cardano.weekly_values.prices.size() - 1)[1]);
			variacaoMensal = calcularVariacao(Cardano.monthly_values.prices.get(0)[1],
					Cardano.monthly_values.prices.get(Cardano.monthly_values.prices.size() - 1)[1]);

		} finally {
			System.out.println(variacaoDiaria);
			System.out.println(variacaoSemanal);
			System.out.println(variacaoMensal);
		}

	}

	public void dormir(int milisegundos) {
		try {
			System.out.println(Thread.currentThread().getName() + " irá dormir por " + milisegundos + " milesegundos.");
			Thread.sleep(milisegundos);
		} catch (Exception e) {

		}
	}

	public double calcularVariacao(double valorInicial, double valorFinal) {
		double variacao = 0;

		variacao = valorFinal - valorInicial;

		return variacao;
	}

	public void contextDestroyed(ServletContextEvent e) {

	}

}
