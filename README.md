# Java-Game-Files

This repository contains a Java Maze game which I programmed. The Maze.Java class wass supplied by Microsoft in an online course I took over Java Object-Oriented programming. I implemented the MazeRunner.Java class using the methods and attributes defined in the Maze.Java class. 

The Maze game follows a principle similar to Snakes in Ladders, in that the user is given a starting position on a board which is printed off incrementally throughout the game. The user must enter in a direction in which they want to move their character on the board until they reach a position which is the "winning" position they must travel to win the game. 

A few constraints on the game to make it more interesting are that the user only has 100 turns to find the hidden spot on the board. Also, the user can unexpectedly run into hidden walls on the board, which essentially waste a turn. 


The Java battleship program in this repository is a game project I developed in my free time. This project follows traditional Battleship rules, in which both the user and computer are allowed to place 5 ships on the board. The actual placement of the ships consists of the user entering a y and x coordinate for each of their 5 ships. Once the user is finished, the board is displayed. The computer will then randomly choose 5 x and y coordinate pairs to place their ships.

I used a 2-d array to construct the game board in this project. The array was globally declared and managed throughout the game as both the user and computer took turns firing at spots on the board.

One feature which I want to add in the future is for the program to give the user an option if they want to play a 2 player game instead of defaulting the game to a user vs computer setting. Also, implementing a feature into the game in which the computer doesn't hit their ow ships would make the game more interesting.
