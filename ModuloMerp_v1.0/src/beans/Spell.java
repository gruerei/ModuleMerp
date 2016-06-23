package beans;

public class Spell {
	
	public static int SPELL_BEAM= 1;
	public static int SPELL_AREA= 2;
	public static int SPELL_BASE= 3;
	
	private String name;
	private int category;
	private int lvl;//nivel de hechizo
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	public int getLvl() {
		return lvl;
	}
	public void setLvl(int lvl) {
		this.lvl = lvl;
	}

	
	
	
}
