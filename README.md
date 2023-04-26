# MiniMax


## Background and motivation. 


### Motivation: why did I create this code?
Well, it was a class assignment, so I had no choice. Just kidding! I wanted to challenge myself, as I haven’t done much recursion practice in the past year, and the last game I coded was over two years ago on JavaScript. I don’t think I’ve coded a game in Java before! I wanted to give this my all. 




### What is Nim? 
Nim is a two-player game, in which players alternate turns. It’s a zero-sum game, meaning that one player’s benefit is the other player's loss. This means that there can only be one winner, and every move a player makes is intended to benefit themselves and disadvantage the other. There are no ties. 


This code assumes the other player will maximize the chances of them winning. So basically, my code is playing a game against itself, if that makes sense. This makes it so that each turn consists of each player making the best possible choice. 


#### Simple Nim: 
You have one pile of pieces of any number. Each player can take 1 to 3 pieces. The player that takes the last piece loses, whether they take the last piece individually or the last piece as part of the entire group of pieces remaining. 


#### Regular Nim: 
Same concept as above! Except for some key changes:
1. instead of one pile, there are any number of piles.

2. Instead of only being able to take 1-3 pieces, you can take any number of pieces from one pile each turn. Meaning you could take 1 piece, or the entire pile in one turn. The only thing is, you have to take at least one piece, and however many pieces you take, they all have to be from the same pile. Whoever takes the last remaining piece loses the game. 


## Usage
To run this program, you need to know how to use the terminal. When the code is run, a scanner gets your input and uses that to run the game as you play against the Minimax algorithm, which will take any advantage it gets to win the game. No command line arguments are necessary, however, please run the Tests.java file to play the game. Other than that, no other fancy additions are needed. 


## Future directions
This code could be made more robust. I tried to account for errors in user input, but a player might be able to make invalid moves that are against the rules of the game. Otherwise, the display function could be tweaked to make it more visually appealing, showing individual pieces rather than just numbers. Lastly, the program could be made to be more efficient. Right now the code needs to test every single possibility, which is especially tedious the more pieces and piles there are. Perhaps implementing a more efficient algorithm could save time, and the code would not have to individually test every possibility, which could become thousands as the number of piles increases. 
