import java.awt.event.MouseAdapter;
import java.util.*;

import javax.lang.model.util.ElementScanner6;

import college.*;

public class Main {

	private static final int MODULE_STUDENT = 0;
	private static final int MODULE_TEACHER = 1;

	static List<Student> student = new ArrayList<Student>();
	static List<Teacher> teacher = new ArrayList<Teacher>();
	static List<Subject> sub = new ArrayList<Subject>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String args[]) {
		Subject subject1 = new Subject();
		Subject hindi = new Subject("hindi", 5, 7);
		Subject maths = new Subject("maths", 6, 10);
		Subject gujarati = new Subject("gujarati", 5, 8);
		Subject english = new Subject("english", 5, 8);
		Subject science = new Subject("science", 5, 8);

		sub.add(hindi);
		sub.add(maths);
		sub.add(gujarati);
		sub.add(english);
		sub.add(science);
		sub.add(subject1);

		

		System.out.println("WELCOME TO KNOXPO");

		while (true) {
			System.out.println("\n ENTER YOUR CHOICE \n [1]STUDENT \n [2]TEACHER \n [3]Exit ");
			int mainChoice = sc.nextInt();
			if (mainChoice == 1) {
				enterModule(MODULE_STUDENT);
			} else if (mainChoice == 2) {
				enterModule(MODULE_TEACHER);
			} else if (mainChoice == 3) {
				break;
			} else {
				System.out.println("sorry wrong input");
			}
		}
		System.out.println("Thank You for using our system");
	}

	public static void addTeacher(){
		System.out.print("enter teacher name: ");
		String name = sc.next();
		System.out.print("enter salary: ");
		double salary = sc.nextDouble();
		Teacher t = new Teacher(name, salary);
		teacher.add(t);
	}
		
	public static void addStudent() {
		System.out.println("enter name");
		String name = sc.next();
		System.out.println("enter cpi");
		double cpi = sc.nextDouble();
		System.out.println("enter fees");
		double fees = sc.nextDouble();
		Student s1 = new Student(name);
		s1.setResult(cpi);
		s1.setFees(fees);
		student.add(s1);
	}

	public static void viewDetails(int moduleType) {
		System.out.println("List of " + ((moduleType == MODULE_STUDENT) ? "Students" : "Teachers"));
		List persons = null;
		if(moduleType == MODULE_STUDENT){
			persons = student;
		}else{
			persons = teacher;
		}
		for (int i = 0; i < persons.size(); i++) {
			Person person = (Person)persons.get(i);
			String name = person.getName();

			if(person instanceof Student){
				Student s = (Student)person;
				double CPI = s.getResult();
				double fees = s.getFees();
				System.out.println("Name :- " + name + " pays amount " + fees + " has cpi " + CPI);
			}else if(person instanceof Teacher){
				Teacher t = (Teacher)person;
				double salary = t.getSalary();
				System.out.println("Name :- " + name + " has Salary:  " + salary );
			}
		}
	}

	public static void addSubjectToPerson(int moduleType) {
		List persons = null;
		String nameType = null;
		if(moduleType == MODULE_STUDENT){
			persons = student;
			nameType = "student";
		}else if(moduleType == MODULE_TEACHER){
			persons = teacher;
			nameType = "teacher";
		}else{
			System.out.println("No such module: "+ moduleType);
			return;
		}

		System.out.println("Enter "+ nameType +" name");
		String personName = sc.next();
		Person foundPerson = null;
		for (int i = 0; i < persons.size(); i++) {
			Person existingPerson = (Person)persons.get(i);
			if (existingPerson.getName().equalsIgnoreCase(personName)) {
				foundPerson = existingPerson;
				break;
			}
		}
		if (foundPerson == null) {
			System.out.println("Sorry no "+nameType+" found with name: " + personName);
			return;
		}
		System.out.println("\n" + personName + " has been selected");
		int c = 0;
		while (c != -99) {
			System.out.println("\n CHOOSE OPERATION FOR " + personName);
			System.out.println("\n  [1] View subjects \n [2] Add Subject \n [3] Go Back");
			int singleStdChoice = sc.nextInt();
			switch (singleStdChoice) {
			case 1:
				//View subjects
				List<Subject> subjects = foundPerson.getAllSubjects();
				for (int j = 0; j < subjects.size(); j++) {
					Subject name = subjects.get(j);
					System.out.println(name);
				}
				break;
			case 2:
				//Add subject
				System.out.println("Which subject would you like to add");
				System.out.println("Subject List:");
				for (int j = 0; j < sub.size(); j++) {

					Subject name = sub.get(j);
					System.out.print(j + ":");
					System.out.println(name);
				}
				int subAddToStd = sc.nextInt();
				try{
					Subject selectedSubject = sub.get(subAddToStd);
					foundPerson.addSubject(selectedSubject);	
				}catch(IndexOutOfBoundsException e){
					System.out.println("Invalid subject index");
				}
				break;
			case 3:
				c = -99;
				break;
			default:
				System.out.println("Sorry wrong input");
			}
		}
	}

	public static void enterModule(int moduleType) {

		if(moduleType == MODULE_STUDENT){
			System.out.println("Welcome to Student Module");
		}else{
			System.out.println("Welcome to Teacher Module");
		}

		int b = 0;
		while (b != -99) {
			System.out.println("\n CHOOSE OPERATION \n [1] Add  \n [2] View details \n [3] Manipulate subject");
			System.out.println("\n [4] Exit  ");
			int stdChoice = sc.nextInt();
			switch (stdChoice) {
			case 1:
				if(moduleType==MODULE_STUDENT){
					addStudent();
				}else if(moduleType == MODULE_TEACHER){
					addTeacher();
				}else{
					System.out.println("Wrong module: "+ moduleType);
				}
				break;
			case 2:
				viewDetails(moduleType);
				break;
			case 3:
				addSubjectToPerson(moduleType);
				break;
			case 4:
				b = -99;
				break;
			default:
				System.out.println("Sorry wrong input");
			}
		}
	}
}