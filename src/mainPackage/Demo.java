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

interface Attackable{
    void attack();
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

class AttackWithHands implements Attackable{

    @Override
    public void attack() {
        System.out.println("Attacking with my dhai kilo ka haath.");
    }
}

class AttackWithKnife implements Attackable{

    @Override
    public void attack() {
        System.out.println("Attacking with knife.");
    }
}

abstract class Player{
    Flyable flyable;
    Attackable attackable;

    public void setFlyable(Flyable flyable) {
        this.flyable = flyable;
    }

    public void setAttackable(Attackable attackable) {
        this.attackable = attackable;
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

    public void performAttack() {
        attackable.attack();
    }
}

class Alex extends Player{
    Alex(Flyable flyable, Attackable attackable)  {
        super.flyable = flyable;
        super.attackable = attackable;
    }

    public void display()   {
        System.out.println("I am Alex. Naam to suna hi hoga.");
    }
}

class Sam extends Player{
    Sam(Flyable flyable, Attackable attackable)  {
        super.flyable = flyable;
        super.attackable = attackable;
    }

    public void display()   {
        System.out.println("I am Sam. Naam to suna hi hoga. Maybe.");
    }
}

class Gaitonde extends Player{
    Gaitonde(Flyable flyable, Attackable attackable)   {
        super.flyable = flyable;
        super.attackable = attackable;
    }

    public void display()   {
        System.out.println("Ganesh Gaitonde hai apun.");
    }
}

public class Demo {
    public static void main(String[] args) {
        Player player = new Alex(new CantFly(), new AttackWithHands());
        player.display();
        player.performFly();
        player.performAttack();
        player = new Sam(new CanFly(), new AttackWithHands());
        player.display();
        player.performFly();
        player.performAttack();
        player = new Gaitonde(new CanFlyWithJet(), new AttackWithKnife());
        player.display();
        player.performFly();
        player.performAttack();
    }
}
