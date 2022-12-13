package chars;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Monk extends BaseHero {

  private boolean magic;
  static int tmpInd;

  public Monk(List<BaseHero> gang, List<BaseHero> enemies, int x, int y) {
    super("Stand", 17, 12, 30, 9, new int[] { -5, -5 });
    magic = true;
    super.gang = gang;
    super.position = new Vector2(x, y);
    this.health = 20;
    this.maxHealth = 30;
    this.enemies = enemies;
    count = new Random().nextInt(3, 5);
  }

  public String getName() {
    return "Монах";
  }

  @Override
  public String getInfo() {
    return (
      this.getName() + " " + super.getInfo() + " magic: " + magic + ", " + state
    );
  }

  @Override
  public void step() {
    /*double persent = 100;
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
    }*/
    Map<Integer, Double> healths = new HashMap<>();
    for (int i = 0; i < gang.size(); i++) {
      healths.put(i, (double) (gang.get(i).health / gang.get(i).maxHealth));
    }
    List<Double> a = new ArrayList<>(healths.values().stream().toList());
    Collections.sort(a);
    healths.forEach((index, value) -> {
      if (value.equals(a.get(0))) {
        tmpInd = index;
      }
    });
    if (a.get(0) > 0.5) {
      double dist = 1;
      int index = -1;
      for (int i = 0; i < enemies.size(); i++) {
        if (enemies.get(i).getState().equals("Dead")) {
          continue;
        }
        if (enemies.get(i).health / enemies.get(i).maxHealth < dist) {
          dist = enemies.get(i).health / enemies.get(i).maxHealth;
          index = i;
        }
      }
      if (index < 0) {
        index = 0;
      }
      enemies.get(index).getHit(damage[0] * -1);
      state = "Hit " + index;
      return;
    }
    if (a.get(0).equals(0.0)) {
      tmpInd = -1;
      healths.forEach((index, value) -> {
        if (value.equals(0.0)) {
          if (
            gang.get(index).getName().equals("Лучник") ||
            gang.get(index).getName().equals("Монах")
          ) {
            tmpInd = index;
          }
        }
      });
      if (tmpInd >= 0) {
        gang.get(tmpInd).health = 1;
        gang.get(tmpInd).state = "Stand";
        gang.get(tmpInd).count = 1;
        state = "Resurrect " + tmpInd;
      }
      return;
    }
    if (a.get(0) <= 0.5) {
      gang.get(tmpInd).health -= this.damage[0];
      if (gang.get(tmpInd).health > gang.get(tmpInd).maxHealth) {
        gang.get(tmpInd).health = gang.get(tmpInd).maxHealth;
      }
      state = "Heal " + tmpInd;
    }
  }
}
