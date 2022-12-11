package chars;

import java.util.List;
import java.util.Random;

public class Peasant extends BaseHero {

  private boolean delievery;

  public Peasant(List<BaseHero> gang, List<BaseHero> enemies, int x, int y) {
    super("Stand", 1, 1, 1, 3, new int[] { 1, 1 });
    delievery = true;
    super.gang = gang;
    super.position = new Vector2(x, y);
    this.enemies = enemies;
    count = new Random().nextInt(1, 5);
  }

  public String getName() {
    return "Крестьянин";
  }

  @Override
  public String getInfo() {
    return (
      this.getName() +
      " " +
      super.getInfo() +
      " delievery: " +
      delievery +
      ", " +
      state
    );
  }

  @Override
  public void step() {
    if (state.equals("Busy")) {
      state = "Stand";
    }
  }
}
