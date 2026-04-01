package quadratic.src.quadratic;

public class Equation
{
    private double a, b, c;
    private double d;
    private double r1, r2;
    private String root;

    Equation()
    {
        a = 1.0;
        b = 0.0;
        c = 0.0;
        d = 0.0;
        r1 = 0.0;
        r2 = 0.0;
        root = "";
    }

    boolean setCoefficients(double A, double B, double C)
    {
        if (A == 0.0)
        {
            return false;
        }

        a = A;
        b = B;
        c = C;
        computeRoots();
        return true;
    }

    private void computeRoots()
    {
        d = b * b - 4 * a * c;

        if (d >= 0)
        {
            r1 = (-b + Math.sqrt(d)) / (2 * a);
            r2 = (-b - Math.sqrt(d)) / (2 * a);
        }

        else
        {
            double real = -b / (2 * a);
            double imag = Math.sqrt(-d) / (2 * a);
            root = real + " + " + imag + "i , " + real + " - " + imag + "i";
        }
    }

    double getDiscriminant()
    {
        return d;
    }

    double getRoot1()
    {
        return r1;
    }

    double getRoot2()
    {
        return r2;
    }

    double[] getCoeff()
    {
        return new double[]{a, b, c};
    }

    boolean hasRealRoots()
    {
        return d >= 0;
    }

    boolean hasEqualRoots()
    {
        return d == 0;
    }

    boolean hasComplexRoots()
    {
        return d < 0;
    }

    String getComplexRoots()
    {
        return root;
    }
}

