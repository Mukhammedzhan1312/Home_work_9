//Модуль 09 Структурные паттерны. Декоратор
interface Beverage {
    String getDescription();
    double cost();
}

class Espresso implements Beverage {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double cost() {
        return 2.0;
    }
}

class Tea implements Beverage {
    @Override
    public String getDescription() {
        return "Tea";
    }

    @Override
    public double cost() {
        return 1.5;
    }
}


abstract class BeverageDecorator implements Beverage {
    protected Beverage beverage;

    public BeverageDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription();
    }

    @Override
    public double cost() {
        return beverage.cost();
    }
}

class Milk extends BeverageDecorator {
    public Milk(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.5;
    }
}

class Sugar extends BeverageDecorator {
    public Sugar(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.2;
    }
}

class WhippedCream extends BeverageDecorator {
    public WhippedCream(Beverage beverage) {
        super(beverage);
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", Whipped Cream";
    }

    @Override
    public double cost() {
        return beverage.cost() + 0.7;
    }
}


public class Main {
    public static void main(String[] args) {
        Beverage order = new Espresso();
        order = new Milk(order);
        order = new Sugar(order);
        order = new WhippedCream(order);
        System.out.println("Order: " + order.getDescription());
        System.out.println("Total Cost: $" + order.cost());
    }
}
