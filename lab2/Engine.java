import java.util.Scanner;
import java.util.Random;

class Engine{

  private int maxRange;
  private int guessCounter;
  private int numberToBeGuessed;

  Engine(int init_max_range)
  {
    maxRange = init_max_range;
    guessCounter = 0;
  }

  public void startGame()
  {
    setNuberToGuess();
    Scanner userInput = new Scanner(System.in);
    play(userInput);
    while(ifResetGame(userInput))
    {
      restartGame(userInput);
    }
  }

  private void setNuberToGuess()
  {
    Random rand = new Random();
    numberToBeGuessed = rand.nextInt(maxRange+1);
    //System.out.println(numberToBeGuessed);
  }

  private void incrementGuessCounter()
  {
    guessCounter += 1;
  }

  private void resetCounter()
  {
    guessCounter = 0;
  }

  private void play(Scanner input)
  {
    System.out.println("Guess the number. Good luck! :)");
    System.out.print("> ");
    int guess = getUserNumber(input);
    while(guess != numberToBeGuessed)
    {
      if(guess < numberToBeGuessed)
      {
        System.out.println("The number is bigger.");
        incrementGuessCounter();
        System.out.print("> ");
        guess = getUserNumber(input);
      }
      else
      {
        System.out.println("The number is smaller.");
        incrementGuessCounter();
        System.out.print("> ");
        guess = getUserNumber(input);
      }
    }
    incrementGuessCounter();
    printSummary();
  }

  private int getUserNumber(Scanner input)
  {
    while(true)
    {
      try
      {
        return Integer.parseInt(input.nextLine());
      }
      catch (NumberFormatException e)
      {
        System.out.println("Error: Incorrect input "+e.getMessage());
      }
    }
  }

  private void printSummary()
  {
    System.out.print("Number "+numberToBeGuessed+" is correct. It took you "+guessCounter);
    if(guessCounter == 1)
    {
      System.out.println(" try.");
    }
    else
    {
      System.out.println(" tries.");
    }
  }

  private void restartGame(Scanner input)
  {
    setNuberToGuess();
    resetCounter();
    play(input);
  }

  private boolean ifResetGame(Scanner input)
  {
    System.out.print("Do you wish to play again? [Y/n] ");
    String choice = input.nextLine();
    while(!choice.equals("Y") && !choice.equals("y") && !choice.equals("") && !choice.equals("N") && !choice.equals("n"))
    {
      System.out.print("Do you wish to play again? [Y/n] ");
      choice = input.next();
    }
    if(choice.equals("N") || choice.equals("n"))
    {
      return false;
    }
    return true;
  }
}
