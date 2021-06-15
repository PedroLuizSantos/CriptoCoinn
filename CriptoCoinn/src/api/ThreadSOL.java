package api;

import java.time.Instant;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ThreadSOL extends Thread {

	private Coin Solana;

	public ThreadSOL(Coin Solana) {

		this.Solana = Solana;
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

				Solana = gson.fromJson(coinGecko.solanaInfo(), Coin.class);
				Solana.ConverterMarket_Data();
				Solana.transferirMarket_Data();

				Solana.daily_values = gson.fromJson(coinGecko.solanaMarketValues(timeFromDaily, timeTo),
						Coin.market_values.class);
				Solana.weekly_values = gson.fromJson(coinGecko.solanaMarketValues(timeFromWeekly, timeTo),
						Coin.market_values.class);
				Solana.monthly_values = gson.fromJson(coinGecko.solanaMarketValues(timeFromMonthly, timeTo),
						Coin.market_values.class);

				Solana.variacaoDiaria = calcularVariacao(Solana.daily_values.prices.get(0)[1],
						Solana.daily_values.prices.get(Solana.daily_values.prices.size() - 1)[1]);
				Solana.variacaoSemanal = calcularVariacao(Solana.weekly_values.prices.get(0)[1],
						Solana.weekly_values.prices.get(Solana.weekly_values.prices.size() - 1)[1]);
				Solana.variacaoMensal = calcularVariacao(Solana.monthly_values.prices.get(0)[1],
						Solana.monthly_values.prices.get(Solana.monthly_values.prices.size() - 1)[1]);

				Solana.variacaoDiariaPorcentagem = calcularVariacaoPorcentagem(Solana.daily_values.prices.get(0)[1],
						Solana.daily_values.prices.get(Solana.daily_values.prices.size() - 1)[1]);
				Solana.variacaoSemanalPorcentagem = calcularVariacaoPorcentagem(Solana.weekly_values.prices.get(0)[1],
						Solana.weekly_values.prices.get(Solana.weekly_values.prices.size() - 1)[1]);
				Solana.variacaoMensalPorcentagem = calcularVariacaoPorcentagem(Solana.monthly_values.prices.get(0)[1],
						Solana.monthly_values.prices.get(Solana.monthly_values.prices.size() - 1)[1]);

				if (Solana.variacaoMensalPorcentagem <= -10 && Solana.variacaoMensalPorcentagem >= -20
						&& Solana.variacaoDiariaPorcentagem < 10) {
					Solana.analise = "HORA DE COMPRAR/ANALISAR";
				} else if (Solana.variacaoMensalPorcentagem >= 5 && Solana.variacaoMensalPorcentagem <= 10
						&& Solana.variacaoDiariaPorcentagem > 5) {
					Solana.analise = "HORA DE COMPRAR";
				} else if (Solana.variacaoMensalPorcentagem >= 30 && Solana.variacaoDiariaPorcentagem <= -20) {
					Solana.analise = "HORA DE COMPRAR";
				} else if (Solana.variacaoMensalPorcentagem <= -10 && Solana.variacaoMensalPorcentagem >= -20
						&& Solana.variacaoDiariaPorcentagem >= 20) {
					Solana.analise = "HORA DE ANALISAR";
				} else if (Solana.variacaoMensalPorcentagem <= -20 && Solana.variacaoDiariaPorcentagem >= 50) {
					Solana.analise = "HORA DE COMPRAR";
				} else if (Solana.variacaoMensalPorcentagem >= 20 && Solana.variacaoDiariaPorcentagem >= 50) {
					Solana.analise = "HORA DE VENDER/ANALISAR";
				} else {
					Solana.analise = "HORA DE ANALISAR";
				}

				ThreadSOL.sleep(40000);
				System.out.println("THREAD SOL OK!");

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
