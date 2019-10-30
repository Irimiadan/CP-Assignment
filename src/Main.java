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
                if (duplicate == true) {
                    randomNumbersArray[i] = random.nextInt(98) + 1;
//if duplicate is true we generate another random number.
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + randomNumbersArray[i];
//calculate the sum of the random generated numbers by adding each element in the randomNumbersArray to (sum).
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
        System.out.println("The sum of all the numbers drawn is " + sum);
//Print the sum of all elements.
// Calculate bonus random €10 (60% chance), €20(20% chance), €50(10% chance), €200(7.5% chance) and €1000(2.5% chance).
        int[] bonusPrize = {0, 0, 0, 0, 0}; // Create array for the 5 possible wins
        double randomBonus;
//Starting to loop 4 times to calculate the bonus win.
        for (int i = 0; i < 4; i++) {
            randomBonus = random.nextInt(9999) + 1;
            randomBonus = randomBonus / 100;
//Generated an integer from 1 to 10000 and we divide it by 100 to obtain a double from 1 to 100
            if (randomBonus > 0 & randomBonus <= 2.5) {
                bonusPrize[0] = bonusPrize[0] + 1;
                System.out.println("€1000");
// 2.5% (2.5-0) chance to obtain bonusPrize 0. If obtained, add 1 to position 0 in the bonusPrize array.
            } else if (randomBonus > 2.5 & randomBonus <= 10) {
                bonusPrize[1] = bonusPrize[1] + 1;
                System.out.println("€200");
// 7.5% (10-2.5) chance to obtain bonusPrize 1. If obtained, add 1 to position 0 in the bonusPrize array.
            } else if (randomBonus > 10 & randomBonus <= 20) {
                bonusPrize[2] = bonusPrize[2] + 1;
                System.out.println("€50");
// 10% (20-10) chance to obtain bonusPrize 2. If obtained, add 1 to position 2 in the bonusPrize array.
            } else if (randomBonus > 20 & randomBonus <= 40) {
                bonusPrize[3] = bonusPrize[3] + 1;
                System.out.println("€20");
// 20% (40-20) chance to obtain bonusPrize 1. If obtained, add 1 to position 3 in the bonusPrize array.
            } else if (randomBonus > 40 & randomBonus <= 100) {
                bonusPrize[4] = bonusPrize[4] + 1;
                System.out.println("€10");
// 60% (100-40) chance to obtain bonusPrize 1. If obtained, add 1 to position 4 in the bonusPrize array.
            }
        }
        int bonusWin = 0;
//Define integer bonusWin as a container for the total money won
        for (int i = 0; i < bonusPrize.length; i++) {
//Run a loop through bonusPrize array positions.
            if (bonusPrize[i] >= 2) {
                switch (i) {
                    case 0:
                        System.out.println("Congratulations you won the 1000E bonus !");
                        bonusWin = bonusWin + 1000;
                        break;
                    case 1:
                        System.out.println("Congratulations you won the 200E bonus !");
                        bonusWin = bonusWin + 200;
                        break;
                    case 2:
                        System.out.println("Congratulations you won the 50E bonus !");
                        bonusWin = bonusWin + 50;
                        break;
                    case 3:
                        System.out.println("Congratulations you won the 20E bonus !");
                        bonusWin = bonusWin + 20;
                        break;
                    case 4:
                        System.out.println("Congratulations you won the 10E bonus !");
                        bonusWin = bonusWin + 10;
                        break;
//Use a swich case for all the positions(i) in the array bonusPrize array if in any (i)case the value is > 2 then print
// "congrats and the sum won" then add the amount to bonusWin
                }
            }
        }
        System.out.println("Enter 5 numbers. Please do not repeat them");

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
                if (notValid == true) {
                    userNumbersArray[i] = scan.nextInt();
                }
            }


        }

        int numGuessed = 0;
// Define an integer (numGuessed) to be later used to store the numbers of winning numbers and start a loop
//        for (int i = 0; i < userNumbersArray.length; i++) {
//            System.out.println("Checking your number " + userNumbersArray[i]);
////Loop through the user chosen numbers and display the number being checked
//            for (int j = 0; j < randomNumbersArray.length; j++) {
////                System.out.println("Against winning number " + randomNumbersArray[j]);
////Loop through the random generated numbers and display the number
//                if (userNumbersArray[i] == randomNumbersArray[j]) {
//                    numGuessed = numGuessed + 1;
////                    System.out.println(userNumbersArray[i] + " And " + randomNumbersArray[j] + " It's a MATCH !");
//                    break;
///*Compare the user generated number with the random generated numbers.
//If they are equal add 1 to numGuessed integer, and break the inner loop (randomNumbersArray) since we don't have any
//duplicates in the random generated number array*/
//                }
//            }
//        }
        System.out.println("  ");
        System.out.println("  ");

        int foundCache = 0;
        for (int i = foundCache; i <= (userNumbersArray.length) - 1; i++) {

            for (int j = foundCache; j < randomNumbersArray.length; j++) {
                System.out.println("Now check " + userNumbersArray[i] + " and " + randomNumbersArray[j]);
                if (userNumbersArray[i] == randomNumbersArray[j]) {
                    System.out.print("...Those two are the same the same... ");
                    foundCache = j + 1;
                    System.out.println("Adding Cache");
                    System.out.println("...Next...");
                    break;

                }
                else {
                    System.out.println("...Those two are NOT the same the same... ");
                }
            }
        }
    }
}
//        }

//                    if (randomNumbersArray[i+1]==userNumbersArray[j+1]) {
//                                System.out.println("consecutive Value" + consecutive + "winnings" + consecutiveWin);
//                    consecutive = consecutive + 1;
//                    System.out.println("Match found ");
//        System.out.println("You guessed " + numGuessed + " Numbers Congratulations !");
//        System.out.print("Your chosen numbers are : " + Arrays.toString(userNumbersArray));
//        System.out.print("The random generated numbers are : " + Arrays.toString(randomNumbersArray));
//    }



