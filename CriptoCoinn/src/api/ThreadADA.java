package api;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ThreadADA extends Thread {
	
	public Coin Cardano;
	
	public ThreadADA(Coin Cardano) {
		
		this.Cardano = Cardano;
	
	}
	
	@Override
	public void run() {
		coinGecko coinGecko = new coinGecko();
		Gson gson = new GsonBuilder().serializeNulls().create();
		
		try {
			Cardano = gson.fromJson(coinGecko.cardanoInfo(), Coin.class);
			Cardano.ConverterMarket_Data();
			Cardano.transferirMarket_Data();
			System.out.println("MOEDA ADA OK!" + Cardano);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}