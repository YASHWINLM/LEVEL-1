
public class athlete {
String name;
int speed;
int bibnumber;
static int count;
static String location ="New York City";
static String startTime="9:00 am";

athlete(String name,int speed){
	this.name=name;
	this.speed=speed;
	count++;
	this.bibnumber=count;
}
public static void main(String[] args) {
	athlete john= new athlete("John",10);
	athlete sarah= new athlete("Sarah",11);
	System.out.println(sarah.name + " 's bib number is " + sarah.bibnumber);
	System.out.println("Total number of athletes is " + count);
	location ="San Diego";
	System.out.println(john.name + " is running " + john.location);
	john.location="Chicago";
	System.out.println(sarah.name + " is running " + sarah.location);
	
	
}
}
