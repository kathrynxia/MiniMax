import java.io.*;
import java.util.*;

public class NimRunner{

  //will pass in a Node, not necesrry though

  // public int getX(Node root){
  //   return -1;
  // }

  // public int getY(Node root){
  //   return 1;
  // }

  public static int minimax(int numStones, boolean myTurn){
    if ((numStones <= 4)){
      if (myTurn){
        return 1;
      }
      else{
        return -1;
      }
    }


    else{

      ArrayList<Integer> myList = new ArrayList<Integer>();//make array list of three options, return the maximum or minimum based on whose turn

      for (int i = 1; i <= 3; i ++){ 
            
            myList.add(minimax(numStones - i, !(myTurn)));//save all three values, and depending on whether its myturn or your turn

      }

      if (myTurn){
        return Collections.min(myList);
      }

      else{

         return Collections.max(myList);

      }


    //   int count = 0;

    // for (int i = 0; i < numStones; i +=3){
    //   count = i;
    // }

    // return (miniMax(numStones-));//snooped the internet, should return a multiple of 4, 2, 1


  }

  }



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