import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class MySquare {

    private Picture picture;
    private Picture leftPlayer;
    private Picture rightPlayer;
    private Text leftPlayerName;
    private Text rightPlayerName;

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
        leftPlayerName = new Text(x + 110, y + cellSize / 4 - 20, leftName); // Adjust position
        leftPlayerName.setColor(Color.WHITE);
        leftPlayerName.draw();


        // Display right player's name above their head
        rightPlayerName = new Text(x + cellSize - cellSize / 3.4, y + cellSize / 4 - 20, rightName); // Adjust position
        rightPlayerName.setColor(Color.WHITE);
        rightPlayerName.draw();
    }
}
