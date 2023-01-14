public abstract class MazeSolver {
  protected Maze maze;
  protected String path;

  public MazeSolver(Maze maze) {
    this.maze = maze;
    path = "unsolved";
    makeEmpty();
    add(maze.getStart());
  }

  /**
   * Create an empty worklist, i.e. make a new worklist object with no elements.
   * Normally initializing the worklist would take place in the constructor, however the GUI uses a call to this method, so it must be kept separate.
   */
  abstract public void makeEmpty();

  abstract public boolean isEmpty();

  /** 
   * Add the given square to the worklist
   *
   * @param {Square} s - working square
   */
  abstract public void add(Square s);

  /** Return the "next" item from the worklist */
  abstract public Square next();

  abstract public void pop();

  public boolean isSolved() {
    return path.equals("solved") || path.equals("unsolvable");
  }

  public void step() {
    if (isEmpty()) { // unsolvable
      path = "unsolvable";
      return;
    }
    
    Square next = next();
    pop();
    
    for (Square neighbour : maze.getNeighbours(next)) {
      if (neighbour.getType() == 3) { // found exit
        path = "solved";
        neighbour.setPrevious(next);
        break;
      }
      if (!neighbour.toString().equals("_")) // already used
        continue;

      add(neighbour);
      neighbour.setStatus('o');
      neighbour.setPrevious(next);

    }
    next.setStatus('.');
  }

  public String getPath() {
    if (!path.equals("solved")) 
      return path;
    
    String output = "";
    Square square = maze.getExit();
    while (square != null) {
      square.setStatus('x');
      output = String.format("[%d, %d], ", square.getRow(), square.getCol()) + output;
      square = square.getPrevious();
    }

    return String.format("[%s]", output.substring(0, output.length() - 2));
  }

  public void solve() {
    while (!isSolved())
      step();
  }
}
