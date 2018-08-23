package net.euler;

import java.math.BigInteger;

public class _57_SquareRootConvergents {

	static final BigInteger bigOne = new BigInteger("1");
	static final BigInteger bigTwo = new BigInteger("2");
	
	public static void main(String[] args) {
		
		int count = 0;
		
		
//		System.out.println(new Fraction(4, 5).add(new Fraction(8, 3)));
		
		for (int n = 1; n < 1000; n++) {
		
			Fraction result = new Fraction(bigOne, bigOne).add(new Fraction(bigOne, bigOne).divide(
											getInner(new BigInteger(Integer.toString(n)))));
			
			if (result.getNumerator().toString().length() > result.getDenominator().toString().length()) {
				count++;
				System.out.println(count);
				System.out.println(n + " => " + result);
			}
			
//			System.out.println(n + " => " + result);
		}
		
		
	}
	
	private static Fraction getInner(BigInteger n) {
		
		if (n.compareTo(bigOne) == 0) {
			return new Fraction(bigTwo, bigOne).add(new Fraction(bigOne, bigTwo));
		}
		
		return new Fraction(bigTwo, bigOne).add(new Fraction(bigOne, bigOne).divide(getInner(n.subtract(bigOne))));
	}

}

class Fraction {
	
	private BigInteger numerator;
	private BigInteger denominator;
	
	public Fraction() {
		
	}
	
	public Fraction(BigInteger numerator,BigInteger denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}
	
	public Fraction add(Fraction fraction) {
		
		Fraction frac = new Fraction();
		frac.setDenominator(lcd(this.denominator, fraction.denominator));
		frac.setNumerator((frac.denominator.divide(this.denominator)).multiply(this.numerator).add(
							(frac.denominator.divide(fraction.denominator)).multiply(fraction.numerator)));
		
		return frac.reduce();
	}
	
	public Fraction multiply(Fraction fraction) {
		
		Fraction frac = new Fraction();
		frac.setNumerator(numerator.multiply(fraction.numerator));
		frac.setDenominator(denominator.multiply(fraction.denominator));
		
		return frac.reduce();
	}
	
	public Fraction divide(Fraction fraction) {
		
		return multiply(fraction.flip(fraction));
	}
	
	public Fraction flip(Fraction fraction) {
		
		Fraction frac = new Fraction();
		frac.numerator = fraction.denominator;
		frac.denominator = fraction.numerator;
		
		return frac;
	}
	
	public Fraction reduce() {
		
		BigInteger gcd = gcd(numerator, denominator);
		
		Fraction frac = new Fraction();
		frac.denominator = denominator.divide(gcd);
		frac.numerator = numerator.divide(gcd);
		
		return frac;
	}
	
	static final BigInteger bigZero= new BigInteger("0");
	
	public static BigInteger gcd(BigInteger a, BigInteger b) {
		
		BigInteger r = new BigInteger("0");
		while(b.compareTo(bigZero) != 0) {
			r = a.mod(b);
			a = b;
			b = r;
		}
		return a;
	}
	
	public static BigInteger lcd(BigInteger a, BigInteger b) {
		
		return (a.multiply(b)).divide(gcd(a, b));
	}

	public BigInteger getNumerator() {
		return numerator;
	}

	public void setNumerator(BigInteger numerator) {
		this.numerator = numerator;
	}

	public BigInteger getDenominator() {
		return denominator;
	}

	public void setDenominator(BigInteger denominator) {
		this.denominator = denominator;
	}
	
	@Override
	public String toString() {
		return numerator.toString() + "/" + denominator.toString();
	}
}
