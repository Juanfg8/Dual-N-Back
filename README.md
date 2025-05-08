Dual-N-Back Game

Dual-N-Back is an educational game developed in Java, based on the concept of **N-Back** memory training. The goal is to test and improve players' working memory by challenging them to identify when a stimulus appears in the same position as **n** rounds ago.

The game helps develop cognitive ability, increasing short-term memory and concentration through progressive challenges.

Main features

Adjustable game mode - Choose the difficulty level and define how many previous rounds should be remembered
Performance log - Track your progress with statistics on hits and errors
Scoring system - Score points for correct answers and see your evolution over time
Intuitive interface - Developed with Swing, providing a simple and functional design
Support for different speeds - Adjust the game speed to make the challenge more intense

Technologies used

Java (JDK 17+) - Programming language used for the game's logic and operation
Swing - Graphic library for creating the interface
Git - Project version control
JUnit - Automated tests to ensure system stability

How to install and run

Clone the repository
git clone <REPOSITORY_URL>
cd Dual-N-Back

Compile the project
javac -d bin src/*.java

Create the JAR to run
jar cvfm NBack.jar MANIFEST.MF -C bin .

Run the game
java -jar NBack.jar

How to play

Observe the position of the blue ball on the screen
Press ✔️ if the position is the same as n rounds ago
Keep playing and see how long your memory lasts

How to contribute

Contributions are welcome to improve the game and expand its features. If you want to contribute

Fork the repository
Create a new branch for your changes
git checkout -b my-improvement

Make the changes and commit
git add .
git commit -m "Improvement adding new feature"

Submit your code for review
git push origin my-improvement

Open a pull request on GitHub
