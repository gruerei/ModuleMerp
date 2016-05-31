package beans;

public class Life {
	
	private int baseLife;//Vida Base obtenida de los dados
	private int totalLife;
	private int currentLife;
	private int lifeLostPerAsault;
	private int asaultsLosingLife;
	
	
	public Life(int baseLife, int totalLife) {
		this.baseLife = baseLife;
		this.totalLife = totalLife;
		this.currentLife = totalLife;
	}
	
	public int getTotalLife() {
		return totalLife;
	}
	public void setTotalLife(int totalLife) {
		this.totalLife = totalLife;
	}
	public int getCurrentLife() {
		return currentLife;
	}
	public void setCurrentLife(int currentLife) {
		this.currentLife = currentLife;
	}
	public int getLifeLostPerAsault() {
		return lifeLostPerAsault;
	}
	public void setLifeLostPerAsault(int lifeLostPerAsault) {
		this.lifeLostPerAsault = lifeLostPerAsault;
	}
	public int getAsaultsLosingLife() {
		return asaultsLosingLife;
	}
	public void setAsaultsLosingLife(int asaultsLosingLife) {
		this.asaultsLosingLife = asaultsLosingLife;
	}
	
	public void lifePointsLost(int points){
		currentLife =  currentLife - points;
	}
	
	
}
