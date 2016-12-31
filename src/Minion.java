
public class Minion {
	
			int eyes; 
	 		 String color; 
	 		 String master;
	 		 String name;
	 		 Minion(String name, int eyes, String color, String master){
	 			 this.eyes=eyes;
	 			 this.color=color;
	 			 this.master=master;
	 			 this.name=name;
	 		 }
	 		public String getName(){
	 			return this. name;
	 		}
	 		public int getEyes(){
	 			return this. eyes;
	 		}
	 		public String getColor(){
	 			return this. color;
	 		}
	 		public String getMaster(){
	 			return this. master;
	 		}
	 	public void setname(String name){
	 	 this.name=name;
	 	}
	 	public void setMaster(String master){
		 	 this.master=master;
		 	}
}
