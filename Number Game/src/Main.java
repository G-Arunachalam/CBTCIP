import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void game(){

        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        int ans = rnd.nextInt((100-1)+1)+1;

        System.out.println("\n\n\nI am gonna have a number in my mind between 1 - 100...");

        System.out.print("CAN YOU GUESS IT RIGHT??\n--------------------------\nEnter the number :");
        int guess = sc.nextInt();
        int count=1;

        while(guess!=ans){
            if(count>7){
                System.out.println("Game over!\nYou took too many tries...:(");
                break;
            }
            count++;
            if(guess>ans){
                System.out.print("Try smaller! ");

                if ((guess-ans) >=50 && (guess-ans) <101){
                    System.out.print("You are way to off:(\n");
                }
                else if ((guess-ans) >=20 && (guess-ans) <50){
                    System.out.print("You are getting there.\n");
                }
                else{
                    System.out.print("Almost there.\n");
                }
            }
            else{
                System.out.print("Try Bigger! ");
                if ((ans-guess) >=50 && (ans-guess) <101){
                    System.out.print("You are way to off:(\n");
                }
                else if ((ans-guess) >=20 && (ans-guess) <50){
                    System.out.print("You are getting there.\n");
                }
                else{
                    System.out.print("Almost there.\n");
                }
            }
            System.out.print("--------------------------\nEnter the number :");
            guess = sc.nextInt();
        }

        if(guess== ans){
            System.out.println("You got it right!");
            System.out.println("You took "+count+" tries..");
            System.out.println("Score : "+(110-(count*10))+".");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;

        while(true){
            System.out.println("\n\n\npress '1' to Start\npress '2' to Exit\n");
            System.out.println("Choose : ");
            n = sc.nextInt();

            if(n==1){
                game();
            }
            else if(n==2){
                System.out.println("Closing...");
                break;
            }
            else{
                System.out.println("Invalid option:(");
            }
        }
    }
}