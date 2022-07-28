import java.util.InputMismatchException;
import java.util.PriorityQueue;
import java.util.Scanner;
class Patient implements Comparable<Patient>{ // implemented the Comparable interface for the PriorityQueue!
	//attributes
		private String name;
		private int order;		//order of arrival
		private int emergency; //1 is normal, 5 is life-and-death situation

		//constructor
		public Patient(int order, String name, int priority) {
			this.order = order;
			this.name = name;
			this.emergency = priority;
		}

		//getters and setters
		public int getOrder() {
			return order;
		}
		public void setOrder(int order) {
			this.order = order;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}

		public int getEmergency() {
			return emergency;
		}

		public void setEmergency(int emergency) {
			this.emergency = emergency;
		}

		public String toString() {
			return name;
		}

		public int compareTo(Patient o) { // The compare to order the list to most emergency case to least
			if(this.getEmergency() > o.getEmergency()) {
				return -1;
			}else if(this.getEmergency() < o.getEmergency()) {
				return 1;
			}else {
				return this.order - o.order;
			}
		}
	}

public class PatientManager   {

	public static void start() { // the start method that runs the program
			PriorityQueue <Patient> waitingList = new PriorityQueue<>(); // created a Priority Queue
			Scanner sc = new Scanner(System.in);
			System.out.println("---------------");
			System.out.println("(1) New Patient. ");
			System.out.println("(2) Next Patient. ");
			System.out.println("(3) Waiting List. ");
			System.out.println("(4) Exit. ");
			System.out.println("---------------");
			Boolean boo = true;
			
			while(boo==true) {
				try {
				System.out.println("*Choose an item from the menu.");
				int choice = sc.nextInt();
				if(choice == 1) { 
				Boolean x = true;
				
					int count = 0;
					System.out.print("----- Enter patient's name: ");
					String name = sc.next();
					System.out.print("----- Enter emergency [1 (low) to 5 (life-and-death)]: ");
					
					while(x==true) {
						try {
							int eme = sc.nextInt();							
							if(eme <= 5) {
								waitingList.offer(new Patient(count, name, eme));
								count++;
								System.out.println("----- Patient added to the waiting list!");
								x=false;
							}else {
								System.out.println("----- Wrong value try again: ");
							}
						}catch(Exception e) {
							System.out.print("----- Wrong value try again: ");
							sc.nextLine();
						}
					}
				}
			
				else if(choice == 2) { 
						try {
						System.out.println("-" + waitingList.poll().getName() + " is treated.");
						}catch(Exception e) {
							System.out.println("-No more patients.");
						}
					}
				else if(choice == 3) {
						PriorityQueue<Patient> list = new PriorityQueue<>(waitingList);
						if(!list.isEmpty()) {
						System.out.println("----- Waiting list includes:");
						while(!list.isEmpty()) {
							System.out.println("      - " + list.poll());
						}
						}else {
							System.out.println("----- No patients in the list.");
						}
					}
				else if(choice == 4) {
						System.out.println("Program terminated. Good bye! :)");
						boo = false;
				}else {
					System.out.println("Error, wrong choice :(");
				}
			}catch(Exception e) {
				System.out.println("Error, wrong choice :(");
				sc.nextLine();
				
			
			}
			
			}
			
	
	}
	public static void main(String[] args) {
		start();
	}
	}



	