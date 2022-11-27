import chars.Vector2;
import java.util.Collections;

public class ConsoleView {

  private static int step = 1;
  private static int copy = Game.GANG_SIZE - 1;
  private static final String top10 =
    formatDiv("a") +
    String.join("", Collections.nCopies(copy, formatDiv("-b"))) +
    formatDiv("-c");
  private static final String mid10 =
    formatDiv("d") +
    String.join("", Collections.nCopies(copy, formatDiv("-e"))) +
    formatDiv("-f");
  private static final String bottom10 =
    formatDiv("g") +
    String.join("", Collections.nCopies(copy, formatDiv("-h"))) +
    formatDiv("-i");

  public static void view() {
    if (step == 1) {
      System.out.println(
        AnsiColors.ANSI_RED + "First step." + AnsiColors.ANSI_RESET
      );
    } else {
      System.out.println(
        AnsiColors.ANSI_RED + "Step " + step + ". " + AnsiColors.ANSI_RESET
      );
    }
    step++;
    System.out.println(top10);
    for (int i = 1; i <= Game.GANG_SIZE - 1; i++) {
      for (int j = 1; j <= Game.GANG_SIZE; j++) {
        System.out.print(getChar(new Vector2(j, i)));
      }
      System.out.println(
        "| " +
        AnsiColors.ANSI_GREEN +
        Game.whiteSide.get(i - 1).getInfo() +
        AnsiColors.ANSI_RESET +
        "  " +
        AnsiColors.ANSI_RED +
        Game.darkSide.get(i - 1).getInfo() +
        AnsiColors.ANSI_RESET
      );
      System.out.println(ConsoleView.mid10);
    }
    for (int j = 1; j <= Game.GANG_SIZE; j++) {
      System.out.print(getChar(new Vector2(j, Game.GANG_SIZE)));
    }
    System.out.println("|");

    System.out.println(
      ConsoleView.bottom10 +
      AnsiColors.ANSI_GREEN +
      Game.whiteSide.get(copy).getInfo() +
      AnsiColors.ANSI_RESET +"  " + AnsiColors.ANSI_RED +
      Game.darkSide.get(copy).getInfo() +
      AnsiColors.ANSI_RESET
    );
    System.out.println("Press Enter.");
  }

  private static String formatDiv(String str) {
    return str
      .replace('a', '\u250c')
      .replace('b', '\u252c')
      .replace('c', '\u2510')
      .replace('d', '\u251c')
      .replace('e', '\u253c')
      .replace('f', '\u2524')
      .replace('g', '\u2514')
      .replace('h', '\u2534')
      .replace('i', '\u2518')
      .replace('-', '\u2500')
      .replace("S", "...")
      .replace("O", "---");
  }

  private static String getChar(Vector2 position) {
    String str = "| ";
    String info = "";
    for (int i = 0; i < Game.GANG_SIZE; i++) {
      if (Game.darkSide.get(i).getPosition().isEquals(position)) str =
        "|" +
        AnsiColors.ANSI_BLUE +
        Game.darkSide.get(i).getName().charAt(0) +
        AnsiColors.ANSI_RESET;

      if (Game.whiteSide.get(i).getPosition().isEquals(position)) str =
        "|" +
        AnsiColors.ANSI_GREEN +
        Game.whiteSide.get(i).getName().charAt(0) +
        AnsiColors.ANSI_RESET;
    }
    return str;
  }
}
