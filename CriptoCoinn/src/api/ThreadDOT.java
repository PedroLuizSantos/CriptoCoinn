package api;

import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ThreadDOT extends Thread {

	private Coin Polkadot;

	public ThreadDOT(Coin Polkadot) {

		this.Polkadot = Polkadot;
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

				Polkadot = gson.fromJson(coinGecko.polkadotInfo(), Coin.class);
				Polkadot.ConverterMarket_Data();
				Polkadot.transferirMarket_Data();

				Polkadot.daily_values = gson.fromJson(coinGecko.polkadotMarketValues(timeFromDaily, timeTo),
						Coin.market_values.class);
				Polkadot.weekly_values = gson.fromJson(coinGecko.polkadotMarketValues(timeFromWeekly, timeTo),
						Coin.market_values.class);
				Polkadot.monthly_values = gson.fromJson(coinGecko.polkadotMarketValues(timeFromMonthly, timeTo),
						Coin.market_values.class);

				Polkadot.variacaoDiaria = calcularVariacao(Polkadot.daily_values.prices.get(0)[1],
						Polkadot.daily_values.prices.get(Polkadot.daily_values.prices.size() - 1)[1]);
				Polkadot.variacaoSemanal = calcularVariacao(Polkadot.weekly_values.prices.get(0)[1],
						Polkadot.weekly_values.prices.get(Polkadot.weekly_values.prices.size() - 1)[1]);
				Polkadot.variacaoMensal = calcularVariacao(Polkadot.monthly_values.prices.get(0)[1],
						Polkadot.monthly_values.prices.get(Polkadot.monthly_values.prices.size() - 1)[1]);

				Polkadot.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Polkadot.daily_values.prices.get(0)[1],
						Polkadot.daily_values.prices.get(Polkadot.daily_values.prices.size() - 1)[1]);
				Polkadot.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(
						Polkadot.weekly_values.prices.get(0)[1],
						Polkadot.weekly_values.prices.get(Polkadot.weekly_values.prices.size() - 1)[1]);
				Polkadot.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(
						Polkadot.monthly_values.prices.get(0)[1],
						Polkadot.monthly_values.prices.get(Polkadot.monthly_values.prices.size() - 1)[1]);

				if (Polkadot.variacaoMensalPorcentagem <= -10 && Polkadot.variacaoMensalPorcentagem >= -20
						&& Polkadot.variacaoDiariaPorcentagem < 10) {
					Polkadot.analise = "HORA DE COMPRAR/ANALISAR";
				} else if (Polkadot.variacaoMensalPorcentagem >= 5 && Polkadot.variacaoMensalPorcentagem <= 10
						&& Polkadot.variacaoDiariaPorcentagem > 5) {
					Polkadot.analise = "HORA DE COMPRAR";
				} else if (Polkadot.variacaoMensalPorcentagem >= 30 && Polkadot.variacaoDiariaPorcentagem <= -20) {
					Polkadot.analise = "HORA DE COMPRAR";
				} else if (Polkadot.variacaoMensalPorcentagem <= -10 && Polkadot.variacaoMensalPorcentagem >= -20
						&& Polkadot.variacaoDiariaPorcentagem >= 20) {
					Polkadot.analise = "HORA DE ANALISAR";
				} else if (Polkadot.variacaoMensalPorcentagem <= -20 && Polkadot.variacaoDiariaPorcentagem >= 50) {
					Polkadot.analise = "HORA DE COMPRAR";
				} else if (Polkadot.variacaoMensalPorcentagem >= 20 && Polkadot.variacaoDiariaPorcentagem >= 50) {
					Polkadot.analise = "HORA DE VENDER/ANALISAR";
				} else {
					Polkadot.analise = "HORA DE ANALISAR";
				}

				ThreadDOT.sleep(40000);
				System.out.println("THREAD DOT OK!");

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
