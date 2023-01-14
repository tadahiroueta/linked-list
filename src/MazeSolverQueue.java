public class MazeSolverQueue extends MazeSolver {
    private MyQueue<Square> workList;

    public MazeSolverQueue(Maze maze) {
        super(maze);
    }

    @Override
    public void makeEmpty() {
        workList = new MyQueue<Square>();
    }

    @Override
    public boolean isEmpty() {
        return workList.isEmpty();
    }

    @Override
    public void add(Square s) {
        workList.offer(s);
    }

    @Override
    public Square next() {
        return workList.peek();
    }

    @Override
    public void pop() {
        workList.poll();
    }
}
