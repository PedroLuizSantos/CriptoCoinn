package api;

import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ThreadCHZ extends Thread {

	private Coin Chiliz;

	public ThreadCHZ(Coin Chiliz) {

		this.Chiliz = Chiliz;
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

				Chiliz = gson.fromJson(coinGecko.chilizInfo(), Coin.class);
				Chiliz.ConverterMarket_Data();
				Chiliz.transferirMarket_Data();

				Chiliz.daily_values = gson.fromJson(coinGecko.chillizMarketValues(timeFromDaily, timeTo),
						Coin.market_values.class);
				Chiliz.weekly_values = gson.fromJson(coinGecko.chillizMarketValues(timeFromWeekly, timeTo),
						Coin.market_values.class);
				Chiliz.monthly_values = gson.fromJson(coinGecko.chillizMarketValues(timeFromMonthly, timeTo),
						Coin.market_values.class);

				Chiliz.variacaoDiaria = calcularVariacao(Chiliz.daily_values.prices.get(0)[1],
						Chiliz.daily_values.prices.get(Chiliz.daily_values.prices.size() - 1)[1]);
				Chiliz.variacaoSemanal = calcularVariacao(Chiliz.weekly_values.prices.get(0)[1],
						Chiliz.weekly_values.prices.get(Chiliz.weekly_values.prices.size() - 1)[1]);
				Chiliz.variacaoMensal = calcularVariacao(Chiliz.monthly_values.prices.get(0)[1],
						Chiliz.monthly_values.prices.get(Chiliz.monthly_values.prices.size() - 1)[1]);

				Chiliz.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Chiliz.daily_values.prices.get(0)[1],
						Chiliz.daily_values.prices.get(Chiliz.daily_values.prices.size() - 1)[1]);
				Chiliz.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Chiliz.weekly_values.prices.get(0)[1],
						Chiliz.weekly_values.prices.get(Chiliz.weekly_values.prices.size() - 1)[1]);
				Chiliz.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Chiliz.monthly_values.prices.get(0)[1],
						Chiliz.monthly_values.prices.get(Chiliz.monthly_values.prices.size() - 1)[1]);

				if (Chiliz.variacaoMensalPorcentagem <= -10 && Chiliz.variacaoMensalPorcentagem >= -20
						&& Chiliz.variacaoDiariaPorcentagem < 10) {
					Chiliz.analise = "HORA DE COMPRAR/ANALISAR";
				} else if (Chiliz.variacaoMensalPorcentagem >= 5 && Chiliz.variacaoMensalPorcentagem <= 10
						&& Chiliz.variacaoDiariaPorcentagem > 5) {
					Chiliz.analise = "HORA DE COMPRAR";
				} else if (Chiliz.variacaoMensalPorcentagem >= 30 && Chiliz.variacaoDiariaPorcentagem <= -20) {
					Chiliz.analise = "HORA DE COMPRAR";
				} else if (Chiliz.variacaoMensalPorcentagem <= -10 && Chiliz.variacaoMensalPorcentagem >= -20
						&& Chiliz.variacaoDiariaPorcentagem >= 20) {
					Chiliz.analise = "HORA DE ANALISAR";
				} else if (Chiliz.variacaoMensalPorcentagem <= -20 && Chiliz.variacaoDiariaPorcentagem >= 50) {
					Chiliz.analise = "HORA DE COMPRAR";
				} else if (Chiliz.variacaoMensalPorcentagem >= 20 && Chiliz.variacaoDiariaPorcentagem >= 50) {
					Chiliz.analise = "HORA DE VENDER/ANALISAR";
				} else {
					Chiliz.analise = "HORA DE ANALISAR";
				}

				ThreadCHZ.sleep(40000);
				System.out.println("THREAD CHZ OK!");

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
