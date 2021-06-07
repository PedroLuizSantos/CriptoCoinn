package api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.Instant;
import java.util.Scanner;


public class coinGecko {

	
	String apiretorno;

	public String bitcoinInfo() throws IOException {

		String result;
		
		URL url = new URL("https://api.coingecko.com/api/v3/coins/bitcoin");
		InputStream is = url.openStream();
		try {
		  /* Now read the retrieved document from the stream. */

			Scanner s = new Scanner(is).useDelimiter("\\A");
			result = s.hasNext() ? s.next() : "";
			s.close();
			
		} finally {
		  is.close();
		}
		
		
		return result ;
	}
	
	public String cardanoInfo() throws IOException {

		String result;
		
		URL url = new URL("https://api.coingecko.com/api/v3/coins/cardano");
		InputStream is = url.openStream();
		try {
		  /* Now read the retrieved document from the stream. */

			Scanner s = new Scanner(is).useDelimiter("\\A");
			result = s.hasNext() ? s.next() : "";
			s.close();
			
		} finally {
		  is.close();
		}
		
		
		return result ;
	}
	
	public String cardanoMarketValues(long timeFrom, long timeTo) throws IOException {
		

		String result;
		
		URL url = new URL("https://api.coingecko.com/api/v3/coins/cardano/market_chart/range?vs_currency=usd&from=" + timeFrom + "&to=" + timeTo);
		InputStream is = url.openStream();
		try {
		  /* Now read the retrieved document from the stream. */

			Scanner s = new Scanner(is).useDelimiter("\\A");
			result = s.hasNext() ? s.next() : "";
			s.close();
			
		} finally {
		  is.close();
		}
		
		
		return result ;
	}
	
	public String binanceInfo() throws IOException {

		String result;
		
		URL url = new URL("https://api.coingecko.com/api/v3/coins/binancecoin");
		InputStream is = url.openStream();
		try {
		  /* Now read the retrieved document from the stream. */

			Scanner s = new Scanner(is).useDelimiter("\\A");
			result = s.hasNext() ? s.next() : "";
			s.close();
			
		} finally {
		  is.close();
		}
		
		
		return result ;
	}
	
	public String chilizInfo() throws IOException {

		String result;
		
		URL url = new URL("https://api.coingecko.com/api/v3/coins/chiliz");
		InputStream is = url.openStream();
		try {
		  /* Now read the retrieved document from the stream. */

			Scanner s = new Scanner(is).useDelimiter("\\A");
			result = s.hasNext() ? s.next() : "";
			s.close();
			
		} finally {
		  is.close();
		}
		
		
		return result ;
	}
	
	public String polkadotInfo() throws IOException {

		String result;
		
		URL url = new URL("https://api.coingecko.com/api/v3/coins/polkadot");
		InputStream is = url.openStream();
		try {
		  /* Now read the retrieved document from the stream. */

			Scanner s = new Scanner(is).useDelimiter("\\A");
			result = s.hasNext() ? s.next() : "";
			s.close();
			
		} finally {
		  is.close();
		}
		
		
		return result ;
	}
	
	public String solanaInfo() throws IOException {

		String result;
		
		URL url = new URL("https://api.coingecko.com/api/v3/coins/solana");
		InputStream is = url.openStream();
		try {
		  /* Now read the retrieved document from the stream. */

			Scanner s = new Scanner(is).useDelimiter("\\A");
			result = s.hasNext() ? s.next() : "";
			s.close();
			
		} finally {
		  is.close();
		}
		
		
		return result ;
	}
	
}
