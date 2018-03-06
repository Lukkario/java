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
    int guess = getUserNumber(input);
    while(guess != numberToBeGuessed)
    {
      if(guess < numberToBeGuessed)
      {
        System.out.println("The number is bigger.");
        incrementGuessCounter();
        guess = getUserNumber(input);
      }
      else
      {
        System.out.println("The number is smaller.");
        incrementGuessCounter();
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
    System.out.println("Nubmer "+numberToBeGuessed+" is correct. It took you "+guessCounter+" tries.");
    System.out.print("Do you wish to play again? [Y/n] ");
  }

  public void restartGame(Scanner input)
  {
    setNuberToGuess();
    resetCounter();
    play(input);
  }


  private boolean ifResetGame(Scanner input)
  {
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
