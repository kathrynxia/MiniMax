import java.util.*;

public class RegNimRunner {

  public static void runGame() {
    boolean myTurn = true;

    ArrayList<Integer> board = new ArrayList<>(generateRandomBoard());

    ArrayList<Integer> baseCase = new ArrayList<>();

    System.out.println("starting");

    System.out.println(board);

    for (int k = 0; k < board.size(); k++) {
      baseCase.add(0);
    }

    while (!board.equals(baseCase)) {
      if (myTurn) {
        board = getPlayerXMove(board);
      } else {
        board = getPlayerYMove(board);
      }

      display(board, myTurn);

      myTurn = !(myTurn);

      System.out.println();
    }

    if (myTurn) {
      System.out.println("Player X wins!");
    } else {
      System.out.println("Player Y wins!");
    }
  }

  public static ArrayList<Integer> getPlayerXMove(ArrayList<Integer> piles) { //arraylist
    return bestMove(piles, true);
  }

  //generate a random board

  public static ArrayList<Integer> generateRandomBoard() {
    ArrayList<Integer> board = new ArrayList<>();

    for (int i = 0; i < (int) (Math.random() * 10) + 1; i++) {
      board.add((int) (Math.random() * 11));
    }

    return board;
    //generate random # 1-10 for piles
    //generate random numbers 0-10 for pieces in piles
    //return the arrayList

  }

  public static ArrayList<Integer> getPlayerYMove(ArrayList<Integer> piles) { //tried making it as robust as possible, pls assume valid input
    int pile = 0;

    int taken = 0;

    ArrayList<Integer> possibleState = new ArrayList<>(piles);

    //do{

    boolean validMove = false;

    while (!validMove) {
      Scanner key = new Scanner(System.in);

      System.out.println("choose a pile");

      pile = key.nextInt();

      System.out.println("how many do you want to take");

      taken = key.nextInt();

      if ((pile >= 0) && (pile < piles.size())) {
        if ((piles.get(pile) - taken) >= 0) {
          if (taken != 0) {
            validMove = true;
          }
        }
      }
    }

    possibleState.set(pile, piles.get(pile) - taken);

    return possibleState;
  }

  public static int minimax(ArrayList<Integer> piles, boolean myTurn) {
    ArrayList<Integer> baseCase = new ArrayList<>();

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
      for (int i = 0; i < piles.size(); i++) {
        for (int j = 0; j <= piles.get(i) - 1; j++) {
          ArrayList<Integer> state = new ArrayList<Integer>(piles);

          state.set(i, j);

          if (myTurn) {
            if (minimax(state, !myTurn) == 1) {
              return 1;
            }
            //return -1;
          } else {
            if (minimax(state, !myTurn) == -1) {
              return -1;
            }
            //return 1;

          }
        }
      }

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
  ) {
    for (int i = 0; i < piles.size(); i++) {
      if (piles.get(i) == 0) {
        continue;
      }

      for (int j = 1; j <= piles.get(i); j++) { //number of pieces left in pile
        ArrayList<Integer> state = new ArrayList<Integer>(piles);
        state.set(i, piles.get(i) - j);

        //System.out.println(state);

        if (myTurn) {
          if (minimax(state, !myTurn) == 1) {
            return state;
          }
        } else {
          if (minimax(state, !myTurn) == -1) {
            return state;
          }
        }
      }
    }

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

  public static void display(ArrayList<Integer> numPieces, boolean myTurn) {
    if (myTurn) {
      System.out.println("Player X's turn");
    } else {
      System.out.println("Player Y's turn");
    }

    System.out.println();

    System.out.print("Nums: ");

    for (int i = 0; i < numPieces.size(); i++) {
      System.out.print(" " + numPieces.get(i) + " ");
    }

    System.out.print(" \nPile: ");

    for (int i = 0; i < numPieces.size(); i++) {
      System.out.print(" " + i + " ");
    }

    System.out.println();
  }
}
