package beans;

public class Botch {
	private int min;
	private int max;
	private Critical criticalTaken;
	
	
	public Botch(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	
	public Botch(int min, int max, Critical criticalTaken) {
		this.min = min;
		this.max = max;
		this.criticalTaken = criticalTaken;
	}

	public Botch() {
	}


	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}


	public Critical getCriticalTaken() {
		return criticalTaken;
	}


	public void setCriticalTaken(Critical criticalTaken) {
		this.criticalTaken = criticalTaken;
	}

	
	
}
