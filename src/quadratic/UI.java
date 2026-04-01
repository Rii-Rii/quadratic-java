package quadratic.src.quadratic;
import java.util.Scanner;

public class UI
{
    private Equation e1 = new Equation();
    private Scanner s = new Scanner(System.in);

    void loadMenu()
    {
        System.out.println("\n\n");
        System.out.println("\t\t\t  QUADRATIC SOLVER");
        System.out.println("\tBecause who likes solving these manually?");
        System.out.println("");

        while (true)
        {
            if (!input())
            {
                System.out.println("\n************ Exiting ************");
                break;
            }

            output();
        }
        System.out.println("");
        s.close();
    }

    boolean input()
    {
        System.out.println("Enter the coefficients (or a = 0 to quit)");
        System.out.print("\nEnter a: ");
        double A = s.nextDouble();

        if (A == 0)
        {
            return false;
        }

        System.out.print("Enter b: ");
        double B = s.nextDouble();

        System.out.print("Enter c: ");
        double C = s.nextDouble();

        if (e1.setCoefficients(A, B, C))
        {
            return true;
        }
        else
        {
            System.out.println("'a' cannot be zero");
            return false;
        }
    }

    void output()
    {
        double[] coeff = e1.getCoeff();
        double D = e1.getDiscriminant();

        System.out.println("\n----------------------------------------");
        System.out.println("Equation      : " + ((coeff[0]!=1)?coeff[0]:"") + "x^2 + " + coeff[1] + "x + " + coeff[2]);
        System.out.println("Discriminant  : " + D);

        if (D > 0)
        {
            System.out.println("Nature        : Two distinct real roots");
            System.out.println("Roots         : " + e1.getRoot1() + " , " + e1.getRoot2());
        }
        else if (D == 0)
        {
            System.out.println("Nature        : Equal real roots");
            System.out.println("Root          : " + e1.getRoot1());
        }
        else
        {
            System.out.println("Nature        : Complex roots");
            System.out.println("Roots         : " + e1.getComplexRoots());
        }

        System.out.println("----------------------------------------\n");
    }
}
