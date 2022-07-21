package mainPackage;

//Motto of today's tutorial is to understand basics of System Design.
/*
    We will design MMORPG game. Multiple player can play role playing game simultaneously. Kinda PUBG.
 */

/*
    - Code for supertype. Don't code for subtype. In other words, code for interface, not for implementation.
    - Prefer composition instead inheritance. In other words, prefer has-a relationship over is-a relationship.
    - Encapsulate what varies.
    - This design pattern is strategy design pattern.
 */

interface Flyable{
    void fly();
}

class CanFly implements Flyable{

    @Override
    public void fly() {
        System.out.println("Aaj mai upar, Aasma neeche.");
    }
}

class CantFly implements Flyable{

    @Override
    public void fly() {
        System.out.println("Bhai 500 zyada lele lekin land kara de.");
    }
}

class CanFlyWithJet implements Flyable{

    @Override
    public void fly() {
        System.out.println("Chand pe hai apun. Jet ke sath.");
    }
}

abstract class Player{
    Flyable flyable;

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public void eat()   {
        System.out.println("Eating.");
    }

    public void sleep() {
        System.out.println("Sleeping.");
    }

    abstract void display(); //This is abstraction.

    public void performFly()    {
        flyable.fly(); //This is encapsulation.
    }
}

class Alex extends Player{
    Alex(Flyable flyable)  {
        super.flyable = flyable;
    }

    public void display()   {
        System.out.println("I am Alex. Naam to suna hi hoga.");
    }
}

class Sam extends Player{
    Sam(Flyable flyable)  {
        super.flyable = flyable;
    }

    public void display()   {
        System.out.println("I am Sam. Naam to suna hi hoga. Maybe.");
    }
}

class Gaitonde extends Player{
    Gaitonde(Flyable flyable)   {
        super.flyable = flyable;
    }

    public void display()   {
        System.out.println("Ganesh Gaitonde hai apun.");
    }
}

public class Demo {
    public static void main(String[] args) {
        Player player = new Alex(new CantFly());
        player.display();
        player.performFly();
        player = new Sam(new CanFly());
        player.display();
        player.performFly();
        player = new Gaitonde(new CanFlyWithJet());
        player.display();
        player.performFly();
    }
}
