//to get the size of the square

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class MySquare {

    private Rectangle rectangle;
    private boolean isFilled = false;

    public MySquare(int x, int y, int cellSize) {
        this.rectangle = new Rectangle(x, y, cellSize, cellSize);
        rectangle.draw();
    }

    public void paint() {
        if (!isFilled) {
            rectangle.setColor(Color.BLACK);
            rectangle.fill();
        } else {
            rectangle.draw();
        }
        isFilled = !isFilled;  // Toggle state
    }
}