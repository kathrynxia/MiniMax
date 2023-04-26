import java.util.*;

public class NimRunnerV2 {

  public static void runGame(int numPieces) {
    boolean myTurn = true;

    while (numPieces >= 0) {
      if (numPieces == 0) {
        if (myTurn) {
          System.out.println("Player 1 wins!");
        } else {
          System.out.println("Player 2 wins!");
        }

        break;
      }

      display(numPieces, myTurn);
      System.out.println("takes " + bestMove(numPieces, myTurn) + "\n");

      numPieces = numPieces - bestMove(numPieces, myTurn);

      myTurn = !(myTurn);
    }
  }

  // public static int getPlayerXMove(numPieces){//arraylist

  //USE A DO WHILE LOOP

  //     return bestMove(int numPieces, boolean true);

  // }

  // public static getPlayerYMove(numPieces){

  //     while ((pile) >= )

  //     Scanner key = new Scanner(System.in);

  //     System.out.println("choose a pile");

  //     int pile = key.nextInt();

  //     System.out.println("how many do you want to take");

  //     int taken = key.nextInt();

  // }

  public static int minimax(int numPieces, boolean myTurn) {
    if (numPieces == 0) {
      if (myTurn) {
        return 1;
      } else {
        return -1;
      }
    } else {
      ArrayList<Integer> listOfScores = new ArrayList<>();

      for (int i = 1; i <= 3; i++) {
        if ((numPieces - i) < 0) {
          continue;
        }

        listOfScores.add(minimax(numPieces - i, !myTurn));
      }

      if (myTurn) {
        return Collections.max(listOfScores);
      } else {
        return Collections.min(listOfScores);
      }
    }
  }

  public static int bestMove(int numPieces, boolean myTurn) {
    for (int i = 1; i <= 3; i++) {
      if ((numPieces - i) < 0) {
        continue;
      }

      if (myTurn) {
        if (minimax(numPieces - i, !myTurn) == 1) {
          return i;
        }
      } else {
        if (minimax(numPieces - i, myTurn) == 1) {//might change this****
          return i;
        }
      }
    }
    return 1;
  }

  public static void display(int numPieces, boolean myTurn) {
    if (myTurn) {
      System.out.println("Player 1's turn");
    } else {
      System.out.println("Player 2's turn");
    }

    for (int i = 0; i < numPieces; i++) {
      System.out.println(" * ");
    }
  }
}
