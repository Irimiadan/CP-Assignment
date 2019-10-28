import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int[] rndNumbersarray = new int[10];
        Random random = new Random();
        Scanner scan = new Scanner(System.in);


        for (int i = 0; i < rndNumbersarray.length; i++) {
            rndNumbersarray[i] = random.nextInt(99 + 1);
            boolean duplicate = true;

            while (duplicate) {
                duplicate = false;

                for (int j = 0; j < i; j++) {
                    if (rndNumbersarray[i] == rndNumbersarray[j]) {
                        duplicate = true;
                        break;
                    }
                }
                if (duplicate == true) {
                    rndNumbersarray[i] = random.nextInt(99 + 1);
                }
            }
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = sum + rndNumbersarray[i];
            if (rndNumbersarray[i] < 10) {
                System.out.print("0" + rndNumbersarray[i] +" ");
            } else {
                System.out.print(rndNumbersarray[i]+" ");
            }
        }
//        System.out.println(Arrays.toString(rndNumbersarray));
        System.out.println("");
        System.out.println("The sum of all the numbers drawn is "+sum);
        // Calculate bonus random €10 (60% chance), €20(20% chance), €50(10% chance), €200(7.5% chance) and €1000(2.5% chance).
        int[] prize = {0, 0, 0, 0, 0}; // Create array for the 5 possible wins
        double bonusRnd;
//      Starting to loop 4 times to calculate the bonus win.
        for (int i = 0; i < 4; i++) {
            bonusRnd = random.nextInt(9999) + 1;
            bonusRnd = bonusRnd / 100;
            //Generated an integer from one to 1000 and we divide it by 100 to obtain a double digit from 0 to 100
            if (bonusRnd > 0 & bonusRnd <= 2.5) {
                prize[0] = prize[0] + 1;
                System.out.println("€1000");
                // 2.5% (2.5-0) chance to obtain prize 0. If obtained, add 1 to position 0 in the prize array.
            } else if (bonusRnd >= 2.5 & bonusRnd <= 10) {
                prize[1] = prize[1] + 1;
                System.out.println("€200");
                // 7.5% (10-2.5) chance to obtain prize 1. If obtained, add 1 to position 0 in the prize array.
            } else if (bonusRnd >= 10 & bonusRnd <= 20) {
                prize[2] = prize[2] + 1;
                System.out.println("€50");
                // 10% (20-10) chance to obtain prize 2. If obtained, add 1 to position 2 in the prize array.
            } else if (bonusRnd >= 20 & bonusRnd <= 40) {
                prize[3] = prize[3] + 1;
                System.out.println("€20");
                // 20% (40-20) chance to obtain prize 1. If obtained, add 1 to position 3 in the prize array.
            } else if (bonusRnd >= 40 & bonusRnd <= 100) {
                prize[4] = prize[4] + 1;
                System.out.println("€10");
                // 60% (100-40) chance to obtain prize 1. If obtained, add 1 to position 4 in the prize array.
            }
        }
        for (int i = 0; i < prize.length; i++) {
            if (prize[i] >= 2) {
                switch (i) {
                    case 0:
                        System.out.println("Congratulations you won the 1000E bonus !");
                        break;
                    case 1:
                        System.out.println("Congratulations you won the 200E bonus !");
                        break;
                    case 2:
                        System.out.println("Congratulations you won the 50E bonus !");
                        break;
                    case 3:
                        System.out.println("Congratulations you won the 20E bonus !");
                        break;
                    case 4:
                        System.out.println("Congratulations you won the 10E bonus !");
                        break;
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
                    for (int j = 0; j < i ; j++) {
                        if (userNumbersArray[i] == userNumbersArray[j]) {
                            notValid = true;
                            System.out.println("Please don't repeat yourself");
                            System.out.println("Enter another number please");
                            break;
                        }
                        if (userNumbersArray[i] < 0) {
                            notValid = true;
                            System.out.println("It has to be bigger than 0");
                            System.out.println("Enter another number please");
                            break;
                        }
                        if (userNumbersArray[i] > 100) {
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
        System.out.print("Your chosen numbers are : " +Arrays.toString(userNumbersArray));
        }
    }


