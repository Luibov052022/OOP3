package chars;

import java.util.List;

public class Spearman extends BaseHero {

  public Spearman(List<BaseHero> gang, int x, int y) {
    super("Stand", 4, 5, 10, 4, new int[] { 1, 3 });
    super.gang = gang;
    super.position = new Vector2(x, y);
    this.health = 4;
    this.maxHealth = 10;
  }
  public String getName() {
    return "Копейщик";
  }

  @Override
  public String getInfo() {
    return this.getName() + " " + super.getInfo() + ", " + state;
  }
}
