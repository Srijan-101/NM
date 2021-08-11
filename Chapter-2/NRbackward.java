import java.util.*;
import java.util.stream.Stream;

public class NRbackward {
    static double u_cal(double u, int n) {
        double temp = u;
        for (int i = 1; i < n; i++)
            temp = temp * (u + i);
        return temp;
    }

    static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
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
        double z[] = Stream.of(strY.split(",")).mapToDouble(Double::parseDouble).toArray();
        
        Double[][] y = new Double[n][n];

        System.out.println("Enter the year you wanna find");
        double value = in.nextDouble();

        for(int i = 0; i < n;i++){
             y[i][0] = z[i];
        }


        for (int i = 1; i < n; i++)
    {
        for (int j = n - 1; j >= i; j--)
            y[j][i] = y[j][i - 1] - y[j - 1][i - 1];
    }
        
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.format("%.3f\t", x[i]);
            for (int j = 0; j <= i; j++)
                System.out.format("%.3f\t", y[i][j]);
            System.out.println();
        }

        double sum = y[n - 1][0];
        double u = (value - x[n - 1]) / (x[1] - x[0]);
        for (int i = 1; i < n; i++) {
            sum = sum + (u_cal(u, i) * y[n - 1][i]) / fact(i);
        }

        System.out.println("\n Value at " + value + " is " + String.format("%.6g%n", sum));
    }
}
