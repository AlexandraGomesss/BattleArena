public class Arena {

    //battle begins
    public void hostFights(Creature hero, Creature villain) {
        System.out.println("Battle begins!");
        announceFighters(hero, villain);
    }
    public void announceFighters(Creature hero, Creature villain) {
        System.out.println("Pay attention, our contenders entering the arena! " + hero.getName() + " vs " + villain.getName() + "!");
    }
    private void announceWinner (Creature hero, Creature villain) {
        System.out.println("Winner is " );
        System.out.println("Loser is");
    }
}
