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
        // Load the background
        picture = new Picture(x, y, "resources/bg.jpg");
        picture.draw();

        // Load the left player image
        leftPlayer = new Picture(x + 75, y + cellSize / 4, "resources/dps.png");
        leftPlayer.draw();

        // Load the right player image
        rightPlayer = new Picture(x + cellSize - cellSize / 2.7, y + cellSize / 4, "resources/caster.png");
        rightPlayer.draw();

        // Display left player's name above their head
        leftPlayerName = new Text(x + 110, y + cellSize / 4 - 20, leftName);
        leftPlayerName.setColor(Color.WHITE);
        leftPlayerName.draw();

        // Display right player's name above their head
        rightPlayerName = new Text(x + cellSize - cellSize / 3.4, y + cellSize / 4 - 20, rightName);
        rightPlayerName.setColor(Color.WHITE);
        rightPlayerName.draw();

        // Start character movement animation
        startRandomAnimation();
    }

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

        // Constrain movement within a reasonable range
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
