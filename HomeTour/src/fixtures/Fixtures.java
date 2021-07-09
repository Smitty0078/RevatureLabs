package fixtures;

public abstract class Fixtures {

	private String name;
	private String shortDesc;
	private String longDesc;
	
	public Fixtures(String name, String shortDesc, String longDesc) {
		super();
		this.name = name;
		this.shortDesc = shortDesc;
		this.longDesc = longDesc;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDesc() {
		return shortDesc;
	}
	public void setShortDesc(String shortDesc) {
		this.shortDesc = shortDesc;
	}
	public String getLongDesc() {
		return longDesc;
	}
	@Override
	public String toString() {
		return "Fixtures [name=" + name + ", shortDesc=" + shortDesc + ", longDesc=" + longDesc + "]";
	}

	public void setLongDesc(String longDesc) {
		this.longDesc = longDesc;
	}
	
}
