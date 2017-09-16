import java.util.Date;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		//You may test that your code works find here
		//Please check that your code works and has no 
		//compilation problems before to submit
		
		StudentGroup obj=new StudentGroup(10);
		Student o1,o2,o3,o4;
		o1=new Student(1,"nishant",new Date(1997,12,1),123);
		o2=new Student(2,"killer",new Date(1976,12,1),22);
		o3=new Student(3,"king",new Date(1234,11,1),123);
		o4=new Student(4,"aa",new Date(1974,12,1),99);
		//obj.addLast(o1);
		//obj.addFirst(o4);
		obj.addLast(o1);
		obj.addLast(o4);
		obj.addLast(o3);
		obj.addLast(o2);
		//obj.remove(0);
		//obj.setStudent(o4,1);
		//Student s[]=obj.getBetweenBirthDates(o3.getBirthDate(),o2.getBirthDate());
		obj.bubbleSort();
		Student s[]=obj.getStudents();
		//System.out.println(s.length);
		//System.out.println(obj.getNextStudent(o2).getId());
		//for(int i=0;i<s.length;i++)
		//	System.out.println(s[i].getId());
		//Student s[]=obj.getStudentsWithMaxAvgMark();
		for(int i=0;i<s.length;i++)
				System.out.println(s[i].getId());
	}

}
