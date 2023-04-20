import java.io.*;
import java.util.*;

public class NimRunner{

  //will pass in a Node, not necesrry though

  public int getX(Node root){
    return -1;
  }

  public int getY(Node root){
    return 1;
  }

  public static boolean minimax(int numStones, boolean myTurn){
    if ((n == 0) && (myTurn == true)){
      return true;
    }

    else if ((n == 1) && (myTurn == false)){
      return false;
    }

    else{
      return (miniMax());//snooped the internet, should return a multiple of 4, 2, 1
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