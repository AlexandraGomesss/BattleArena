

public class Game {
    public static void main(String[] args) {

    Battlefield battlefield = new Battlefield();
    battlefield.makeGrid();
    Hero hero = new Hero("Jahel", 2500, 850 );
    Villain villain = new Villain("Jailer", 2250, 750 );

    Arena arena = new Arena();
    arena.hostFights(hero,villain);
    }
}