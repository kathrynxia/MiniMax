import java.io.*;
import java.util.*;

public class NimRunner {

  //will pass in a Node, not necesrry though

  // public int getX(Node root){
  //   return -1;
  //call get best move from these
  // }

  // public int getY(Node root){
  //   return 1;
  // }

  // public static void runGame(ArrayList<Integer> numStones) {
  //   boolean myTurn = true;

  //   while (
  //     !numStones.equals(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)))
  //   ) {
  //     display(numStones, myTurn);
  //     System.out.println("takes " + bestMove(numStones, myTurn) + "\n");

  //     numStones = numStones - bestMove(numStones, myTurn);

  //     myTurn = !(myTurn);
  //   }

  //   if (myTurn) {
  //     System.out.println("Player 1 wins!");
  //   } else {
  //     System.out.println("Player 2 wins!");
  //   }
  //   // if (myTurn) {
  //   //   System.out.println("Player 1 wins!");
  //   // } else {
  //   //   System.out.println("Player 2 wins!");
  //   // }
  // }

  public static int minimax(List<Integer> numStones, boolean myTurn) {
    if (numStones.equals(new ArrayList<Integer>(Arrays.asList(0, 0, 0, 0)))) {
      if (!myTurn) {
        // System.out.println("should end");
        return -1;
      } else {
        // System.out.println("should end");
        return 1;
      }
    }
    //change minimax parameter, arraylist of multiple piles
    //possible moves, more, based on number in each pile, nested for loop, arraylist of children

    else {
      for (int i = 0; i < numStones.size(); i++) {
        for (int j = 0; j < numStones.get(i); j++) { //maybe flip to decrement
          if ((numStones.get(i) - j) < 0) {
            continue;
          }

          if (myTurn) {
            //if ((((new ArrayList<Integer>(numStones)).set(i, numStones.get(i) - j)), myTurn) == 1)
              

              
              //minimax(((new ArrayList<Integer>(numStones))).set(i, numStones.get(i) - j)), myTurn) == 1)
             return 1; //make copy of arraylist? with subtracted #?
          }
          //(minimax( numStones.clone().set(i, numStones.get(i) - j), myTurn   ) == 1)

          else if (
            //minimax((ArrayList)numStones.clone().set(i, numStones.get(i) - j), myTurn) ==
            //-1
          ) {
            return 1;
          } else {
            return -1;
          }
        }
      }
      // for (int i = 3; i >= 1; i--) {

      //   if ((numStones - i) < 0){
      //   continue;
      //   }

      //   if (myTurn) {
      //     if (minimax(numStones - i, !(myTurn)) == 1){ //save all three values, and depending on whether its myturn or your turn
      //     //if the opposite move is would be bad for me if i were in that posuition
      //     //return minimax(numStones - i, (myTurn));
      //     return 1;
      //     //break;
      //     }
      //   } else {
      //     if (minimax(numStones - i, !(myTurn)) == 1){ //save all three values, and depending on whether its myturn or your turn
      //     //if the opposite move would be bad for my opponent
      //     //return minimax(numStones - i, !(myTurn));
      //     return -1;
      //     //break;
      //     }
      //   }
      // }

      //return minimax(numStones - 1, !(myTurn));

      //   int count = 0;

      // for (int i = 0; i < numStones; i +=3){
      //   count = i;
      // }

      // return (miniMax(numStones-count));//snooped the internet, should return a multiple of 4, 2, 1

    }
    //return 0;

  }

  // public static int bestMove(int numStones, boolean myTurn) {
  //   for (int i = 3; i >= 1; i--) {

  //     if ((numStones - i) < 0){
  //       continue;
  //     }

  //     // if((numStones-i) < 0){
  //     //   continue;
  //     // }
  //     //if (myTurn) {
  //       if (minimax(numStones - i, !myTurn) == -1) {
  //         return i;
  //     //  }
  //     }
  //     // else {
  //     //   if (minimax(numStones - i, !myTurn) == 1) {
  //     //     return i;
  //     //   }
  //     // }

  //   }

  //   return -1;
  /*

    return number of pieces you want to take

    figuer out what next state would be
    call minimas on next state, if resulting score is positive, break
    if never break, just return a random number
works for maximizing player, to change just look for -1
    */

  //}

  public static void display(List<Integer> numStones, boolean myTurn) {
    if (myTurn) {
      System.out.println("Player 1's turn");
    } else {
      System.out.println("Player 2's turn");
    }

    for (int i = 0; i < numStones.size(); i++) {
      for (int j = 0; j < numStones.get(i); j++) {
        System.out.print("* ");
      }
      System.out.println();
      System.out.println();
    }
  }
  //public static void

  /*

run game returns boolean



get X move --> int
get y move --> int
display method (state of game)

pretend x is player 1

1. hard code valid moves for now (only three)
2. hard code winning points
3. use algorithm, and do subtraction to to get winning points
 - find points where the cumputer can get into "winning position" aka put othewr player into losiugn positiojn
  - hard code these states into the computer



*/
}
