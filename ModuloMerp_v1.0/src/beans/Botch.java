package beans;

public class Botch {
	private int min;
	private int max;
	private int criticalTakenType;
	private String criticalTakenGravity;
	
	
	public Botch(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	
	public Botch(int min, int max, String criticalTaken) {
		this.min = min;
		this.max = max;

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


	public int getCriticalTakenType() {
		return criticalTakenType;
	}


	public void setCriticalTakenType(int criticalTakenType) {
		this.criticalTakenType = criticalTakenType;
	}


	public String getCriticalTakenGravity() {
		return criticalTakenGravity;
	}


	public void setCriticalTakenGravity(String criticalTakenGravity) {
		this.criticalTakenGravity = criticalTakenGravity;
	}

	
	
}
