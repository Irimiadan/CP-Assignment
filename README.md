# Lotto
When the game starts the game should generate 10 numbers between 1 and 99. For consistency if a single digit number is 
generated, it should be displayed with a zero to the left from the digit. For example, winning numbers may look like this:
23 09 43 78 12 35 38 04 28 88
The same number should not appear more than once.
The program should calculate the sum of the winning numbers and display it on the next line.


As a bonus game, the program should then display four prize sums, which the user can win in addition to the lottery 
winning. If the same sum appears more than once, the user wins that sum. The sums are: €10 (60% chance), €20(20% chance), 
€50(10% chance), €200(7.5% chance) and €1000(2.5% chance).


The user is then asked to enter 5 numbers one after another. If the user enters a number that he/she entered already, 
the program should ignore it and ask for the number again. The user is also asked to guess what the sum of all ten 
winning numbers will be.


There are 3 ways the user’s input is analysed in order to determine how much they won.
1.	The program checks how many numbers out of the winning 10 the user guessed correctly. One is €1000, two is €5000, 
three is €20,000, four is €100,000 and five is €700,000. The order is not important.

2.	The program checks if the user guessed any sequences. A sequence must include two or more numbers and must not have 
gaps. For example, if the program had the following winning numbers:
23 56 67 06 43 22 59 24 90 66 and user entered: 01 06 43 22 89
Then the user correctly guessed a three-number sequence. A two-number sequence wins €50,000, a three-number sequence is
€300,000, a four-number sequence is €800,000 and all five in the correct order is €3,000,000. If the user guessed 
multiple sequences, only the one with the highest winning counts.

3.	If the user correctly guessed the sum of all winning numbers, they win €300,000.

If the user won using more than one of the above methods, only the one with the highest prize sum will count. 
Anything won in the bonus game can be added to the lottery winnings. The game’s output should clearly describe how the 
total prize was calculated and which numbers won.
