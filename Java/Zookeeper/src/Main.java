public class Main {
    public static void main(String[] args) {

        Gorilla g = new Gorilla();

        g.gorillaThrow();
        g.gorillaThrow();
        g.gorillaThrow();

        g.eatBananas();
        g.eatBananas();

        g.climb();

        g.displayEnergy();

        Bat b = new Bat();

        b.attackTown();
        b.attackTown();
        b.attackTown();

        b.eatHumans();
        b.eatHumans();

        b.fly();
        b.fly();

        b.displayEnergy();
    }
}