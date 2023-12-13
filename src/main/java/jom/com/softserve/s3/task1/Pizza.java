package jom.com.softserve.s3.task1;

class Pizza {
	private String cheese;
	private String meat;
	private String seafood;
	private String vegetable;
	private String mushroom;

	private Pizza() {
	}

	public String getCheese() {
		return cheese;
	}

	public String getMeat() {
		return meat;
	}

	public String getSeafood() {
		return seafood;
	}

	public String getVegetable() {
		return vegetable;
	}

	public String getMushroom() {
		return mushroom;
	}

//	public static PizzaBuilder base() {
//		return new PizzaBuilder();
//	}

	// Describe PizzaBuilder class here

}

class Oven {
	public static Pizza cook() {
		// Create and return instance of Pizza class here
		return null;
	}
}