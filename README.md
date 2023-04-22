# MiniMax

## Background and motivation. 

### Motivation: why did I create this code?
Well, it was a class assignment, so I had no choice. Just kidding! I wanted to challenge myself, as I haven’t done much recursion practice in the past year, and the last game I coded was over two years ago on JavaScript. I don’t think I’ve coded a game in Java before! I wanted to give this my all. 


### What is Nim? 
Nim is a two-player game, in which players alternate turns. It’s a zero-sum game, meaning that one player’s benefit is the other player's loss. This means that there can only be one winner, and every move a player makes is intended to benefit themselves and disadvantage the other. There are no ties. 

#### Simple Nim: 
You have one pile of pieces of any number. Each player can take 1 to 3 pieces. The player that takes the last piece loses, whether they take the last piece individually or the last piece as part of the entire group of pieces remaining. 

#### Regular Nim: 
same concept as above! Except for some key changes:
instead of one pile, there are four piles, with 1, 3, 5, and 7 pieces each respectively
instead of only being able to take 1-3 pieces, you can take any number of pieces from one pile each turn. Meaning you could take 1 piece, or the entire pile in one turn. The only thing is, you have to take at least one piece, and however many pieces you take, they all have to be from the same pile. Whoever takes the last remaining piece loses the game. 
