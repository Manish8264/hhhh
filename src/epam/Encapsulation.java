package epam;

public class Encapsulation {
	
	private double balance;
	
	Encapsulation(double balance){
		this.balance= balance;
	}
	
	public double getBalance() {       //getter method
		return this.balance;
	}
	
	public void setBalance(double balance) {      //setter method
		this.balance=balance;
	}
	
	public static void main(String[] args) {
		Encapsulation c1= new Encapsulation(2500);
		System.out.println(c1.balance);
		c1.setBalance(15000);
		System.out.println(c1.getBalance());
	}

}
