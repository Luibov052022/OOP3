package chars;

import java.util.List;

public class Peasant extends BaseHero {

  private boolean delievery;

  public Peasant(List<BaseHero> gang, int x, int y) {
    super("Stand", 1, 1, 1, 3, new int[] { 1, 1 });
    delievery = true;
    super.gang = gang;
    super.position = new Vector2(x, y);
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
}
