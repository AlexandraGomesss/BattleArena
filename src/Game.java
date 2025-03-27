

public class Game {
    public static void main(String[] args) {

    Battlefield battlefield = new Battlefield();
    battlefield.makeGrid();
    Hero hero = new Hero("Jahel", 2500, 200 );
    Villain villain = new Villain("Jailer", 2250, 150 );

    Arena arena = new Arena();

    //MThe method the starts the game
    arena.hostFights(hero,villain);
    }
}