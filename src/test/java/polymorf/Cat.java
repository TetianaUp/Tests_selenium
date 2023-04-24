package polymorf;

public class Cat extends Animal implements Flyable{
    @Override
    public void speak() {
        System.out.println("meow, meow");
    }

    @Override
    public void fly() {

    }
}
