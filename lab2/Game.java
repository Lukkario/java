class Game{
  public static void main(String[] args)
  {
    int userRange = 0;
    if(args.length != 1)
    {
      printUsage();
    }

    try
    {
      userRange = Integer.parseInt(args[0]);
    }
    catch (NumberFormatException e) {
      System.out.println("Error: Could not parse input "+e.getMessage()+" to integer.\n");
      System.exit(2);
    }

    Engine ourGame = new Engine(userRange);
    ourGame.startGame();
    return 0;


  }

  private static void printUsage()
  {
    System.out.println("Usage: ");
    System.exit(1);
  }

}
