package chars;

import java.util.List;

public class Robber extends BaseHero {

  public Robber(List<BaseHero> gang, int x, int y) {
    super("Stand", 8, 3, 10, 6, new int[] { 2, 4 });
    this.health = 8;
    this.maxHealth = 10;
    super.gang = gang;
    super.position = new Vector2(x, y);
  }

  public String getName() {
    return "Разбойник";
  }

  @Override
  public String getInfo() {
    return this.getName() + " " + super.getInfo() + ", " + state;
  }
}
