import java.util.*;

public class RegNimRunner {

  public static void runGame() {
    boolean myTurn = true;

    ArrayList<Integer> board = new ArrayList<>(generateRandomBoard()); //generates a random board

    ArrayList<Integer> baseCase = new ArrayList<>(); //when all piles of this random board = 0

    System.out.println("starting");

    System.out.println(board); //print starting board

    for (int k = 0; k < board.size(); k++) {
      baseCase.add(0);
    }

    while (!board.equals(baseCase)) { //while there are still pieces left
      if (myTurn) {
        board = getPlayerXMove(board); //player X goes first
      } else {
        board = getPlayerYMove(board); //player y second
      }

      display(board, myTurn); //dispay after move is bade

      myTurn = !(myTurn); //switch turns

      System.out.println();
    }

    if (myTurn) { //winning conditions
      System.out.println("Player X wins!");
    } else {
      System.out.println("Player Y wins!");
    }
  }

  public static ArrayList<Integer> getPlayerXMove(ArrayList<Integer> piles) { //arraylist
    return bestMove(piles, true); //player X is machine, will calculate best possible move using minimax
  }

  public static ArrayList<Integer> generateRandomBoard() { //generates a random "board" with random piless
    ArrayList<Integer> board = new ArrayList<>();

    for (int i = 0; i < (int) (Math.random() * 10) + 1; i++) { //generates a board between with 1 to 10 piles
      board.add((int) (Math.random() * 11)); //random number of pieces, 0 to 10 per pile
    }

    return board;
  }

  public static ArrayList<Integer> getPlayerYMove(ArrayList<Integer> piles) { //tried making it as robust as possible, pls assume valid input
    int pile = 0;

    int taken = 0;

    ArrayList<Integer> possibleState = new ArrayList<>(piles); //copy of  current state

    boolean validMove = false;

    while (!validMove) {
      Scanner key = new Scanner(System.in); //getting user input for the pile they want to take frum and the number of pirces they want to take

      System.out.println("choose a pile");

      pile = key.nextInt();

      System.out.println("how many do you want to take");

      taken = key.nextInt();

      if ((pile >= 0) && (pile < piles.size())) { //valid pile
        if ((piles.get(pile) - taken) >= 0) { //valid number of pieces taken
          if (taken != 0) { //can't choose to take no pieces
            validMove = true;
          }
        }
      }
    }

    possibleState.set(pile, piles.get(pile) - taken); //change the state

    return possibleState; //return the new states
  }

  public static int minimax(ArrayList<Integer> piles, boolean myTurn) {
    ArrayList<Integer> baseCase = new ArrayList<>(); //base case, all 0 pieces in each pile

    for (int k = 0; k < piles.size(); k++) {
      baseCase.add(0);
    }

    if (piles.equals(baseCase)) { //check all are 0
      if (myTurn) {
        return 1;
      } else {
        return -1;
      }
    } else {
      for (int i = 0; i < piles.size(); i++) { //going through all possible moves
        for (int j = 0; j <= piles.get(i) - 1; j++) {
          ArrayList<Integer> state = new ArrayList<Integer>(piles); //make copy of piles

          state.set(i, j); //possible state

          if (myTurn) {
            if (minimax(state, !myTurn) == 1) { //if its a good move, return 1 for player x
              return 1;
            }
          } else {
            if (minimax(state, !myTurn) == -1) { //if its a good bove, return -1 for player y
              return -1;
            }
          }
        }
      }
      //no "max" or "mini" found, all moves are not beneficial
      if (myTurn) {
        return -1;
      } else {
        return 1;
      }
    }
  }

  public static ArrayList<Integer> bestMove(
    ArrayList<Integer> piles,
    boolean myTurn
  ) { //finds the best possible move
    for (int i = 0; i < piles.size(); i++) {
      if (piles.get(i) == 0) { //can't take pieces from an empty pile
        continue;
      }

      for (int j = 1; j <= piles.get(i); j++) { //number of pieces left in pile
        ArrayList<Integer> state = new ArrayList<Integer>(piles);
        state.set(i, piles.get(i) - j); //teting all possible moves

        if (myTurn) {
          if (minimax(state, !myTurn) == 1) { //good move for X , return the arraylist after pieces have been removed
            return state;
          }
        } else {
          if (minimax(state, !myTurn) == -1) { //good move for Y, return the arraylist after pieces
            return state;
          }
        }
      }
    }

    //if no beneficial moves have been found, find the first pile where there are NOT 0 pieces, and just take one piece from that pile

    ArrayList<Integer> state = new ArrayList<Integer>(piles);

    int count = 0;

    for (int i = 0; i < piles.size(); i++) {
      if (piles.get(i) > 0) {
        count = i;
        break;
      }
    }

    state.set(count, piles.get(count) - 1);
    return state;
  }

  public static void display(ArrayList<Integer> numPieces, boolean myTurn) { //for aethetic purposes
    if (myTurn) {
      System.out.println("Player X's turn");
    } else {
      System.out.println("Player Y's turn");
    }

    System.out.println();

    System.out.print("Nums: ");

    for (int i = 0; i < numPieces.size(); i++) { //displaying number of pieces in each pile
      System.out.print(" " + numPieces.get(i) + " ");
    }

    System.out.print(" \nPile: "); //displaying which number pile it is, Ex. pile, #0, pile #1, etc

    for (int i = 0; i < numPieces.size(); i++) {
      System.out.print(" " + i + " ");
    }

    System.out.println();
  }
}
