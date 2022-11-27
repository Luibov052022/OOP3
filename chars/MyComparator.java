package chars;
import java.util.Comparator;

public class MyComparator implements Comparator<BaseHero> {

  public int compare(BaseHero o1, BaseHero o2) {
    if (o1.getHealth() / o1.getMHealth() > o2.getHealth() / o2.getMHealth()) {
      return 1;
    } else if (
      o1.getHealth() / o1.getMHealth() < o2.getHealth() / o2.getMHealth()
    ) {
      return -1;
    }
    return 0;
  }
}
