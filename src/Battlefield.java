public class Battlefield {

    private int columns = 1;
    private int rows = 1;
    private int padding = 10;
    private int cellSize = 800;
    private MySquare[][] squares;

    public Battlefield() {
        squares = new MySquare[columns][rows];
        makeGrid();
    }

    public void makeGrid() {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                int x = padding + col * cellSize;
                int y = padding + row * cellSize;
                squares[col][row] = new MySquare(x, y, cellSize);
            }
        }
    }

    public MySquare getSquareAt(int x, int y) {
        int col = (x - padding) / cellSize;
        int row = (y - padding) / cellSize;

        if (col < 0 || col >= columns || row < 0 || row >= rows) {
            return null;
        }

        return squares[col][row];
    }
}