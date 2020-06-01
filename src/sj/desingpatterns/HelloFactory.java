package sj.desingpatterns;

import java.util.Optional;

public class HelloFactory {
    public static void main(String[] args) {
        Optional<Beverage> tea = BeverageFactory.getBeverage("Tea");

        tea.ifPresent(x->x.prepare());
    }
}


class BeverageFactory{

    public static Optional<Beverage> getBeverage(String name){

        if (name == "Tea"){
            return Optional.of(new Tea());
        }else if (name == "Coffee"){
            return Optional.of(new Coffee());
        }else if (name == "Lemonade"){
            return Optional.of(new Lemonade());
        }else if (name == "MilkShake"){
            return Optional.of(new MilkShake());
        }
        return Optional.empty();
    }


}

interface Beverage{
    void prepare();
}

class Tea implements Beverage{

    @Override
    public void prepare() {
        System.out.println("Tea is ready!!!");
    }
}

class Coffee implements Beverage{

    @Override
    public void prepare() {
        System.out.println("Coffee is ready!!!");
    }
}
class Lemonade implements Beverage{

    @Override
    public void prepare() {
        System.out.println("Lemonade is ready!!!");
    }
}
class MilkShake implements Beverage{

    @Override
    public void prepare() {
        System.out.println("MilkShake is ready!!!");
    }
}