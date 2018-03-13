class QuadraticEquation{
  public enum states{
    ONE_ROOT,
    TWO_ROOTS,
    RESULT_IN_COMPLEX,
    NOT_CALCULATED
  }


  private double a;
  private double b;
  private double c;
  private double root_1;
  private double root_2;
  private Complex complex_root_1 = new Complex();
  private Complex complex_root_2 = new Complex();
  private double delta;
  private states equation_state;

  QuadraticEquation(double init_a, double init_b, double init_c)
  {
    a = init_a;
    if(a == 0)
    {
      System.out.println("This is not a quadratic equation.");
      System.exit(3);
    }
    b = init_b;
    c = init_c;
    equation_state = states.NOT_CALCULATED;
  }

  private double calculateDelta()
  {
    return b*b-4.0*a*c;
  }

  public void solve()
  {
    delta = calculateDelta();
    // System.out.println(Double.toString(delta));
    if(delta > 0.0d)
    {
        root_1 = (-b-Math.sqrt(delta))/(2.0*a);
        root_2 = (-b+Math.sqrt(delta))/(2.0*a);
        equation_state = states.TWO_ROOTS;
    }
    else if(delta == 0.0d)
    {
        root_1 = -b/(2*a);
        root_2 = root_1;
        equation_state = states.ONE_ROOT;
    }
    else if(delta < 0.0d)
    {
      complex_root_1 = new Complex((-b/(2.0*a)), -Math.sqrt(Math.abs(delta))/(2.0*a));
      complex_root_2 = complex_root_1.conj();
      equation_state = states.RESULT_IN_COMPLEX;
    }
  }

  public void printResult()
  {
    if(equation_state == states.NOT_CALCULATED)
    {
      System.out.println("The equation is not calculated.");
    }
    else
    {
      if(Double.isInfinite(root_1) || Double.isInfinite(root_2) || Double.isNaN(root_1) || Double.isNaN(root_2) || Double.isNaN(complex_root_1.getImag()) || Double.isNaN(complex_root_1.getReal()) || Double.isInfinite(complex_root_1.getReal()) || Double.isInfinite(complex_root_1.getImag()))
      {
        System.out.println("Error: Parameters are too small or too big for calculation.");
        System.exit(2);
      }
      if(equation_state == states.ONE_ROOT)
      {
        System.out.print("The equation: "+a+"x^2+"+b+"x+"+c+" has ");
        System.out.println("one solution");
        System.out.println("x = " + root_1);
      }
      else if(equation_state == states.TWO_ROOTS)
      {
        System.out.print("The equation: "+a+"x^2+"+b+"x+"+c+" has ");
        System.out.println("two solutions in real numbers");
        System.out.println("x1 = " + root_1);
        System.out.println("x2 = " + root_2);
      }
      else if(equation_state == states.RESULT_IN_COMPLEX)
      {
        System.out.print("The equation: "+a+"x^2+"+b+"x+"+c+" has ");
        System.out.println("two solutions in complex numbers");
        System.out.println("x1 = " + complex_root_1);
        System.out.println("x2 = " + complex_root_2);
      }
    }
  }

}
