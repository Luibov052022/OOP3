import chars.BaseHero;
import chars.Monk;
import chars.Peasant;
import chars.Robber;
import chars.Sniper;
import chars.Spearman;
import chars.Wizard;
import chars.Xbowman;
import java.util.ArrayList;
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
      whiteSide.forEach(n -> n.step());
      darkSide.forEach(k -> k.step());
      sc.nextLine();
    }
  }

  private static void init() {
    whiteSide = new ArrayList<>();
    darkSide = new ArrayList<>();
    int x = 1;
    int y = 1;
    for (int i = 0; i < GANG_SIZE; i++) {
      switch (new Random().nextInt(4)) {
        case 0 -> whiteSide.add(new Peasant(whiteSide, x, y++));
        case 1 -> whiteSide.add(new Robber(whiteSide, x, y++));
        case 2 -> whiteSide.add(new Wizard(whiteSide, x, y++));
        default -> whiteSide.add(new Sniper(whiteSide, x, y++));
      }
    }
    y = 1;
    x = GANG_SIZE;
    for (int i = 0; i < GANG_SIZE; i++) {
      switch (new Random().nextInt(4)) {
        case 0 -> darkSide.add(new Peasant(darkSide, x, y++));
        case 1 -> darkSide.add(new Spearman(darkSide, x, y++));
        case 2 -> darkSide.add(new Monk(darkSide, x, y++));
        default -> darkSide.add(new Xbowman(darkSide, x, y++));
      }
    }
  }
}
