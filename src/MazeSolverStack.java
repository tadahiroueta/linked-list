public class MazeSolverStack extends MazeSolver {
  private MyStack workList;
  
  public MazeSolverStack(Maze maze) {
    super(maze);
  }

  @Override
  public void makeEmpty() {
    workList = new MyStack();
  }

  @Override
  public boolean isEmpty() {
    return workList.isEmpty();
  }

  @Override
  public void add(Square s) {
    workList.push(s);
  }

  @Override
  public Square next() {
    return workList.peek();
  }

  @Override
  public void pop() {
    workList.pop();
  }
}