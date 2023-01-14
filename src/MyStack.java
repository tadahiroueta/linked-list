import java.util.*;

public class MyStack implements StackADT {
  Square[] stack;  int size;

  public MyStack() {
    this(1000);
  }

  public MyStack(int initCap) {
    size = initCap;
    stack = new Square[size];
  }

  public boolean isEmpty() {
    for (Square Square : stack)
      if (Square != null)
        return false;

    return true;
  }

  private int getLastSquareIndex() {
    for (int i = size - 1; i >= 0; i--)
      if (stack[i] != null)
        return i;

    return -1; // is empty
  }

  public Square peek() throws EmptyStackException {
    try {
      return stack[getLastSquareIndex()];
    }
    catch (Exception exception) {
      throw new EmptyStackException();
    }
  }

  public Square pop() throws EmptyStackException {
    Square removed = peek();
    stack[getLastSquareIndex()] = null;
    return removed;
  }
  
  public void push(Square item) {
    try {
      stack[getLastSquareIndex() + 1] = item;
    }
    catch (Exception exception) {
      doubleCapacity();
      push(item);
    }
  }

  private void doubleCapacity() {
    size *= 2;
    System.arraycopy(stack, 0, stack, 0, stack.length); 
  }

  public int size() {
    return size;
  }

  public void clear() {
    while (!isEmpty())
      pop();
  }

  @Override
  public String toString() {
    String output = "";
    for (Square Square : stack)
      if (Square != null)
        output += Square + " | ";

    int outputLength = output.length();
    return outputLength > 0 ? output.substring(0, outputLength - 3) : output; 
  }
}