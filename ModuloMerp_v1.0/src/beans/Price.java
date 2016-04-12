package beans;

public class Price {
	public int id;
	public int mg;//gold - oro
	public int ms;//silver
	public int mb;//bronze
	public int mc;//copper
	public int mt;//tin - estaño
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMg() {
		return mg;
	}
	public void setMg(int mg) {
		this.mg = mg;
	}
	public int getMs() {
		return ms;
	}
	public void setMs(int ms) {
		this.ms = ms;
	}
	public int getMb() {
		return mb;
	}
	public void setMb(int mb) {
		this.mb = mb;
	}
	public int getMc() {
		return mc;
	}
	public void setMc(int mc) {
		this.mc = mc;
	}
	public int getMt() {
		return mt;
	}
	public void setMt(int mt) {
		this.mt = mt;
	}
	@Override
	public String toString() {
		return "Price [mg=" + mg + ", ms=" + ms + ", mb=" + mb + ", mc=" + mc + ", mt=" + mt + "]";
	}
	
	
	
}
