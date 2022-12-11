package chars;

import java.util.List;
import java.util.Random;

public class Wizard extends BaseHero {

  private boolean magic;

  public Wizard(List<BaseHero> gang, List<BaseHero> enemies, int x, int y) {
    super("Stand", 17, 12, 30, 9, new int[] { -5, -5 });
    magic = true;
    super.gang = gang;
    super.position = new Vector2(x, y);
    this.enemies = enemies;
    count = new Random().nextInt(1, 2);
  }

  @Override
  public String getInfo() {
    return (
      this.getName() + " " + super.getInfo() + " magic: " + magic + ", " + state
    );
  }

  public String getName() {
    return "Волшебник";
  }

  @Override
  public void step() {
    double persent = 100;
    BaseHero injured = null;
    for (BaseHero i : this.gang) {
      if (i.maxHealth > i.health && persent > i.health / i.maxHealth) {
        injured = i;
        persent = i.health / i.maxHealth;
      }
    }
    if (injured != null) {
      if ((injured.maxHealth - injured.health) > (-1) * this.damage[0]) {
        injured.health = injured.health - this.damage[0];
      } else {
        injured.health = injured.health + (injured.maxHealth - injured.health);
      }
    }
  }
}
