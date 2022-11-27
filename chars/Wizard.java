package chars;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wizard extends BaseHero {

  private boolean magic;

  public Wizard(List<BaseHero> gang, int x, int y) {
    super("Stand", 17, 12, 30, 9, new int[] { -5, -5 });
    magic = true;
    super.gang = gang;
    super.position = new Vector2(x, y);
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
    //ArrayList<BaseHero> temp = new ArrayList<>();
    //temp.addAll(this.gang);
    //Collections.sort(temp, new MyComparator());
    //System.out.println(this.gang);
    //System.out.println(temp);
    //for (int i = 0; i < this.gang.size(); i++) {
    //  if (this.gang.get(i).equals(temp.get(0))) {
    //    this.gang.get(i).health -= this.damage[0];
    //    System.out.println(this.gang.get(i));
    //    break;
    //   }
    // }
    //}
    double persent = 100;
    BaseHero injured = null;
    for (BaseHero i : this.gang) {
      if (i.maxHealth > i.health && persent > i.health / i.maxHealth) {
        injured = i;
       // System.out.println(injured + " " + this.gang);
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
