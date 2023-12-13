package jom.com.softserve.s3.task1;

class Pizza {
	private String cheese;
	private String meat;
	private String seafood;
	private String vegetable;
	private String mushroom;

	private Pizza() {
	}

	public static PizzaBuilder base() {
		return new PizzaBuilder();
	}

	public void setCheese(String cheese) {
		this.cheese = cheese;
	}

	public void setMeat(String meat) {
		this.meat = meat;
	}

	public void setSeafood(String seafood) {
		this.seafood = seafood;
	}

	public void setVegetable(String vegetable) {
		this.vegetable = vegetable;
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

	public void setMushroom(String mushroom) {
		this.mushroom = mushroom;
	}

	public static class PizzaBuilder {
		private Pizza pizza;

		private PizzaBuilder() {
			pizza = new Pizza();
		}

		public PizzaBuilder addCheese(String cheese) {
			pizza.cheese = cheese;
			return this;
		}

		public PizzaBuilder addMeat(String meat) {
			pizza.meat = meat;
			return this;
		}

		public PizzaBuilder addSeafood(String seafood) {
			pizza.seafood = seafood;
			return this;
		}

		public PizzaBuilder addVegetable(String vegetable) {
			pizza.vegetable = vegetable;
			return this;
		}

		public PizzaBuilder addMushroom(String mushroom) {
			pizza.mushroom = mushroom;
			return this;
		}

		public Pizza build() {
			return pizza;
		}
	}
}

class Oven {
	public static Pizza cook() {
		return Pizza.base()
				.addCheese("Cheese")
				.addMushroom("Mushroom")
				.addSeafood("Seafood")
				.build();
	}
}