package chars;

public class Vector2 {

  int x, y;

  public Vector2(int x, int y) {
    this.x = x;
    this.y = y;
  }

  public Boolean isEquals(Vector2 opposit) {
    if (x == opposit.x && y == opposit.y) return true;
    return false;
  }
  public double getDistance(Vector2 opposit){
    return Math.sqrt(Math.pow(this.x-opposit.x,2) + Math.pow(this.y-opposit.y,2));
  }
}
