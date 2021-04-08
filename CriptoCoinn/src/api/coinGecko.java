package api;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
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
	
}
