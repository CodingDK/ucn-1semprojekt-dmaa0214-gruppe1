package modelLayer;

public class Discount {
	private static int idIterator = 0;
	private int id;
	private String name;
	private double percent;
	
	public Discount(String name, double percent){
		idIterator++;
		this.id = idIterator;
		this.name = name;
		this.percent = percent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercent() {
		return percent;
	}

	public void setPercent(double percent) {
		this.percent = percent;
	}

	public int getId() {
		return id;
	}

}
