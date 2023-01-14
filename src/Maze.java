import java.io.*;
import java.util.*;

public class Maze {
  private Square[][] maze;
  private Square start, exit;

  public Maze() {
  }

  public Square getStart() {
    return start;
  }

  public Square getExit() {
    return exit;
  }

  public boolean loadMaze(String filename) {
    try {
      Scanner scanner = new Scanner(new File(filename));
      int height, width;
      height = scanner.nextInt();
      width = scanner.nextInt();
      maze = new Square[height][width];
      for (int row = 0; row < height; row++)
        for (int col = 0; col < width; col++) {
          
          int type = scanner.nextInt();
          Square square = new Square(row, col, type);
          switch (type) {
            case 2:
              start = square;
              break;

            case 3:
              exit = square;
          }
          maze[row][col] = square;
    }}
    catch (IOException IOException) {
      System.out.println("Failed to read file as a maze.");
      System.out.println(IOException.getMessage());
      return false;
    }
    return true;
  }

  public List<Square> getNeighbours(Square s) {
    List<Square> neighbours = new ArrayList<Square>();
    int sCol, sRow;
    sCol = s.getCol();
    sRow = s.getRow();
    
    int[] neighbourCols, neighbourRows;
    neighbourCols = new int[] {
		sCol,
		sCol + 1,
		sCol,
		sCol - 1
    };
    neighbourRows = new int[] {
		sRow - 1,
		sRow,
		sRow + 1,
		sRow
    };
    for (int i = 0; i < neighbourCols.length; i++) {
        try {
          neighbours.add(maze[neighbourRows[i]][neighbourCols[i]]);
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {} // ignore borders
    }
    return neighbours;
  }

  public void reset() {
    for (int row = 0; row < maze.length; row++)
    	for (int col = 0; col < maze[0].length; col++) {
    		Square square = maze[row][col];
    		if (square.getType() == 0)
    			square.setStatus('_');
          square.setPrevious(null);
    	}
  }

  @Override
  public String toString() {
    String output = "";
    for (int row = 0; row < maze.length; row++) {
      for (int col = 0; col < maze[0].length; col++) 
        output += maze[row][col] + " ";
      output += '\n';
    }
    return output;
  } 

  public static void main(String[] args) throws IOException {
    Maze maze = new Maze();
    maze.loadMaze("maze-2");
    System.out.println(maze);
  }
}