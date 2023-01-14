public class Square {
  private int row, col, type;
  private char status;
  private Square previous;

  public Square(int row, int col, int type) {
    this.row = row;
    this.col = col;
    this.type = type;
    status = '_';
    previous = null;
  }    

  public int getRow() {
    return row;
  }

  public int getCol() {
    return col;
  }

  public int getType() {
    return type;
  }

  public char getStatus() {
    return status;
  }

  public Square getPrevious() {
    return previous;
  }

  public void setStatus(char status) {
    this.status = status;
  }

  public void setPrevious(Square previous) {
    this.previous = previous;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Square))
      return false;

    Square other = (Square) obj;
    return other.getCol() == col && other.getRow() == row;
  }

  @Override
  public String toString() {
    switch (type) {
      case 1:
        return "#";

      case 2:
        return "S";

      case 3:
        return "E";
    }
    return String.valueOf(status);
  }
}