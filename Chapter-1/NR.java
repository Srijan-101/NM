import java.util.*;
import java.math.*;

class NR {

    public static double ques(double x){
        return 3 * x - Math.cos(x) - 1;
    }

    public static double der(double x){
        return 3 + Math.sin(x);
    }
    public static void main(String args[]){
        double x0,root,givenError = 4,error;
        boolean flag=true;
        
        int i=1;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter value for x0 : ");
        x0 = sc.nextDouble();

        givenError=x0;

        while(flag){
            
            root = x0 - (ques(x0)/der(x0));
            error = Math.abs((root-x0)/root)*100;
            
            System.out.println("Iteration : "+ i++);
            System.out.println(x0 +  "- f(x0) / f'(x0)");
            System.out.println("Root:"+ root);
            System.out.println("--------------------------");

            x0 = root; 

            if(givenError>error)
            {
                    flag=false;
            }
        }
    }
}