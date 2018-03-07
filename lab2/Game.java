import java.util.Scanner;

class Game{
  public static void main(String[] args)
  {
    int userRange = 0;
    if(args.length != 1)
    {
      printUsage();
      System.exit(1);
    }

    try
    {
      userRange = Integer.parseInt(args[0]);
    }
    catch (NumberFormatException e) {
      System.out.println("Error: Could not parse input "+e.getMessage()+" to integer.\n");
      System.exit(2);
    }

    if(userRange <= 0)
    {
      System.out.println("Error: N must be greater than 0");
      printUsage();
      System.exit(1);
    }

    Engine ourGame = new Engine(userRange);
    ourGame.startGame();
    Scanner in = new Scanner(System.in);
    System.exit(0);
  }

  private static void printUsage()
  {
    System.out.println("Simple number guessing game from 0 to N.");
    System.out.println("Usage: java Game <N>");
    System.out.println("\tN - (int) - upper range.");
  }

}
