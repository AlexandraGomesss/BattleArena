
public class Game {
    public static void main(String[] args) {

    Hero hero = new Hero("Jahel", 2500, 850 );
    Villain villain = new Villain("Jailer", 2250, 950 );

    Arena arena = new Arena();
    arena.hostFights(hero,villain);
    }
}