package beans;

public class Price {
	public int id;
	public int pc;//platino
	public int gc;//gold - oro
	public int sc;//silver
	public int bc;//bronze
	public int cc;//copper
	public int tc;//tin - estaño
	
	public Price(String price) {
		
		String [] price_array = price.split(" ");
		
		if(price_array[1].equals("pc")){
			this.pc = Integer.parseInt(price_array[0]);
		}
		else if(price_array[1].equals("gc")){
			this.gc = Integer.parseInt(price_array[0]);
		}
		else if(price_array[1].equals("sc")){
			this.sc = Integer.parseInt(price_array[0]);
		}
		else if(price_array[1].equals("bc")){
			this.bc = Integer.parseInt(price_array[0]);
		}
		else if(price_array[1].equals("cc")){
			this.cc = Integer.parseInt(price_array[0]);
		}
		else if(price_array[1].equals("tc")){
			this.tc = Integer.parseInt(price_array[0]);
		}
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getGc() {
		return gc;
	}
	public void setGc(int gc) {
		this.gc = gc;
	}
	public int getsc() {
		return sc;
	}
	public void setSc(int sc) {
		this.sc = sc;
	}
	public int getBc() {
		return bc;
	}
	public void setBc(int bc) {
		this.bc = bc;
	}
	public int getCc() {
		return cc;
	}
	public void setCc(int cc) {
		this.cc = cc;
	}
	public int getTc() {
		return tc;
	}
	public void setTc(int tc) {
		this.tc = tc;
	}
	
	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	@Override
	public String toString() {
		return " [pc=" + pc + ", gc=" + gc + ", sc=" + sc + ", bc=" + bc + ", cc=" + cc + ", tc=" + tc + "]";
	}
	
	
	
}
