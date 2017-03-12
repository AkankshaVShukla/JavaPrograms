
public class TestInterface {
		  public static void main(String[] args) { 
		     Object  car1 = new SmallCar(); 
		     SmallCar  car2 = new Coupe(); 
		      Car car3 = new Coupe(); 
		     Object  car4 = new Sedan(); 
		    ((SmallCar) car1).printDescription(car1); 
		   ((SmallCar) car2).printDescription( car2 ); 
		   ((SmallCar) car2).printDescription( car3 ); 
		    ((Sedan) car4).printDescription(car4); 
		    ((Sedan) car4).printDescription((Car ) car4); 
		   ( car2 ).printDescription(( SmallCar ) car4); 
		  } 
		
}
interface Car{ 
	  String name = "Car"; 
	  void printDescription(Object object); 
	} 

	class SmallCar implements Car{ 
	  public void printDescription(Object object) { 
	    System.out.println("This is an object"); 
	  } 
	  public void printDescription(Car object) { 
	    System.out.println("This is a Car object"); 
	  } 
	  public void printDescription(SmallCar object) { 
	    System.out.println("This is a Small Car object"); 
	  } 
	} 

	class Coupe extends SmallCar{ 
	  public void printDescription(Car object) { 
	    System.out.println("This is a Coupe Car object"); 
	  } 
	  public void printDescription(SmallCar object) { 
	    System.out.println("This is a Coupe SmallCar object"); 
	  } 
	  public void printDescription(Coupe object) { 
	    System.out.println("This is a Coupe object"); 
	  } 
	} 

	class Sedan extends SmallCar{ 
	  public void printDescription(Car object) { 
	    System.out.println("This is a Sedan Car object"); 
	  } 
	  public void printDescription(SmallCar object) { 
	    System.out.println("This is a Sedan Small Car object"); 
	  } 
	  public void printDescription(Sedan object) { 
	    System.out.println("This is a Sedan object"); 
	  } 
	} 
