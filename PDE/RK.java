// Java program to implement Runge Kutta method
import java.io.*;


class RK
{
	double dydx(double x, double y)
	{
		return (x + Math.pow(y,2));
	}
	
	// Finds value of y for a given x using step size h
	// and initial value y0 at x0.
	double rungeKutta(double x0, double y0, double x, double h)
	{
		RK d1 = new RK();
		// Count number of iterations using step size or
		// step height h
		int n = (int)((x - x0) / h);

		double k1, k2, k3, k4, k5;

		// Iterate for number of iterations
		double y = y0;
		for (int i = 1; i <= n; i++)
		{
			// Apply Runge Kutta Formulas to find
			// next value of y
			k1 = h * (d1.dydx(x0, y));
			k2 = h * (d1.dydx(x0 + 0.5 * h, y + 0.5 * k1));
			k3 = h * (d1.dydx(x0 + 0.5 * h, y + 0.5 * k2));
			k4 = h * (d1.dydx(x0 + h, y + k3));

            


			
			y = y + (1.0 / 6.0) * (k1 + 2 * k2 + 2 * k3 + k4);
			
			// Update next value of x
			x0 = x0 + h;

            System.out.println("k1: "+k1);
            System.out.println("k2: "+k2);
            System.out.println("k3: "+k3);
            System.out.println("k4: "+k4);
            System.out.println("y: "+y);
            System.out.println("x: "+x);
            System.out.println("----------");

		}
		return y;
	}
	
	public static void main(String args[])
	{
		RK d2 = new RK();
		double x0 = 0, y = 1, x = 0.1, h = 0.1;
		
		System.out.println("\nThe value of y at x is : "
					+ d2.rungeKutta(x0, y, x, h));
	}
}


