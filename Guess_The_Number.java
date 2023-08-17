package Special;
import java.util.*;
class Game{
   int a;
   int b;
   int count;
    public Game(int n){
       a=n;
    }
    public void takeUserInput(){
        System.out.println("Enter your guessed number");
        Scanner src= new Scanner(System.in);
         b= src.nextInt();
    }
    public void isCorrectNumber(){
        if(b==a){
            System.out.println("Woah! You guessed the correct number");
        }
        else if (b>a) {
            System.out.println("Your guessed number is greater than original number");
            System.out.println("******************************************************");
        }
        else {
            System.out.println("Your guessed number is less than original number");
            System.out.println("*****************************************************");
        }
    }
    public void setCount(int n){
        count=n;
    }
    public int getCount(){
        return count;
    }
}
public class Guess_The_Number {
    public static void main(String[] args) {
        System.out.println("Welcome to the number guessing game");
        System.out.println("Guess a number between 1 to 100");
        int e=1;
        Random rand = new Random();
        int a = rand.nextInt(101);
        Game yatin = new Game(a);
        while (true) {
            yatin.takeUserInput();
            yatin.isCorrectNumber();
            if (yatin.a != yatin.b) {
                e++;
                continue;
            }
            else {
                break;
            }
        }
        yatin.setCount(e);
        System.out.println("Your score is "+yatin.getCount());
    }
}
