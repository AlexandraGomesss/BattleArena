import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import java.util.Random;

public class MySquare {

    private Picture picture;
    private Picture leftPlayer;
    private Picture rightPlayer;
    private Text leftPlayerName;
    private Text rightPlayerName;
    private Random random = new Random();

    public MySquare(int x, int y, int cellSize, String leftName, String rightName) {
        // Sets the background image
        picture = new Picture(x, y, "resources/bg.jpg");
        picture.draw();

        // Sets the left player image
        leftPlayer = new Picture(x + 75, y + cellSize / 4, "resources/dps.png");
        leftPlayer.draw();

        // Sets the right player image
        rightPlayer = new Picture(x + cellSize - cellSize / 2.7, y + cellSize / 4, "resources/caster.png");
        rightPlayer.draw();

        // Displays left player's name
        leftPlayerName = new Text(x + 110, y + cellSize / 4 - 20, leftName);
        leftPlayerName.setColor(Color.WHITE);
        leftPlayerName.draw();

        // Displays right player's name
        rightPlayerName = new Text(x + cellSize - cellSize / 3.4, y + cellSize / 4 - 20, rightName);
        rightPlayerName.setColor(Color.WHITE);
        rightPlayerName.draw();

        // Starts the character movement animation
        startRandomAnimation();
    }

    //Animation method (calls the random movement method)
    private void startRandomAnimation() {
        Thread animationThread = new Thread(() -> {
            while (true) {
                try {
                    moveCharactersRandomly();
                    Thread.sleep(100 + random.nextInt(200)); // Randomize speed slightly
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        animationThread.start();
    }

    //Method to make the characters move randomly to the left and right
    private void moveCharactersRandomly() {
        int moveAmount = random.nextInt(6) + 2; // Move between 2-7 pixels per step
        boolean moveLeft = random.nextBoolean(); // Randomly decide direction

        if (moveLeft) {
            leftPlayer.translate(-moveAmount, 0);
            rightPlayer.translate(moveAmount, 0);
        } else {
            leftPlayer.translate(moveAmount, 0);
            rightPlayer.translate(-moveAmount, 0);
        }

        // Limits the range at which characters are allow to move / so they dont overlap
        int leftMinX = 60, leftMaxX = 120;
        int rightMinX = 500, rightMaxX = 560;

        if (leftPlayer.getX() < leftMinX) {
            leftPlayer.translate(moveAmount, 0);
        } else if (leftPlayer.getX() > leftMaxX) {
            leftPlayer.translate(-moveAmount, 0);
        }

        if (rightPlayer.getX() < rightMinX) {
            rightPlayer.translate(moveAmount, 0);
        } else if (rightPlayer.getX() > rightMaxX) {
            rightPlayer.translate(-moveAmount, 0);
        }
    }
}
