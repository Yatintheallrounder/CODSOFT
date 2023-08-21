package Special;
import java.util.*;
public class PercentageCalculator {
    public static void main(String[] args) {
        Scanner src= new Scanner(System.in);
        System.out.println("Enter the no. of subjects: ");
        int n= src.nextInt();
        int total=0;
        for (int i=1;i<=n;i++){
            System.out.println("Enter the marks obtained in subject "+i+": ");
            int marks=src.nextInt();
            total=total+marks;
        }
        double perc=(double)total/n;
        char Grade;
        if (perc>=90){
            Grade='A';
        } else if (80<=perc) {
            Grade='B';
        } else if (perc>=70) {
            Grade='C';
        } else if (perc>=60) {
            Grade='D';
        } else if (perc>=50) {
            Grade='E';
        }
        else {
            Grade='F';
        }
        System.out.println("Your percentage is: "+perc);
        System.out.println("Your grade is: "+Grade);
    }
}