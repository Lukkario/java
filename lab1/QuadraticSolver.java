public class QuadraticSolver{
  private static void printUsage()
  {
    System.out.println("This program sloves quadratic equation.");
    System.out.println("Usage: java QuadraticSolver <a> <b> <c>");
    System.out.println("\ta - (double) - a part of equation");
    System.out.println("\tb - (double) - b part of equation");
    System.out.println("\tc - (double) - c part of equation");
  }

  public static void main (String[] args)
  {
    double a = 0.0;
    double b = 0.0;
    double c = 0.0;
    QuadraticEquation eq;
    if(args.length != 3)
    {
      printUsage();
      System.exit(1);
    }

    try{
      a = Double.parseDouble(args[0].replace(",","."));
      b = Double.parseDouble(args[1].replace(",","."));
      c = Double.parseDouble(args[2].replace(",","."));
    }
    catch (NumberFormatException e) {
      System.out.println("Error: Could not parse input "+e.getMessage()+" to double.\n");
      System.exit(2);
    }

    if(a == 0)
    {
      System.out.println("This is not a quadratic equation.");
      System.exit(3);
    }

    eq = new QuadraticEquation(a,b,c);
    eq.solve();
    eq.printResult();

    System.exit(0);
  }


}
