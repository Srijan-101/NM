import java.util.*;
import java.util.stream.Stream;


public class Expo{
     public static void main(String[] args){

         Scanner in = new Scanner(System.in);
         String strX;
         String strY;


         System.out.println("Enter the values of x");
         strX = in.nextLine();
         double [] x = Stream.of(strX.split(",")).mapToDouble(Double::parseDouble).toArray();

         System.out.println("Enter the values of y");
         strY = in.nextLine();
         double [] y = Stream.of(strY.split(",")).mapToDouble(Double::parseDouble).toArray();
         

         double xsum = 0;
         double ysum = 0;
         double Y = 0;
         double XY = 0;
         double X2 = 0;

         
            System.out.print("∑x"+"\t");
            System.out.print("∑y"+"\t");
            System.out.print("∑Y"+"\t");
            System.out.print("∑XY"+"\t");
            System.out.print("X^2"+"\t");
            System.out.println();

            double num = 0;

        for(int i = 0 ; i < x.length;i++){

            num = Math.log10(y[i]);
    
            System.out.format("%.4f",x[i]);
            System.out.print("\t");

            System.out.format("%.4f",y[i]);
            System.out.print("\t");

            System.out.format("%.4f",num);
            System.out.print("\t");

            System.out.format("%.4f",(x[i] * num));
            System.out.print("\t");

            System.out.format("%.4f",(x[i] * x[i]));
            System.out.println();

            xsum = xsum + x[i];
            ysum = ysum + y[i];
            Y = Y + num;
            XY = XY + num * x[i];
            X2 = X2 + x[i] * x[i];        
        }   
            System.out.println();
            System.out.print(xsum+"\t");
            System.out.print(ysum +"\t");
            System.out.print(Y +"\t");
            System.out.print(XY +"\t");
            System.out.print(X2 +"\t");
     }
    }

