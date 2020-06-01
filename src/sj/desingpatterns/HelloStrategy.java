package sj.desingpatterns;

public class HelloStrategy {
    public static void main(String [] args){

        WelcomeMsg welcomeMsg = new WelcomeMsg();
//1
        welcomeMsg.setPs(new UpperCasePrint());
        welcomeMsg.setWelcomeMsg("welcome to Strategy");
        welcomeMsg.greet();
  //2
        welcomeMsg.setPs(new LowerCasePrint());
        welcomeMsg.setWelcomeMsg("welcome to Strategy");
        welcomeMsg.greet();
 //3
        welcomeMsg.setPs((msg)->{
            System.out.println("Lambda "+ msg);
        });
        welcomeMsg.setWelcomeMsg("welcome to Strategy");
        welcomeMsg.greet();


    }
}


interface PrintStrategy{
    public void print(String msg);
}


class UpperCasePrint implements PrintStrategy{

    @Override
    public void print(String msg) {
        System.out.println(msg.toUpperCase());
    }
}

class LowerCasePrint implements PrintStrategy {

    @Override
    public void print(String msg) {
        System.out.println(msg.toLowerCase());
    }
}

class Namste implements PrintStrategy {

    @Override
    public void print(String msg) {
        System.out.println("Namaste");
    }
}

class WelcomeMsg{
    public void setPs(PrintStrategy ps) {
        this.ps = ps;
    }

    private PrintStrategy ps;
    private String welcomeMsg;

    public void greet(){


        ps.print(welcomeMsg);
    }

    public void setWelcomeMsg(String welcomeMsg) {
        this.welcomeMsg = welcomeMsg;
    }
}
