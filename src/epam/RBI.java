package epam;

public class RBI {
	
	public void interest(int a) {
		System.out.println("The interest is  0 ");
		
	}
	
}

class SBI extends RBI{
	public void interest(int a) {
		System.out.println("The interest is");
		
	}
	
	public static void main(String[] args) {
		SBI sbi=new SBI();
		sbi.interest(4);
	}
}
