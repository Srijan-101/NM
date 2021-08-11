
import java.text.*;
import java.math.*;
import java.util.stream.Stream;
import java.util.*;

class NRdivided {

    static double proterm(int i, double value, double x[]) {
        double pro = 1;
        for (int j = 0; j < i; j++) {
            pro = pro * (value - x[j]);
        }
        return pro;
    }

    
    static void dividedDiffTable(double x[], double y[][], int n) {
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                y[j][i] = (y[j][i - 1] - y[j + 1][i - 1]) / (x[j] - x[i + j]);
            }
        }
    }

    
    static double applyFormula(double value, double x[], double y[][], int n) {
        double sum = y[0][0];

        for (int i = 1; i < n; i++) {
            sum = sum + (proterm(i, value, x) * y[0][i]);
        }
        return sum;
    }

    
    static void printDiffTable(double y[][], int n) {
        DecimalFormat df = new DecimalFormat("#.####");
        df.setRoundingMode(RoundingMode.HALF_UP);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                String str1 = df.format(y[i][j]);
                System.out.print(str1 + "\t ");
            }
            System.out.println("");
        }
    }

    
    public static void main(String[] args) {
        // number of inputs given


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

        System.out.println("Enter the value");
        double value = in.nextDouble();

        for(int i = 0; i < n;i++){
             y[i][0] = z[i];
        }

       
        dividedDiffTable(x, y, n);
        printDiffTable(y, n);


        DecimalFormat df = new DecimalFormat("#.##");
        df.setRoundingMode(RoundingMode.HALF_UP);

        System.out.println("\nValue at " + df.format(value) + " is " + df.format(applyFormula(value, x, y, n)));
    }
}

