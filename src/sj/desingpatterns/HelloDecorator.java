package sj.desingpatterns;

public class HelloDecorator {

    public static void main(String[] args){

        Pizza specialPizza = new CheesePizza();
        Pizza extraCheeseSpecialPizza = new ExtraCheeseDecorator(specialPizza);
        Pizza extraJalapenoExtraCheeseSpecialPizza = new ExtraJalapenosDecorator(extraCheeseSpecialPizza);

        System.out.println("Ingredients: "+extraJalapenoExtraCheeseSpecialPizza.ingredient());
        System.out.println("Price: " +extraJalapenoExtraCheeseSpecialPizza.price());

    }
}


interface  Pizza{

    int price();
    String ingredient();
}

class CheesePizza implements Pizza{

    @Override
    public int price() {
            return 10;
    }

    @Override
    public String ingredient() {
        return "Dough" + " Cheeze";
    }
}

class VegExtraVenza implements Pizza{

    @Override
    public int price() {
            return 20;
    }
    @Override
    public String ingredient() {
        return "Dough" + " Cheese" + " Black Olives" +" Mashroom";
    }
}

interface PizzaDecorator extends Pizza{

    private String getName(){
        return "sdfds";
    }

    default String getNameDefault(){


        return getName();
    }
}

class ExtraCheeseDecorator implements PizzaDecorator{

    private final Pizza pizza;

    public ExtraCheeseDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int price() {
        return this.pizza.price() + 1;
    }

    @Override
    public String ingredient() {
        return this.pizza.ingredient() + " Extra Cheese";
    }
}
class ExtraJalapenosDecorator implements PizzaDecorator{

    private final Pizza pizza;

    public ExtraJalapenosDecorator(Pizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int price() {
        return this.pizza.price() + 2;
    }

    @Override
    public String ingredient() {
        return this.pizza.ingredient() + " Extra Jalapenos";
    }
}