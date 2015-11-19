// TEAM Yu(r) W(r)ong - Jennifer Yu, Conan Wong
// APCS1 pd9
// HW33 -- Do You Even Add, Bro?
// 2015-11-17

public class Rational {
    
//Instance variables for the numerator and denominator
    private double num;
    private double den;
    

//Default constructor (no parameters) : Creates a new Rational with the value of 0/1
    public void rational() {
        num = 0.0;
        den = 1.0;
    }

/*Constructor takes 2 parameters, one for the numerator, one for the denominator
if an invalid denominator is attempted, should print a message and set the number to 0/1 */
    public void rational(double p, double q){
        if (q != 0) {
            num = p;
            den = q;
        }
        else {
            System.out.println("Invalid denominator! Setting number to 0/1...");
            rational();
        }
    }
    
//toString - returns a string representation of the rational number (formatting of your choice)
    public String toString() {
        return num + " / " + den;
    }
/*
floatValue - Returns a floating point value of the number, Uses the most precise floating point primitive
*/
    public double floatValue() {
        return (num / den);
}

    
/*
multiply
Takes 1 Rational object as a parameter and multiplies it by this Rational object
Does not return any value 
Should modify this object and leave the parameter alone (see below for example)
Need not reduce the fraction
*/
    public void multiply(Rational r) {
        num *= r.num;
        den *= r.den;
}

/*
divide
Works the same as multiply, except the operation is division
*/
    public void divide(Rational r) {
        num *= r.den;
        den *= r.num;
}//lml this is how i still do rational division, the flipping method.

    public void add(Rational r){
    	num *= r.den;
    	r.num *= den;
    	num += r.num;
    	den *= r.den;
    	r.den = den;
}	

    public void subtract(Rational r){
    	num *= r.den;
    	r.num *= den;
    	num -= r.num;
    	den *= r.den;
}

    public double gcd(double a, double b) { //while loop
	double currentGCD = 1.0;
	double remainder;
	if (a % b == 0.0) { //base case
		currentGCD = b;
	}
	while ((a % b) != 0.0) {
		remainder = a % b; 
		a = b; 
		b = remainder; 
		currentGCD = b;
	}
	return currentGCD;
}
    public void reduce(){
    	double divisor = gcd(num,den);
    	num = num / divisor;
   	den = den / divisor;
}

    public static void main(String[] args) {
        Rational a = new Rational();
        a.rational();
        System.out.println(a);	 
        a.rational(3,7);
        System.out.println(a);
	    //System.out.println(rational());
	    //System.out.println(rational(6,0));
	    //System.out.println(rational(3,7));
	    System.out.println(a.toString());
	    System.out.println(a.floatValue());	
	    Rational b = new Rational();
	    b.rational(2,3);
	    a.multiply(b);
	    System.out.println(a);	
	    a.divide(b);
	    System.out.println(a);
	    //System.out.println("hi");	 
    }
}







