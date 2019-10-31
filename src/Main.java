import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] randomNumbersArray = new int[10];
        Random random = new Random();
        Scanner scan = new Scanner(System.in);
//Define rndNumbersArray as a new integer with the length of 10
//define random as a new random and scan as a new scanner

        for (int i = 0; i < randomNumbersArray.length; i++) {
            randomNumbersArray[i] = random.nextInt(98) + 1;
            boolean duplicate = true;
//run a loop for every randomNumbersArray position for which we generate a random int of 98 numbers and we add 1 to get
// numbers in rang of 1 to 99 and set duplicate to true so the while argument can run
            while (duplicate) {
                duplicate = false;
//As soon as we start the while duplicate is true argument we set duplicate to false so we can get out of while if
//we dont have a duplicate
                for (int j = 0; j < i; j++) {
                    if (randomNumbersArray[i] == randomNumbersArray[j]) {
                        duplicate = true;
                        break;
//loop the generated number against the numbers stored in the array if the values are equal set duplicate to true
//(so we stay inside the while argument) and break the loop
                    }
                }
                if (duplicate) {
                    randomNumbersArray[i] = random.nextInt(98) + 1;
//if duplicate is true we generate another random number.
                }
            }
        }
        int randomSum = 0;
        for (int i = 0; i < 10; i++) {
            randomSum = randomSum + randomNumbersArray[i];
//calculate the randomSum of the random generated numbers by adding each element in the randomNumbersArray to (randomSum).
            if (randomNumbersArray[i] < 10) {
                System.out.print("0" + randomNumbersArray[i] + " ");
//if the element is lower than 10, we add a padded 0 to it.
            } else {
                System.out.print(randomNumbersArray[i] + " ");
//otherwise we just print the number
            }
        }
//System.out.println(Arrays.toString(randomNumbersArray));
        System.out.println();
        System.out.println("\n The sum of all the random drawn numbers is " + randomSum);
//Print the randomSum of all elements.
// Calculate bonus random €10 (60% chance), €20(20% chance), €50(10% chance), €200(7.5% chance) and €1000(2.5% chance).
        int[] bonusPrize = {0, 0, 0, 0, 0}; // Create array for the 5 possible wins
        double randomBonus;
        System.out.println("\nNow I will show you four cards if two of them are the same, you won the money shown \n");
//Starting to loop 4 times to calculate the bonus win.
        for (int i = 0; i < 4; i++) {
            randomBonus = random.nextInt(9999) + 1;
            randomBonus = randomBonus / 100;
//Generated an integer from 1 to 10000 and we divide it by 100 to obtain a double from 1 to 100
            if (randomBonus > 0 & randomBonus <= 2.5) {
                bonusPrize[0] = bonusPrize[0] + 1;
                System.out.print("\t" + "€1000  |");
// 2.5% (2.5-0) chance to obtain bonusPrize 0. If obtained, add 1 to position 0 in the bonusPrize array.
            } else if (randomBonus > 2.5 & randomBonus <= 10) {
                bonusPrize[1] = bonusPrize[1] + 1;
                System.out.print("\t" + "€200   |");
// 7.5% (10-2.5) chance to obtain bonusPrize 1. If obtained, add 1 to position 0 in the bonusPrize array.
            } else if (randomBonus > 10 & randomBonus <= 20) {
                bonusPrize[2] = bonusPrize[2] + 1;
                System.out.print("\t" + "€50    |");
// 10% (20-10) chance to obtain bonusPrize 2. If obtained, add 1 to position 2 in the bonusPrize array.
            } else if (randomBonus > 20 & randomBonus <= 40) {
                bonusPrize[3] = bonusPrize[3] + 1;
                System.out.print("\t" + "€20    |");
// 20% (40-20) chance to obtain bonusPrize 1. If obtained, add 1 to position 3 in the bonusPrize array.
            } else if (randomBonus > 40 & randomBonus <= 100) {
                bonusPrize[4] = bonusPrize[4] + 1;
                System.out.print("\t" + "€10    |");
// 60% (100-40) chance to obtain bonusPrize 1. If obtained, add 1 to position 4 in the bonusPrize array.
            }
        }
        System.out.println("\n");
        int moneyBonus = 0;
//Define integer moneyBonus as a container for the total money won
        for (int i = 0; i < bonusPrize.length; i++) {
//Run a loop through bonusPrize array positions.
            if (bonusPrize[i] >= 2) {
                switch (i) {
                    case 0:
                        System.out.println("\n            *** Congratulations you won the 1000E bonus ! ***");
                        moneyBonus = moneyBonus + 1000;
                        break;
                    case 1:
                        System.out.println("\n             *** Congratulations you won the 200E bonus ! ***");
                        moneyBonus = moneyBonus + 200;
                        break;
                    case 2:
                        System.out.println("\n             *** Congratulations you won the 50E bonus ! ***");
                        moneyBonus = moneyBonus + 50;
                        break;
                    case 3:
                        System.out.println("\n             *** Congratulations you won the 20E bonus ! ***");
                        moneyBonus = moneyBonus + 20;
                        break;
                    case 4:
                        System.out.println("\n             *** Congratulations you won the 10E bonus ! ***");
                        moneyBonus = moneyBonus + 10;
                        break;
//Use a switch case for all the positions(i) in the array bonusPrize array if in any (i)case the value is > 2 then print
// "congrats and the randomSum won" then add the amount to moneyBonus
                }
            }
        }
        System.out.println("\n Please enter 5 numbers between 1 and 99. Please do not repeat them ");

        int[] userNumbersArray = new int[5];
        for (int i = 0; i < userNumbersArray.length; i++) {
            userNumbersArray[i] = scan.nextInt();
            boolean notValid = true;
            while (notValid) {
                notValid = false;
                for (int j = 0; j < i; j++) {
                    if (userNumbersArray[i] == userNumbersArray[j]) {
                        notValid = true;
                        System.out.println("Please don't repeat yourself");
                        System.out.println("Enter another number please");
                        break;
                    } else if (userNumbersArray[i] < 0) {
                        notValid = true;
                        System.out.println("It has to be bigger than 0");
                        System.out.println("Enter another number please");
                        break;
                    } else if (userNumbersArray[i] > 99) {
                        notValid = true;
                        System.out.println("It has to be smaller than 100");
                        System.out.println("Enter another number please");
                        break;
                    }
                }
                if (notValid) {
                    userNumbersArray[i] = scan.nextInt();
                }
            }
        }
        int moneySum = 0;
        System.out.println("Good Job ! Now please enter what you believe is the sum of all the winning numbers");
        int userSum = scan.nextInt();
        System.out.println("\nGreat Job ! Now let's see ...");
        if (userSum == randomSum) {
            System.out.println("That's it you guessed it");
            moneySum = 300000;
        } else {
            System.out.println("Bad luck :( the winning numbers sum was " + randomSum + " and your number was " + userSum + " it wasn't it");
        }

//Define an integer (numGuessed) to be later used to store the numbers of winning numbers and start a loop
        int numGuessed = 0;
        for (int i = 0; i < userNumbersArray.length; i++) {
//We run loop for each element in userNumbersArray
            for (int j = 0; j < randomNumbersArray.length; j++) {
                //We run another loop in the loop for each element in randomNumbersArray
                if (randomNumbersArray[j] == userNumbersArray[i]) {
                    //If we find a match between the two add +1 to numGuessed
                    numGuessed = numGuessed + 1;
                }
            }
        }
//Here we define integer for money, we assign 0 and then we switch. If the user guessed 1 wins 1000 if
//guessed 2 he gets 5000 and so on. at the end we have the win for this part of the game.
        int moneyNumberGuessed = 0;
        switch (numGuessed) {
            case 1:
                moneyNumberGuessed = 1000;
            case 2:
                moneyNumberGuessed = 5000;
            case 3:
                moneyNumberGuessed = 20000;
            case 4:
                moneyNumberGuessed = 100000;
            case 5:
                moneyNumberGuessed = 700000;
        }


        System.out.println("  ");

        int validMatchCache = 0;
        int[] sequenceCheck = new int[4];
        boolean endOfUserArr = true;
        System.out.println();
        System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
        System.out.println("||  We now have to check if any of your  ||");
        System.out.println("||    numbers are a matching sequence    ||");
        System.out.println("||                                       ||");
        System.out.println("||           Hold your breath            ||");
        System.out.println("* * * * * * * * * * * * * * * * * * * * * *");
        System.out.println(" ");
        System.out.println("========================================");
        System.out.println("|  Position |  RandomNum  |   UserNum    |");
        for (int j = 0; j < randomNumbersArray.length; j++) {
            if (!endOfUserArr) {
                break;
            }
            for (int i = 0; i <= userNumbersArray.length - 1; i++) {
                if (userNumbersArray[i] != randomNumbersArray[j]) {
                    if (validMatchCache > 0) {
                        sequenceCheck[0] = validMatchCache;
                        validMatchCache = 0;
                    }
                    System.out.println("|   " + j + " & " + i + "   |     " + randomNumbersArray[j] + "      |      " + userNumbersArray[i] + "      |  Nope ");

//                    }
                } else if (i == 4) {
                    if (randomNumbersArray[j] == userNumbersArray[i]) {
                        if (validMatchCache >= 1) {
                            sequenceCheck[1] = validMatchCache + 1;
                            validMatchCache = 0;
                            if (sequenceCheck[1] > 4) {
                                endOfUserArr = false;
                                System.out.println();
                                System.out.println();
                            }
                        }
                        System.out.println("|   " + j + " & " + i + "   |     " + randomNumbersArray[j] + "      |      " + userNumbersArray[i] + "      |  ***  Ahh bummer ! You were doing so great, you got a " + sequenceCheck[1] + " number sequence");
                    }
                    break;
                } else if (j == 9) {
                    if (randomNumbersArray[j] == userNumbersArray[i]) {
                        if (validMatchCache >= 1) {
                            sequenceCheck[2] = validMatchCache + 1;
                            validMatchCache = 0;
                            System.out.println("|   " + j + " & " + i + "   |     " + randomNumbersArray[j] + "     |      " + userNumbersArray[i] + "     |  ***  You won ! You guessed a sequence of " + sequenceCheck[2]);
                        }
                        break;
                    }
                } else {
                    validMatchCache = validMatchCache + 1;
//                    if (validMatchCache>1) {
//                        sequenceCheck[3] = validMatchCache;
//                        validMatchCache = 0;
//                    }

                    System.out.println("|   " + j + " & " + i + "   |     " + randomNumbersArray[j] + "      |      " + userNumbersArray[i] + "      |  ***  There's a match keep it going ");
                    j++;
                }
            }
        }
        int sequentialWin = 0;
        for (int i = 0; i < sequenceCheck.length; i++) {
            System.out.println(" ");
            System.out.println(Arrays.toString(sequenceCheck));
            if (sequenceCheck[i] >= 2) {
                sequentialWin = sequenceCheck[i];
                if (sequenceCheck[i] >= sequentialWin) {
                    System.out.println("Checking if " + sequenceCheck[i] + " and filling to sequentialWin " + sequentialWin);
                    sequentialWin = sequenceCheck[i];
                }
            } else {
                sequentialWin = sequenceCheck[i];
            }
        }


        int moneySequential = 0;
        if (sequentialWin >= 2) {
            switch (sequentialWin) {
                case 2:
                    moneySequential = 50000;
                case 3:
                    moneySequential = 300000;
                case 4:
                    moneySequential = 800000;
            }
        }

        System.out.println("\n ***** DEBUG PRINT ***** \n");
        System.out.println("Sequential for case is " + sequentialWin);
        System.out.println("Numbers guessed " + numGuessed);
        System.out.println("Money for sequential win is " + moneySequential);
        System.out.println("Money for the numbers guessed " + moneyNumberGuessed);
        System.out.println("The money won as a Bonus for the cards " + moneyBonus);
        System.out.println("The money won for guessing the sum of all the random numbers " + moneySum);
        int moneyNoBonus = 0;
        if (moneyNumberGuessed > moneySum) {
            System.out.println("Checking if the prise for your guessed numbers " + moneyNumberGuessed + " is bigger than the prize you got for guessing the sum " + moneySum);
            if (moneyNumberGuessed == moneySequential) {
                System.out.println("If it's bigger, I'm checking if it's equal with the prize for the sequential numbers" + moneySequential);
                moneyNoBonus = moneyNumberGuessed;
                System.out.println("Yeah it was equal so this is your highest prize");
            }
            if (moneyNumberGuessed > moneySequential) {
                System.out.println("Yeah it was bigger. Checking if ths prise is bigger than the sequential win " + moneySequential);
                moneyNoBonus = moneyNumberGuessed;
            }
        } else {
            if (moneyNumberGuessed == moneySum) {
                System.out.println("So far your win for the guessed number is the highest. Let's see if it's the same with the prize you got for the sum of all numbers " + moneySum);
                moneyNoBonus = moneyNumberGuessed;
            }
            if (moneySum > moneySequential) {
                System.out.println("Checking now to see if the prize for the sum " + moneySum + " is bigger than what you won for the sequential numbers " + moneySequential);
                moneyNoBonus = moneySum;
                System.out.println("Yeah that was it. Your highest win is " + moneySum);
            } else {
                System.out.println("Nope, your highest win is the sequential one " + moneySequential);
                moneyNoBonus = moneySequential;
            }
        }
//We add the moneyBonus to the money without bonus
        int totalWin = moneyNoBonus + moneyBonus;
        System.out.println("Now we add to your win " + moneyNoBonus + " the bonus for the cards " + moneyBonus);
        System.out.println("And your total winnings is " + totalWin + " Congratulations !");
    }
}














