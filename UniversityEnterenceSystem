package StudentPlacementToUniversity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UniEntrSys3 {
static String div = "-------------------------------------";
static String ddiv = "=====================================";
	
	public static void main(String[] args) {
		
//Universities--------------------------------------------------------------------------------------------
		String university[][] = { { "Oxford University", "OXF" }, 
								  { "Cambridge University", "CAM" },
								  { "London University", "LON" } 
								};

		int univCount = university.length;
		int[] univCapacity = new int[univCount];

		Scanner in = new Scanner(System.in);
		for (int i = 0; i < univCount; i++) {

			System.out.println("Please enter " + "\"" + university[i][0] + "\"" + " capacity: ");

			try {
				univCapacity[i] = in.nextInt();
				if (univCapacity[i] > 0) {
					continue;
				} else {
					System.out.println("Not a valid Capacity ! Try Again. ");
					i--;
				}
			}catch (InputMismatchException ime) {
				System.out.println("Not a valid Capacity ! Try Again. ");
				in.nextLine();
				i--;
			}
		}
		
//Exam-----------------------------------------------------------------------------------------			
		in.nextLine();
		

//		System.out.println("Enter quantitative answers key");
//		String qttk = in.nextLine().toUpperCase();
//		System.out.println("Enter verbal answers key ");
//		String vrbk = in.nextLine().toUpperCase();
		
		String qttk = "ABCDBAEDDACDBEDCABDEDACADEDBAB";
		String vrbk = "BCDABCAEBBADCCAEBADCBADBCADBBE";	
		String AnsKey = qttk.concat(vrbk);
				
//Students-----------------------------------------------------------------------------------------	
		System.out.println("\n\n"+ div);
		System.out.println("\tInput Students Details");
		System.out.println(div);
		List<Student> students = new ArrayList<Student>();
		int i = 0;
		boolean addStu = true;
		do {
			Student student = new UniEntrSys3().new Student();
			student.setSId(i + 1);

			System.out.println("Enter " + "\"First Name\"" + " for Student iD: " + student.getSId());
			student.setFnm(in.nextLine().toUpperCase());
			System.out.println("Enter " + "\"Last Name\"" + " for Student iD: " + student.getSId());
			student.setLnm(in.nextLine().toUpperCase());

			System.out.println("Enter " + "\"Quantitative Answers\"" + " for Student iD: " + student.getSId());
			String qtt = in.nextLine().toUpperCase();
			System.out.println("Enter " + "\"Verbal Answers\"" + " for Student iD: " + student.getSId());
			String vrb = in.nextLine().toUpperCase();
			String stuAns = qtt.concat(vrb);

			System.out.println("University choices" + " for Student iD:" + student.getSId());
			System.out.println("!Enter 3 Letter University Codes!");
			
			System.out.println("\nUniversity Name  \t|\tCode");
			System.out.println(ddiv);
			for (int j = 0; j < univCount; j++) {
				System.out.println(university[j][0] + " : " + "\t|\t" + university[j][1]);
				System.out.println(div);
			}

			String[] uniPrefs = new String[3];
			System.out.println("1st Choise: ");
			uniPrefs[0] = in.nextLine().toUpperCase();
			System.out.println("2nd Choise: ");
			uniPrefs[1] = in.nextLine().toUpperCase();
			System.out.println("3rd Choise: ");
			uniPrefs[2] = in.nextLine().toUpperCase();
			student.setUniPref(uniPrefs);
			
			student.setScore(calcQttScore(AnsKey, stuAns));
			
			students.add(student);

			System.out.print("Add more Student?(y/n)");
			String askNew = in.nextLine();
			addStu = (askNew.toLowerCase().equals("y")) ? true : false;

			i++;

		} while (addStu == true);
				
		System.out.println("Entered Students Details");
		System.out.printf(div+div+"\n");
		
// Sort Student objects for multiple fields using "comparator"; below is a lambda expression for comparator.
// Collection sort of java uses merge sort algorithm for objects
		
		Collections.sort(students, Comparator.comparing(Student::getScore).reversed()
	            .thenComparing(Student::getFnm));
		
		
		System.out.printf("%-5s %-33s%-15s%-7s%-7s%-7s\n", "Id", "| Name", "| Qtt. Score", "| 1st" , "| 2nd", "| 3rd");
		System.out.printf(ddiv+ddiv+"\n");
		students.forEach(student -> {
				
		System.out.printf("%-5s %-33s%-15s%-7s%-7s%-7s\n", 
				student.getSId(), 
				"| "+ student.getFnm()+ " "+ student.getLnm(), 
				"| "+ student.getScore(), 
				"| "+ student.getUniPref()[0], 
				"| "+ student.getUniPref()[1], 
				"| "+ student.getUniPref()[2]);
		System.out.printf(div+div+"\n");
		});

		in.close();
	}

//Methods -----------------------------------------
	
	public static int checkAns(String key, String answer) {
		int correctA = 0; 
		for (int i = 0; i < key.length(); i++) {
			if (answer.charAt(i) == key.charAt(i)) {
				correctA++;
			} else {
				continue;
			}
		}
		return correctA;
	
	}
	
	public static int calcQttScore(String key, String answer) {
		int matPt, sciPt, engPt, socPt;
			
		matPt = 3 * checkAns(key.substring(0, 20), answer.substring(0, 20));
		sciPt = 3 * checkAns(key.substring(20, 30), answer.substring(20, 30));
		engPt = 2 * checkAns(key.substring(30, 50), answer.substring(30, 50));
		socPt = 1 * checkAns(key.substring(50, 60), answer.substring(50, 60));
		return matPt + sciPt + engPt + socPt;
	
	}

	
	class Student {
		// fields (variables in a class)
		private int stuId;
		private String firstName;
		private String lastName;
		private String[] uniPref;
		private int score;
		
		// Constructor method, Declaration of Class

		public Student() {
		}

		// Setters and getters methods

		public int getSId() {
			return stuId;
		}

		public void setSId(int sId) {
			this.stuId = sId;
		}

		public String getFnm() {
			return firstName;
		}

		public void setFnm(String fName) {
			this.firstName = fName;
		}

		public String getLnm() {
			return lastName;
		}

		public void setLnm(String lName) {
			this.lastName = lName;
		}
		
		public String[] getUniPref() {
			return uniPref;
		}

		public void setUniPref(String[] uniPref) {
			this.uniPref = uniPref;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}
	
	}

}
