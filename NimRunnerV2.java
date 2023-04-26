import java.util.*;

public class NimRunnerV2 {

  public static void runGame(int numPieces) {
    boolean myTurn = true;//"player x" starts first

    while (numPieces >= 0) {//while there are still pieces
      if (numPieces == 0) {//winning conditions, 
        if (myTurn) {//if its my turn and 0 pieces left
          System.out.println("Player 1 wins!");
        } else {
          System.out.println("Player 2 wins!");
        }

        break;
      }

      display(numPieces, myTurn);//display how many pieces there are

      if (myTurn){
      System.out.println("takes " + getPlayerXMove(numPieces) + "\n");//get the move for player X
      }

      else{

        System.out.println("takes " + getPlayerYMove(numPieces) + "\n");//get move for player Y

      }

      numPieces = numPieces - bestMove(numPieces, myTurn);//take the best move from the pile

      myTurn = !(myTurn);//switch turns
    }
  }

  public static int getPlayerXMove(int numPieces){//arraylist

      return bestMove(numPieces, true);//true bc player X is going first

  }

  public static int getPlayerYMove(int numPieces){//arraylist

      return bestMove(numPieces, false);//false bc player Y goes second

  }


  public static int minimax(int numPieces, boolean myTurn) {
    if (numPieces == 0) {//if there are 0 pieces left
      if (myTurn) {
        return 1;// win
      } else {
        return -1;// lose
      }
    } else {
      ArrayList<Integer> listOfScores = new ArrayList<>();//make arraylist of scores

      for (int i = 1; i <= 3; i++) {
        if ((numPieces - i) < 0) {//invalid move
          continue;
        }

        listOfScores.add(minimax(numPieces - i, !myTurn));//add different possible states of game to arraylist
      }

      if (myTurn) {
        return Collections.max(listOfScores);//return "max" if player x, that's the best possible move
      } else {
        return Collections.min(listOfScores);//return "min" if player Y, that's the best possible move
      }
    }
  }

  public static int bestMove(int numPieces, boolean myTurn) {
    for (int i = 1; i <= 3; i++) {
      if ((numPieces - i) < 0) {//invalid move
        continue;
      }

      if (myTurn) {
        if (minimax(numPieces - i, !myTurn) == 1) {//if the number of pirces taken results in a beneficial state for player x
          return i;
        }
      } else {
        if (minimax(numPieces - i, myTurn) == 1) {//if the number of pieces taken results in a beneficial state for player y
          return i;
        }
      }
    }
    return 1;//nothing was beneficial, just take 1
  }

  public static void display(int numPieces, boolean myTurn) {//for aesthetic purposes, prints out asterics for pieces
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
