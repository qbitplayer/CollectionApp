package model;

public class Ave extends Mascota {
	
	private float calidadPlumas; 

	/**
	 * 
	 * @param nombre
	 * @param peso
	 * @param altura
	 * @param largo
	 */
	public Ave(String nombre, float peso, float altura, float largo) {
		super(nombre, peso, altura, largo);
		this.setCalidadPlumas(1); 
	}
	
	public Ave(){
		super(); 
	}
	
	@Override
	public float getStadoNutricion() {
		// Peso/(0.5*altura * largo)
		return  getPeso()/(0.5f*getAltura()*getLargo());
	}
	
	@Override
	public float getPesoRacion() {
		return 0.2f*getPeso()*(2f-calidadPlumas); 
	}


	public float getCalidadPlumas() {
		return calidadPlumas;
	}


	public void setCalidadPlumas(float calidadPlumas) {
		this.calidadPlumas = calidadPlumas;
	}

	@Override
	protected String getTypeClass() {
		return getClass().getName();
	}
	
	

}
