package Exam;

public class Rational {

	private long num;
	private long denum;

	public Rational() {
		this.num = 0;
		this.denum = 1;
	}

	public Rational(long num, long denum) {
		this.num = num;
		this.denum = denum;
	}

	public void normalize() {
		long num = this.num;
		long denum = this.denum;

		if (denum < 0) {
			this.denum = -denum;
			this.num = -num;
		}
	}

	public void reduce() {
		this.normalize();
		long g = gcd(this.num, this.denum);
		this.num /= g;
		this.denum /= g;

	}

	private long gcd(long a, long b)

	{
		long g;

		if (b == 0) {
			return a;
		} else {
			g = gcd(b, (a % b));
		}

		if (g < 0) {
			return -g;
		}

		else {
			return g;
		}
	}

	public long num() {
		return this.num;
	}

	public long denum() {
		return this.denum;
	}

	public Rational add(Rational r) {

		Rational result = new Rational();

		result.num = (this.num * r.denum()) + (r.num() * this.denum);
		result.denum = this.denum * r.denum;

		result.normalize();
		result.reduce();
		return result;
	}

	public Rational sub(Rational r) {

		Rational result = new Rational();

		result.num = (this.num * r.denum()) - (r.num() * this.denum);
		result.denum = this.denum * r.denum;

		result.normalize();
		result.reduce();
		return result;
	}

	public Rational mul(Rational r) {

		Rational result = new Rational();

		result.num = (this.num * r.num());
		result.denum = (this.denum * r.denum());

		result.normalize();
		result.reduce();
		return result;
	}

	public Rational div(Rational r) {

		Rational result = new Rational();

		result.num = (this.num * r.denum());
		result.denum = (this.denum * r.num());

		result.normalize();
		result.reduce();
		return result;
	}

	public boolean equals(Rational r) {
		if ((this.num() * r.denum()) == (r.num() * this.denum())) {
			return true;
		}

		else {
			return false;
		}
	}

	public String toString() {
		return String.valueOf(this.num) + "/" + String.valueOf(this.denum);

	}

	public static void main(String args[]) {

		Rational a = new Rational(1, 2);
		Rational b = new Rational(2, 3);

		Rational c;

		c = a.add(b);
		System.out.println(a + " " + b + " " + c);

		c = a.sub(b);
		System.out.println(a + " " + b + " " + c);

		c = a.mul(b);
		System.out.println(a + " " + b + " " + c);

		c = a.div(b);
		System.out.println(a + " " + b + " " + c);

		System.out.println(a + (a.equals(b) ? "==" : "!=") + b);

	}

}
