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
				
				
				Cardano.variacaoDiaria = calcularVariacao(Cardano.daily_values.prices.get(0)[1],
						Cardano.daily_values.prices.get(Cardano.daily_values.prices.size() - 1)[1]);
				Cardano.variacaoSemanal = calcularVariacao(Cardano.weekly_values.prices.get(0)[1],
						Cardano.weekly_values.prices.get(Cardano.weekly_values.prices.size() - 1)[1]);
				Cardano.variacaoMensal = calcularVariacao(Cardano.monthly_values.prices.get(0)[1],
						Cardano.monthly_values.prices.get(Cardano.monthly_values.prices.size() - 1)[1]);

				Cardano.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Cardano.daily_values.prices.get(0)[1],
						Cardano.daily_values.prices.get(Cardano.daily_values.prices.size() - 1)[1]);
				Cardano.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Cardano.weekly_values.prices.get(0)[1],
						Cardano.weekly_values.prices.get(Cardano.weekly_values.prices.size() - 1)[1]);
				Cardano.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Cardano.monthly_values.prices.get(0)[1],
						Cardano.monthly_values.prices.get(Cardano.monthly_values.prices.size() - 1)[1]);
				
				if (Cardano.variacaoMensalPorcentagem <= -10 && Cardano.variacaoMensalPorcentagem >= -20
						&& Cardano.variacaoDiariaPorcentagem < 10) {
					Cardano.analise = "HORA DE COMPRAR/ANALISAR";
				} else if (Cardano.variacaoMensalPorcentagem >= 5 && Cardano.variacaoMensalPorcentagem <= 10
						&& Cardano.variacaoDiariaPorcentagem > 5) {
					Cardano.analise = "HORA DE COMPRAR";
				} else if (Cardano.variacaoMensalPorcentagem >= 30 && Cardano.variacaoDiariaPorcentagem <= -20) {
					Cardano.analise = "HORA DE COMPRAR";
				} else if (Cardano.variacaoMensalPorcentagem <= -10 && Cardano.variacaoMensalPorcentagem >= -20
						&& Cardano.variacaoDiariaPorcentagem >= 20) {
					Cardano.analise = "HORA DE ANALISAR";
				} else if (Cardano.variacaoMensalPorcentagem <= -20 && Cardano.variacaoDiariaPorcentagem >= 50) {
					Cardano.analise = "HORA DE COMPRAR";
				} else if (Cardano.variacaoMensalPorcentagem >= 20 && Cardano.variacaoDiariaPorcentagem >= 50) {
					Cardano.analise = "HORA DE VENDER/ANALISAR";
				} else {
					Cardano.analise = "HORA DE ANALISAR";
				}

				System.out.println(Cardano.analise);

				ThreadADA.sleep(40000); //dormir por 40 segundos.
							
				System.out.println("THREAD ADA OK!");

				MyServletContextListener.Cardano = this.Cardano;

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
