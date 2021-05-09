package api;

import java.math.BigInteger;
import java.util.List;


public class Coin {
    String name;
    String symbol;
    
    double current_price_usd;
    BigInteger market_cap_usd;
    BigInteger total_volume_usd;
    
    
    class market_data{
    	class current_price{
    		double usd;
    	}
    	class market_cap{
    		String usd;
    		BigInteger marketcap;
    	}
    	class total_volume{
    		String usd;
    		BigInteger totalvolume;
    	}
    	
    	current_price current_price = new current_price();
    	market_cap market_cap = new market_cap();
    	total_volume total_volume = new total_volume();
    	
    }
    

    
    class market_values{
    	List<double[]> prices;
    	List<double[]> market_caps;
    	List<double[]> total_volumes;
    }
    
    market_data market_data = new market_data();
    
    market_values daily_values 	= new market_values(); 
    market_values weekly_values = new market_values(); 
    market_values monthly_values = new market_values(); 
    
    public void ConverterMarket_Data(){
    	
    	this.market_data.market_cap.marketcap = new BigInteger(this.market_data.market_cap.usd);
    	this.market_data.total_volume.totalvolume = new BigInteger(this.market_data.total_volume.usd);
    }
    
    public void transferirMarket_Data(){
    	
    	this.current_price_usd = this.market_data.current_price.usd;
    	this.market_cap_usd = this.market_data.market_cap.marketcap;
    	this.total_volume_usd = this.market_data.total_volume.totalvolume;
    }
    
    
}
