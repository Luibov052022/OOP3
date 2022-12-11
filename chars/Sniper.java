package chars;

import java.util.List;
import java.util.Random;

public class Sniper extends BaseHero {

  private int shoots;

  public Sniper(List<BaseHero> gang, List<BaseHero> enemies, int x, int y) {
    super("Stand", 12, 10, 15, 9, new int[] { 8, 10 });
    this.shoots = 32;
    super.gang = gang;
    super.position = new Vector2(x, y);
    this.enemies = enemies;
    count = new Random().nextInt(5, 8);
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

  @Override
  public void step() {
    for (BaseHero i : super.gang) {
      if (
        i.getName().equals("Крестьянин") &&
        !i.state.equals("Dead") &&
        !i.state.equals("Busy")
      ) {
        shoots++;
        i.state = "Busy";
        break;
      }
    }
    if (shoots > 0) {
      double dist = Double.MAX_VALUE;
      int index = -1;
      for (int i = 0; i < enemies.size(); i++) {
        double tmp = enemies
          .get(i)
          .getPosition()
          .getDistance(this.getPosition());
        if (dist > tmp && !enemies.get(i).getState().equals("Dead")) {
          dist = tmp;
          index = i;
        }
      }
      if (index >= 0) {
        shoots--;
        float damage = calcDamage(enemies.get(index));
        enemies.get(index).getHit(speed > dist ? damage : damage / 2);
      }
    }
  }
}
