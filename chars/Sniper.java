package chars;

import java.util.List;

public class Sniper extends BaseHero {

  private int shoots;

  public Sniper(List<BaseHero> gang, int x, int y) {
    super("Stand", 12, 10, 15, 9, new int[] { 8, 10 });
    this.shoots = 32;
    super.gang = gang;
    super.position = new Vector2(x, y);
  }

  public String getName() {
    return "Снайпер";
  }

  @Override
  public String getInfo() {
    return (
      this.getName() +
      " " +
      super.getInfo() +
      " Shoots: " +
      shoots +
      ", " +
      state
    );
  }
}
