import chars.BaseHero;
import chars.Monk;
import chars.Peasant;
import chars.Robber;
import chars.Sniper;
import chars.Spearman;
import chars.Wizard;
import chars.Xbowman;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

  static final int GANG_SIZE = 10;
  public static List<BaseHero> whiteSide;
  public static List<BaseHero> darkSide;

  public static void main(String[] args) {
    init();
    Scanner sc = new Scanner(System.in);
    while (true) {
      ConsoleView.view();
      turnMove();
      sc.nextLine();
    }
  }

  private static void turnMove() {
    List<BaseHero> sorting = new ArrayList<>();
    sorting.addAll(darkSide);
    sorting.addAll(whiteSide);
    sorting.sort(
      new Comparator<BaseHero>() {
        @Override
        public int compare(BaseHero o1, BaseHero o2) {
          int tmp = o2.getSpeed() - o1.getSpeed();
          return tmp;
        }
      }
    );
    sorting.forEach(BaseHero::step);
  }

  private static void init() {
    whiteSide = new ArrayList<>();
    darkSide = new ArrayList<>();
    int x = 1;
    int y = 1;
    for (int i = 0; i < GANG_SIZE; i++) {
      switch (new Random().nextInt(4)) {
        case 0 -> whiteSide.add(new Peasant(whiteSide, darkSide, x, y++));
        case 1 -> whiteSide.add(new Robber(whiteSide, darkSide, x, y++));
        case 2 -> whiteSide.add(new Wizard(whiteSide, darkSide, x, y++));
        default -> whiteSide.add(new Sniper(whiteSide, darkSide, x, y++));
      }
    }
    y = 1;
    x = GANG_SIZE;
    for (int i = 0; i < GANG_SIZE; i++) {
      switch (new Random().nextInt(4)) {
        case 0 -> darkSide.add(new Peasant(darkSide, whiteSide, x, y++));
        case 1 -> darkSide.add(new Spearman(darkSide, whiteSide, x, y++));
        case 2 -> darkSide.add(new Monk(darkSide, whiteSide, x, y++));
        default -> darkSide.add(new Xbowman(darkSide, whiteSide, x, y++));
      }
    }
  }
}
