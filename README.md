# Solid


Solid Principle :
---------------

1. Single Responsiblity Principle :
-----------------------------------

A class should have only one reason to change, meaning it should have only one job or resposibility.

Violates output :
---------------

    Salary .... : 6000.0
    Generating Employee Report ....
	

Violation :
-----------

		/**
		 * Without SingleResponsibility Principle
		 * This class violates SRP because it handles both salary calculation and report generation.
		 */
		// Violates SRP: This class has multiple responsibilities (salary calculation & report generation)
		
		class Employee {
			private String name;
			private double salary;

			public Employee(String name, double salary) {
				this.name = name;
				this.salary = salary;
			}

			public double calculateSalary() {
				return salary * 1.2; // Example salary calculation
			}

			public void generateReport() {
				System.out.println("Generating employee report...");
			}
		}

		public class SRPViolation {
			public static void main(String[] args) {
				Employee emp = new Employee("John", 50000);
				System.out.println("Salary: " + emp.calculateSalary());
				emp.generateReport();
			}
		}
		
Without Violation :
-----------------


		package SingleResponsibilityWithoutViolation;

		// Now, each class has a single responsibility

		// Employee details class
		class Employee {

			private String name;

			private double salary;

			public String getName() {
				return name;
			}

			public double getSalary() {
				return salary;
			}

			public Employee(String name, double salary) {
				this.name = name;
				this.salary = salary;
			}
		}

		// Responsible only for salary calculation
		class SalaryCalculator {
			public double calculateSalary(Employee employee) {
				return employee.getSalary() * 1.2;
			}
		}

		// Responsible only for report generation
		class ReportGenerator {
			public void generateReport(Employee employee) {
				System.out.println("Generating employee report for " + employee.getName() + "...");
			}
		}

		public class SRPExample {
			public static void main(String[] args) {
				Employee emp = new Employee("John", 10000);
				SalaryCalculator calculator = new SalaryCalculator();
				ReportGenerator reportGenerator = new ReportGenerator();

				reportGenerator.generateReport(emp);
				System.out.println("Salary: " + calculator.calculateSalary(emp));

			}
		}
		
		
-------------------------------------------------------------------------------------------------------------------------------------


2. Open/Closed Principle :
-------------------------

Software entities should be open for extension but closed for modification. This allows adding new functionality without altering existing code.

Violates output :
---------------

    Circle Area: 78.53981633974483

Violation :
---------
			package dowlath.io.solid.openclosed;

			// Violates OCP: Every time a new shape is added, we need to modify the existing class.

			class AreaCalculator_1{
				public double calculateArea(String shape, double radius, double length,double breadth){
					if(shape.equals("circle")){
						return Math.PI * radius * radius;
					} else if(shape.equals("rectangle")){
						return length * breadth;
					}
					return 0;
				}
			}
			public class OCP_Violation {
				public static void main(String[] args) {
					AreaCalculator_1 calculator = new AreaCalculator_1();
					System.out.println("Circle Area: " + calculator.calculateArea("circle", 5, 0, 0));
				}
			}


Without Violation :
-----------------
		
		package dowlath.io.solid.openclosed;

		interface Shape{
			double calculateArea();
		}

		class Circle implements Shape{
			private double radius;

			public Circle(double radius){
				this.radius = radius;
			}

			@Override
			public double calculateArea() {
				return Math.PI * radius * radius;
			}
		}

		class Rectangle implements Shape{
			private double length,breadth;

			public Rectangle(double length,double breadth){
				this.length = length;
				this.breadth = breadth;
			}

			@Override
			public double calculateArea() {
				return length * breadth;
			}
		}

		class AreaCalculator{
			public double calculateArea(Shape shape){
				return shape.calculateArea();
			}
		}

		public class OCP_WithOutViolation {
			public static void main(String[] args) {
				Shape circle = new Circle(5);
				Shape rectangle = new Rectangle(4,6);
				AreaCalculator calculator = new AreaCalculator();

				System.out.println("Circle Area : "+ calculator.calculateArea(circle));
				System.out.println("Rectangle Area : "+ calculator.calculateArea(rectangle));
			}
		}


----------------------------------------------------------------------------------------------------------------

3. Liskov Substitution Principle :
--------------------------------

Objects of superclass should be replaceable with objects of a subclass without affecting  the correctness of the program.


Violates output :
---------------

    Sparrow can fly....
    Exception in thread "main" java.lang.UnsupportedOperationException: Penguin can not fly....
    	at dowlath.io.solid.liskov.Penguin_1.fly(Liskov_Violation.java:19)
    	at dowlath.io.solid.liskov.Liskov_Violation.main(Liskov_Violation.java:28)
	
	
With Violation :
---------------

			package dowlath.io.solid.liskov;

			class Bird_1{
				public void fly(){
					System.out.println("Flying......");
				}
			}

			class Sparrow_1 extends Bird_1{
				@Override
				public void fly(){
					System.out.println("Sparrow can fly....");
				}
			}

			class Penguin_1 extends Bird_1{
				@Override
				public void fly(){
					throw new UnsupportedOperationException("Penguin can not fly....");
				}
			}
			public class Liskov_Violation {
				public static void main(String[] args) {
					Bird_1 penguin = new Penguin_1();
					Bird_1 sparrow = new Sparrow_1();

					sparrow.fly();
					penguin.fly(); // This will break at runtime.
				}
			}




Without Violation :
-----------------


			package dowlath.io.solid.liskov;

			abstract class Bird{
				abstract void makeSound();
			}

			interface FlyingBird{
				void fly();
			}

			class Sparrow extends Bird implements FlyingBird{

				@Override
				void makeSound() {
					System.out.println("Chirp Chirp !!!......");
				}

				@Override
				public void fly() {
					System.out.println("Sparrow is flying .....!!!");
				}
			}

			class Penguin extends Bird{

				@Override
				void makeSound() {
					System.out.println("Kee...Kee...!!!");
				}
			}
			public class Liskov_WithOutViolation {
				public static void main(String[] args) {
					Bird sparrow = new Sparrow();
					Bird penguin = new Penguin();

					sparrow.makeSound();
					penguin.makeSound();

					FlyingBird flyingBird = new Sparrow();
					flyingBird.fly();
				}
			}


-------------------------------------------------------------------------------------------------------------------------------------------

4. Interface Segregation Principle :
----------------------------------

Clients should not be forced to depend on interfaces they do not use.It encourages smaller, more specific interfaces.

Violates output :
---------------

    Human working....
    Human eating....
    Robot working.....
    Exception in thread "main" java.lang.UnsupportedOperationException: Robots do not eat.....!!! This operation not supported....!!!
    	at dowlath.io.solid.interfacesegregation.Robot_1.eat(InterfaceSegregation_Violation.java:31)
    	at dowlath.io.solid.interfacesegregation.InterfaceSegregation_Violation.main(InterfaceSegregation_Violation.java:42)

Violation :
----------

		package dowlath.io.solid.interfacesegregation;

		interface Worker_1{
			 void work();
			 void eat();
		}

		class Human_1 implements Worker_1{

			@Override
			public void work() {
				System.out.println("Human working....");
			}

			@Override
			public void eat() {
				System.out.println("Human eating....");
			}
		}

		class Robot_1 implements Worker_1{

			@Override
			public void work() {
				System.out.println("Robot working.....");
			}

			@Override
			public void eat() {
				// This is not right way of handling.
				throw new UnsupportedOperationException("Robots do not eat.....!!! This operation not supported....!!!");
			}
		}
		public class InterfaceSegregation_Violation {
			public static void main(String[] args) {
				Human_1  human_1 = new Human_1();
				human_1.work();
				human_1.eat();

				Robot_1 robot_1 = new Robot_1();
				robot_1.work();
				robot_1.eat();;
			}
		}

Without Violation :
-----------------

		package dowlath.io.solid.interfacesegregation;

		interface Worker{
			void work();
		}

		interface Eatable{
			void eat();
		}

		class Human implements Worker,Eatable{

			@Override
			public void work() {
				System.out.println("Developer is coding.....");
			}

			@Override
			public void eat() {
				System.out.println("Developer is eating....");
			}
		}

		class Robot implements Worker{

			@Override
			public void work() {
				System.out.println("Robot is working.....");
			}
		}
		public class InterfaceSegregation_WithOutViolation {
			public static void main(String[] args) {
				Human human = new Human();
				human.work();
				human.eat();

				Robot robot = new Robot();
				robot.work();

			}
		}

-----------------------------------------------------------------------------------------------------------------------------------------

5. Dependency Inversion Principle :
---------------------------------

High-level modules should not depend on low-level modules.Both should depend on abstractions, not concrete implementations.

Violates Output :
---------------
    Wired keyboard connected


With Violation :
-----------------

		package dowlath.io.solid.dependency_inversion;

		class WiredKeyboard_1{
			public void connect(){
				System.out.println("Wired keyboard connected");
			}
		}

		//Violates DIP : Computer is tightly coupled to WiredKeyboard.

		class Computer_1{
			private WiredKeyboard_1 keyboard = new WiredKeyboard_1(); // Tightly coupling.

			public void start(){
				keyboard.connect();
			}
		}

		public class Dependency_Inversion_Violation {
			public static void main(String[] args) {
			 Computer_1 pc = new Computer_1();
			 pc.start();
			}

		}




Without Violation :
-----------------

		package dowlath.io.solid.dependency_inversion;

		import java.security.Key;

		interface Keyboard{
			void connect();
		}
		class WiredKeyboard implements  Keyboard{
			public void connect(){
				System.out.println("Wired keyboard connected");
			}
		}
		class WirelessKeyboard implements Keyboard{

			@Override
			public void connect() {
				System.out.println("Wireless keyboard connected");
			}
		}

		class Computer{
			private Keyboard keyboard;
			
			public Computer(Keyboard keyboard){
				this.keyboard = keyboard;
			}
			
			public void start(){
				keyboard.connect();
			}
		}


		public class Dependency_Inversion_WithOut_Violation {
			public static void main(String[] args) {
				Keyboard wired = new WiredKeyboard();
				Computer pc1 = new Computer(wired);
				pc1.start();

				Keyboard wireless = new WirelessKeyboard();
				Computer pc2 = new Computer(wireless);
				pc2.start();
			}
		}
