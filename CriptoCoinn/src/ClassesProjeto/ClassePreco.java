package ClassesProjeto;

public class ClassePreco {
	
	private float precoMoeda;
	
	public ClassePreco(String precoMoeda){
		
		this.precoMoeda = this.convertToFloat(precoMoeda);
	}

	private float convertToFloat(String precoMoeda2) {
		try {
			return Float.parseFloat(precoMoeda2);
		}catch(Exception e) {
			
		}return 0;
	}
	
	public float aumentar() {
		return precoMoeda + 800;
	}
	
	public  void setPrecoMoeda(float precoMoeda) {
		this.precoMoeda = precoMoeda;
	}
	public float getPrecoMoeda() {
		return precoMoeda;
	}
	
}
