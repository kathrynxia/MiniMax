import java.util.*;

public class RegNimRunner {

//   public static void runGame(int numPieces) {
//     boolean myTurn = true;

//     while (numPieces >= 0) {
//       if (numPieces == 0) {
//         if (myTurn) {
//           System.out.println("Player 1 wins!");
//         } else {
//           System.out.println("Player 2 wins!");
//         }

//         break;
//       }

//       display(numPieces, myTurn);
//       System.out.println("takes " + bestMove(numPieces, myTurn) + "\n");

//       numPieces = numPieces - bestMove(numPieces, myTurn);

//       myTurn = !(myTurn);
//     }
//   }

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

  public static int minimax(ArrayList<Integer> numPieces, boolean myTurn) {
    if (numPieces.equals(Arrays.asList(0, 0, 0, 0))){//check all are 0
      if (myTurn) {
        return 1;
      } else {
        return -1;
      }
    } else {
      //ArrayList<Integer> listOfScores = new ArrayList<>();

      for (int i = 0; i < numPieces.size(); i ++){
        for (int j = 1; j <= numPieces.get(i); j ++){

            ArrayList<Integer> possibleTake = new ArrayList<Integer>(numPieces);

            //rename to possibleState
            
            possibleTake.set(i, numPieces.get(i) - j);

          if (myTurn){
            if (minimax(possibleTake, !myTurn) == 1){

              
              return 1;
            }
            //return -1;
          }
          else{

            if (minimax(possibleTake, !myTurn) == -1){
              return -1;
            }
            //return 1;

          }
        }
      }

      if (myTurn){
        return -1;
      }

      else{
        return 1;
      }
    }

  }

//   public static int bestMove(int numPieces, boolean myTurn) {
//     for (int i = 1; i <= 3; i++) {
//       if ((numPieces - i) < 0) {
//         continue;
//       }

//       if (myTurn) {
//         if (minimax(numPieces - i, !myTurn) == 1) {
//           return i;
//         }
//       } else {
//         if (minimax(numPieces - i, myTurn) == 1) {
//           return i;
//         }
//       }
//     }
//     return 1;
//   }

//   public static void display(int numPieces, boolean myTurn) {
//     if (myTurn) {
//       System.out.println("Player 1's turn");
//     } else {
//       System.out.println("Player 2's turn");
//     }

//     for (int i = 0; i < numPieces; i++) {
//       System.out.println(" * ");
//     }
//   }
}
