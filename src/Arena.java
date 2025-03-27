import java.util.Random;
import java.util.Scanner;

public class Arena {

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);

    // Battle begins
    public void hostFights(Creature hero, Creature villain) {
        System.out.println("Battle begins!");
        announceFighters(hero, villain);

        while (!hero.isDead() && !villain.isDead()) {
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine(); // Wait for user to press Enter

            if (random.nextBoolean()) {
                hero.takeTurn(villain);
                if (!villain.isDead()) {
                    System.out.println("\nPress Enter for " +  villain.getName() + "'s turn...");
                    scanner.nextLine(); // Wait for Enter again
                    villain.takeTurn(hero);
                }
            } else {
                villain.takeTurn(hero);
                if (!hero.isDead()) {
                    System.out.println("\nPress Enter for " + hero.getName() + "'s turn...");
                    scanner.nextLine();
                    hero.takeTurn(villain);
                }
            }
        }
        announceWinner(hero, villain);
    }

    public void announceFighters(Creature hero, Creature villain) {
        System.out.println("Pay attention, our contenders are entering the arena! " + hero.getName() + " vs " + villain.getName() + "!");
    }

    private void announceWinner(Creature hero, Creature villain) {
        if (!hero.isDead()) {
            System.out.println("The winner is " + hero.getName() + " and the loser is " + villain.getName() + "!");
        } else {
            System.out.println("The winner is " + villain.getName() + " and the loser is " + hero.getName() + "!");
        }
    }
}
