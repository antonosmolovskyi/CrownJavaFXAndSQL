package classwork16;

public class Ranks {
	private int id;
	private String name;
	private int steps;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSteps() {
		return steps;
	}
	public void setSteps(int steps) {
		this.steps = steps;
	}
	@Override
	public String toString() {
		return "Ranks [id=" + " id " + id + "name=" + name + ", steps=" + steps + "]";
	}
	public Ranks(int id ,String name, int steps) {
		super();
		this.id = id;
		this.name = name;
		this.steps = steps;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
}
