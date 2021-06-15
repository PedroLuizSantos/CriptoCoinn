package api;

import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ThreadBNB extends Thread {

	private Coin Binance;

	public ThreadBNB(Coin Binance) {

		this.Binance = Binance;
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

				Binance = gson.fromJson(coinGecko.binanceInfo(), Coin.class);
				Binance.ConverterMarket_Data();
				Binance.transferirMarket_Data();
				
				Binance.daily_values = gson.fromJson(coinGecko.binanceMarketValues(timeFromDaily, timeTo),
						Coin.market_values.class);
				Binance.weekly_values = gson.fromJson(coinGecko.binanceMarketValues(timeFromWeekly, timeTo),
						Coin.market_values.class);
				Binance.monthly_values = gson.fromJson(coinGecko.binanceMarketValues(timeFromMonthly, timeTo),
						Coin.market_values.class);
				
				Binance.variacaoDiaria = calcularVariacao(Binance.daily_values.prices.get(0)[1],
						Binance.daily_values.prices.get(Binance.daily_values.prices.size() - 1)[1]);
				Binance.variacaoSemanal = calcularVariacao(Binance.weekly_values.prices.get(0)[1],
						Binance.weekly_values.prices.get(Binance.weekly_values.prices.size() - 1)[1]);
				Binance.variacaoMensal = calcularVariacao(Binance.monthly_values.prices.get(0)[1],
						Binance.monthly_values.prices.get(Binance.monthly_values.prices.size() - 1)[1]);

				Binance.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Binance.daily_values.prices.get(0)[1],
						Binance.daily_values.prices.get(Binance.daily_values.prices.size() - 1)[1]);
				Binance.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Binance.weekly_values.prices.get(0)[1],
						Binance.weekly_values.prices.get(Binance.weekly_values.prices.size() - 1)[1]);
				Binance.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Binance.monthly_values.prices.get(0)[1],
						Binance.monthly_values.prices.get(Binance.monthly_values.prices.size() - 1)[1]);
				
				if (Binance.variacaoMensalPorcentagem <= -10 && Binance.variacaoMensalPorcentagem >= -20
						&& Binance.variacaoDiariaPorcentagem < 10) {
					Binance.analise = "HORA DE COMPRAR/ANALISAR";
				} else if (Binance.variacaoMensalPorcentagem >= 5 && Binance.variacaoMensalPorcentagem <= 10
						&& Binance.variacaoDiariaPorcentagem > 5) {
					Binance.analise = "HORA DE COMPRAR";
				} else if (Binance.variacaoMensalPorcentagem >= 30 && Binance.variacaoDiariaPorcentagem <= -20) {
					Binance.analise = "HORA DE COMPRAR";
				} else if (Binance.variacaoMensalPorcentagem <= -10 && Binance.variacaoMensalPorcentagem >= -20
						&& Binance.variacaoDiariaPorcentagem >= 20) {
					Binance.analise = "HORA DE ANALISAR";
				} else if (Binance.variacaoMensalPorcentagem <= -20 && Binance.variacaoDiariaPorcentagem >= 50) {
					Binance.analise = "HORA DE COMPRAR";
				} else if (Binance.variacaoMensalPorcentagem >= 20 && Binance.variacaoDiariaPorcentagem >= 50) {
					Binance.analise = "HORA DE VENDER/ANALISAR";
				} else {
					Binance.analise = "HORA DE ANALISAR";
				}
				
				
				ThreadBNB.sleep(40000);
				System.out.println("THREAD BNB OK!");

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}
	public double calcularVariacao(double valorInicial, double valorFinal) {
		double variacao = 0;

		variacao = valorFinal - valorInicial;

		return variacao;
	}

	public double calcularVariacaoPorcentagem(double valorInicial, double valorFinal) {
		double variacao = 0;
		variacao = ((valorFinal / valorInicial) * 100) - 100;
		return variacao;
	}
}
