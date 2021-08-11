import java.util.*;
import java.util.stream.Stream;

public class GaussForward {

    static double p_cal(double p, int n) {
        double temp = 0;
        for (int i = 0; i < n; i++) {

            if (i % 2 == 1) {
                temp = temp * (p - 1);
            } else {
                temp = temp * (p + 1);
            }
        }
        return temp;
    }

    static int fact(int n) {
        int f = 1;
        for (int i = 2; i <= n; i++)
            f *= i;
        return f;
    }

    public static void main(String[] args){

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
        
        double[][] y = new double[n][n];

        System.out.println("Enter the year you wanna find");
        double value = in.nextDouble();

        for(int i = 0; i < n;i++){
             y[i][0] = z[i];
        }
        

        for(int i = 1 ; i < n;i++){
             for(int j = 0 ; j < n - 1 ;j++){
                y[j][i] = (y[j + 1][i - 1] - y[j][i - 1]);
             }
        }

        for(int i = 0 ; i < n ;i++){
            System.out.print(x[i]+"\t");
            for(int j = 0 ; j < n - 1 ; j++){
                System.out.print(y[i][j]+"\t");
            }
            System.out.println("");
        }

        double sum = y[(int)(n/2)][0];
        double p = (value - x[(int)(n/2)]) / (x[1] - x[0]);

        for(int i = 1 ; i < n;i++){
            sum = sum + (p_cal(p, i) * y[(int)((n-i)/2)][i]) / fact(i);
        }

        System.out.println("Value is " + sum);
    }
}
