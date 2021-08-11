import java.util.*;
import java.util.stream.Stream;

class LagranUn {
    
    static double interpolate(double x[],double y[],int xi, int n) {
        double result = 0;
        for (int i = 0; i < n; i++) {
            double term = y[i];
            for (int j = 0; j < n; j++) {
                if (j != i)
                    term = term * (xi - x[j]) / (x[i] - x[j]);
            }
            result += term;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String strX;
        String strY;

        System.out.println("Enter the values of x");
        strX = in.nextLine();
        double [] x = Stream.of(strX.split(",")).mapToDouble(Double::parseDouble).toArray();
         
        int n = x.length;

        System.out.println("Enter the values of y");
        strY = in.nextLine();
        double y[] = Stream.of(strY.split(",")).mapToDouble(Double::parseDouble).toArray();
        
        int value = 0;
        System.out.println("enter value to interpolate at");
        value = in.nextInt();

    
        System.out.print("Value of" + "f"+"("+value+")" +"is : " +  interpolate(x,y,value,n));
    }
}