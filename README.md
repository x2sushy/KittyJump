KittyJump

KittyJump is an endless 2D platformer inspired by the legendary game Doodle Jump. The player controls an orange pixel art cat, aiming to jump as high as possible on randomly generated platforms without falling off the bottom of the screen.

The game is built in Java using the Swing library for the graphical user interface. The project demonstrates the practical application of object-oriented programming (OOP), a game loop, and basic 2D physics.

Features

Endless Game World: The level dynamically scrolls downwards, and old platforms are replaced by new ones.

Screen Wrap: If the cat jumps off the left edge of the screen, it appears on the right edge.

Various Platform Types:

Basic: A classic solid platform.

Fragile: Breaks immediately after the first bounce.

Moving: Moves horizontally, bouncing off the walls.

Power-Ups: A spring that launches the cat to three times its normal jump height.

Custom Graphics: Original pixel art.

User Interface: Score tracking system, fully functional main menu, and a Game Over screen.

Technologies Used

Language: Java

Graphics and UI: Java Swing / AWT (JFrame, JPanel, Graphics, BoxLayout)

Architecture: Object-Oriented Programming (OOP) – separated into modules for game logic, entities, and UI.

Controls
Left Arrow: Move left

Right Arrow: Move right

(The cat jumps automatically upon landing on a platform)

How to Run

Make sure you have the Java Development Kit (JDK) installed.

Download or clone this repository.

The res/ folder containing the graphics (background image, platforms, cat sprite) must be located in the root directory where the program is executed.

Open the project in any IDE (IntelliJ IDEA) and run the main class.