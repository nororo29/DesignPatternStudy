package decoratorPattern;


// Component �߻�Ŭ���� : ���� ��.
abstract class Beverage {
	public static final Integer TALL = 1;
	public static final Integer GRANDE = 2;
	public static final Integer VENTI = 3;
	
	String description = "�������";
	int size = Beverage.TALL;

	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		
	};

	public String getDescription() {
		return description;
	}
	
	public abstract double cost();
}

// Decorator �߻�Ŭ���� : Component ���
abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}

// ConcreateComponent 1 Ŭ���� : Espresso Ŭ����
class Espresso extends Beverage {
	
	public Espresso() {
		description = "Espresso";
	}

	@Override
	public double cost() {
		if (getSize() == Beverage.TALL)
			return 1.99;
		else if (getSize() == Beverage.GRANDE)
			return 2.99;
		else if (getSize() == Beverage.VENTI)
			return 3.99;
		
		return 1.99;
	}


	
}

//ConcreateComponent 2 Ŭ���� : HouseBlend Ŭ����
class HouseBlend extends Beverage {

	public HouseBlend() {
		description = "House Blend";
	}
	
	@Override
	public double cost() {
		if (getSize() == Beverage.TALL)
			return 1.99;
		else if (getSize() == Beverage.GRANDE)
			return 2.99;
		else if (getSize() == Beverage.VENTI)
			return 3.99;
		
		return 1.99;
	}

	
}

// ConcreateDecorator 1 Ŭ���� : Mocha ÷����
class Mocha extends CondimentDecorator {
	Beverage beverage;
	
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ��ī";
	}

	@Override
	public double cost() {
		return 0.20 + beverage.cost();
	}


	
}

class Soy extends CondimentDecorator {
	Beverage beverage;

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ����";
	}

	@Override
	public double cost() {
		return 0.15 + beverage.cost();
	}

	
}

class Whip extends CondimentDecorator {
	Beverage beverage;

	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
	
	@Override
	public String getDescription() {
		return beverage.getDescription() + ", ����ũ��";
	}

	@Override
	public double cost() {
		return 0.10 + beverage.cost();
	}
	
	
}



public class StarBuzzCoffee {

	public static void main(String[] args) {
		
		Beverage order1 = new Espresso();
		order1.setSize(1);
		System.out.println(order1.getSize() + " " + order1.getDescription() + ", $" + order1.cost());
		
		Beverage order2 = new Mocha(new Mocha(new HouseBlend()));
		System.out.println(order2.getSize() + " " + order2.getDescription() + ", $" + order2.cost());
		
		Beverage order3 = new Espresso();
		
		order3 = new Mocha(order3);
		order3 = new Mocha(order3);
		order3 = new Whip(order3);
		order3.setSize(3);

		
		System.out.println(order3.getSize() + " " + order3.getDescription() + ", $" + order3.cost());
		
	}

}
