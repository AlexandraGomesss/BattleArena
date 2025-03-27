import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.Random;
import java.util.Scanner;

public class Arena {

    private Random random = new Random();
    private Scanner scanner = new Scanner(System.in);
    private Picture battleStartImage;
    private Picture gameOverImage;

    // Battle begins
    public void hostFights(Creature hero, Creature villain) {
        System.out.println("Battle begins!");
        announceFighters(hero, villain);

        // Displays the battle start image
        showBattleStartImage();

        System.out.println("\nPress Enter to start the battle...");
        scanner.nextLine(); // Wait for user to press Enter

        // Removes the image when the first Enter is pressed
        removeBattleStartImage();

        while (!hero.isDead() && !villain.isDead()) {
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();

            if (random.nextBoolean()) {
                hero.takeTurn(villain);
                if (!villain.isDead()) {
                    System.out.println("\nPress Enter for " + villain.getName() + "'s turn...");
                    scanner.nextLine();
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

        // Announces the winner and shows game over image
        announceWinner(hero, villain);
        showGameOverImage();
    }

    public void announceFighters(Creature hero, Creature villain) {
        System.out.println("Pay attention, our contenders are entering the arena! " + hero.getName() + " vs " + villain.getName() + "!");
    }

    private void showBattleStartImage() {
        battleStartImage = new Picture(200, 50, "resources/fight.png"); // Adjust position as needed
        battleStartImage.draw();
    }

    private void removeBattleStartImage() {
        if (battleStartImage != null) {
            battleStartImage.delete(); // Remove the image from the screen
        }
    }

    private void showGameOverImage() {
        gameOverImage = new Picture(200, 100, "resources/game_over.png"); // Adjust position as needed
        gameOverImage.draw();
    }

    private void announceWinner(Creature hero, Creature villain) {
        if (!hero.isDead()) {
            System.out.println("The winner is " + hero.getName() + " and the loser is " + villain.getName() + "!");
        } else {
            System.out.println("The winner is " + villain.getName() + " and the loser is " + hero.getName() + "!");
        }
    }
}
