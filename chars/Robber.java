package chars;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

public class Robber extends BaseHero {

  public Robber(List<BaseHero> gang, List<BaseHero> enemies, int x, int y) {
    super("Stand", 8, 3, 10, 6, new int[] { 2, 4 });
    this.health = 8;
    this.maxHealth = 10;
    super.gang = gang;
    super.position = new Vector2(x, y);
    this.enemies = enemies;
    count = new Random().nextInt(10, 20);
  }

  public String getName() {
    return "Разбойник";
  }

  @Override
  public String getInfo() {
    return this.getName() + " " + super.getInfo() + ", " + state;
  }

  @Override
  public void step() {
    double dist = Double.MAX_VALUE;
    int index = -1;
    for (int i = 0; i < enemies.size(); i++) {
      double tmp = enemies.get(i).getPosition().getDistance(this.getPosition());
      if (dist > tmp && !enemies.get(i).getState().equals("Dead")) {
        dist = tmp;
        index = i;
      }
    }
    if (index >= 0) {
      if (dist < 2) {
        float damage = calcDamage(enemies.get(index));
        enemies.get(index).getHit(damage);
      } else {
        Vector2 enemyPos = enemies.get(index).getPosition();
        Vector2 newPos = new Vector2(0, 0);
        if (enemyPos.y == position.y) {
          newPos.y = position.y;

          if (position.x - enemyPos.x < 0) {
            newPos.x = position.x + 1;
          } else {
            newPos.x = position.x - 1;
          }
        } else {
          newPos.x = position.x;

          if (position.y - enemyPos.y > 0) {
            newPos.y = position.y + 1;
          } else {
            newPos.y = position.y - 1;
          }
        }
        AtomicBoolean empty = new AtomicBoolean(true);
        gang.forEach(unit -> {
          if (unit.getPosition().equals(empty)) {
            empty.set(false);
          }
        });
        if (empty.get()) {
          position = newPos;
        }
      }
    }
  }
}
