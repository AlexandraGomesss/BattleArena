import java.util.Random;

public class Arena {

    private Random random = new Random();

    //battle begins
    public void hostFights(Creature hero, Creature villain) {
        System.out.println("Battle begins!");
        announceFighters(hero, villain);

        while(!hero.isDead() && !villain.isDead()) {
            if (random.nextBoolean()) {
                hero.takeTurn(villain);
                if (!villain.isDead()){
                    villain.takeTurn(hero);
                }
            } else {
                villain.takeTurn(hero);
                if (!hero.isDead()) hero.takeTurn(villain);
            }
        }
        announceWinner(hero, villain);
    }
    public void announceFighters(Creature hero, Creature villain) {
        System.out.println("Pay attention, our contenders entering the arena! " + hero.getName() + " vs " + villain.getName() + "!");
    }
    private void announceWinner (Creature hero, Creature villain) {
       if(!hero.isDead()) {
           System.out.println("The winner is " + hero.getName() + " and the loser is " + villain.getName() + "!");
       }
       else {
           System.out.println("The winner is " + villain.getName() + " and the loser is " + hero.getName() + "!");
       }
    }
}
