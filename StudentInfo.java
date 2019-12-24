package StudentPlacementToUniversity;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class StudentInfo {

	class Student {
		// fields (variables in a class)
		private int stuId;
		private String firstName;
		private String lastName;

		// Constructor method, Declaration of Class

		public Student() {
		}

		// Setters and getters methods

		public void setSId(int sId) {
			this.stuId = sId;
		}

		public int getSId() {
			return stuId;
		}

		public void setFnm(String fName) {
			this.firstName = fName;
		}

		public String getFnm() {
			return firstName;
		}

		public void setLnm(String lName) {
			this.lastName = lName;
		}

		public String getLnm() {
			return lastName;
		}

	}

	public static void main(String[] args) {
		
		List<Student> students = new ArrayList<Student>();

		Scanner uin = new Scanner(System.in);

		int i = 0;
		boolean newRecord = true;

		do {
			try {
				
			System.out.println("===Input Students Details===");
			//System.out.println("***************************");
			Student student = new StudentInfo().new Student(); // since I have created a nested class i need to call
																// outer class fir
			student.setSId(i + 1);

			System.out.println("Enter " + "\"First Name\""+ " for Student iD: "+ student.getSId() );
			student.setFnm(uin.nextLine());
			System.out.println("Enter " + "\"Last Name\""+ " for Student iD: "+ student.getSId() );
			student.setLnm(uin.nextLine().toUpperCase());

			students.add(student);
			} catch(InputMismatchException ime) {
				
			}
			
			

			System.out.print("Would you like to enter more data?(y/n)");
			String askNew = uin.nextLine();
			newRecord = (askNew.toLowerCase().equals("y")) ? true : false;

			i++;

		} while (newRecord == true);
		System.out.println("===Entered Students Details===");
		students.forEach(user -> {
			System.out.println(
					"Student Id: " + user.getSId() + 
					"   Full Name : " + user.getFnm() +" "+ user.getLnm() );
		});

		uin.close();

	}

}
