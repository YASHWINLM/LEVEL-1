
public class guy {
	private String name;
	private int money=10;
	
	guy(String name){
		this.name=name;
	}
	public void walletSwype(){
		System.out.println("Credit card number:4444444444444444");
		System.out.println("Social Security Number:1010001");
		
	}
	public void mug(){
		System.out.println("Please don't hurt me I only " + money + " $");
	}
	public static void main(String[] args) {
		guy guy= new guy("bill");
		guy.mug();
		guy.walletSwype();
	}
}
