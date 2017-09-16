import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	
	public StudentGroup(int length) {
		length=0;
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
		
		return students;
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
		if(students==null)
			throw new IllegalArgumentException(); 
		this.students=students;
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length) {
			throw new IllegalArgumentException(); 
		}
		else
			return students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if(student==null ||index<0 || index>=students.length)
			throw new IllegalArgumentException(); 
		else
			students[index]=student;
			
	}

	@Override
	public void addFirst(Student student) {
		if(student ==null)
			throw new IllegalArgumentException();
		else
		{
			//System.out.println("in addfirst else");
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			a.trimToSize();
			a.add(0,student);
			//convert arraylist to array
			students=a.toArray(new Student[a.size()]);
		}
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
		if(student ==null)
			throw new IllegalArgumentException();
		else
		{
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			a.add(student);
			//convert arraylist to array
			students=a.toArray(new Student[a.size()]);
		}
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
		if(  student==null ||index<0 || index>=students.length )
			throw new IllegalArgumentException();
		else
		{
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			a.add(index,student);
			//convert arraylist to array
			students=a.toArray(new Student[a.size()]);
		}
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length) {
			throw new IllegalArgumentException(); 
		}
		else
		{
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			a.remove(index);
			//convert arraylist to array
			students=a.toArray(new Student[a.size()]);
		}
		
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
		if(student ==null)
			throw new IllegalArgumentException();
		else
		{
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			a.remove(student);
			
			students=a.toArray(new Student[a.size()]);
		}
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
				if(index<0 || index>=students.length) {
					throw new IllegalArgumentException(); 
				}
				else
				{
					ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
					
					for(int i=index+1;i<a.size();i++)
					{
						a.remove(i);
					}
				
				students=a.toArray(new Student[a.size()]);
				}
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		
		if(student ==null) {
			throw new IllegalArgumentException(); 
		}
	
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			int index=a.indexOf(student);
			for(int i=index+1;i<a.size();i++)
			{
				a.remove(i);
			}
		
		students=a.toArray(new Student[a.size()]);
		
		
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
		if(index<0 || index>=students.length) {
			throw new IllegalArgumentException(); 
		}
		else
		{
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			int len=a.size()-index;
			for(int i=0;i<index;i++)
			{
				a.remove(i);
			}
		
		students=a.toArray(new Student[len]);
		}
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		if(student ==null) {
			throw new IllegalArgumentException(); 
		}
	
			ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
			int index=a.indexOf(student);
			int len=a.size()-index;
			for(int i=0;i<index;i++)
			{
				a.remove(i);
			}
		
		students=a.toArray(new Student[len]);
		
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		for(int i=0;i<students.length-1;i++)
		{
			for(int j=i+1;j<students.length;j++)
			{
				if(students[i].getFullName().compareTo(students[j].getFullName())==-1)
				{
					Student temp=students[i];
					students[i]=students[j];
					students[j]=temp;
				}
			}
		}
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		// Add your implementation here
		Student res[];
		ArrayList<Student> a=new ArrayList<Student>();
		if(date==null)
			throw new IllegalArgumentException();
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().before(date) || students[i].getBirthDate().equals(date))
			{
				a.add(students[i]);
			}
		}
		res=a.toArray(new Student[a.size()]);
		return res;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
		if(firstDate==null ||lastDate==null)
			throw new IllegalArgumentException();
		Student res[];
		ArrayList<Student> a=new ArrayList<Student>();
		for(int i=0;i<students.length;i++)
		{
			if(students[i].getBirthDate().after(firstDate) || students[i].getBirthDate().before(lastDate))
			{
				a.add(students[i]);
			}
		}
		res=a.toArray(new Student[a.size()]);
		return res;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		Student s=students[indexOfStudent];
		Date d=s.getBirthDate();
		return 2017-d.getYear();
		
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		ArrayList<Student> a=new ArrayList<Student>();
		for(int i=0;i<students.length;i++)
		{
			if(2017-students[i].getBirthDate().getYear()==age)
			{
				a.add(students[i]);
			}
		}
		return a.toArray(new Student[a.size()]);
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
		ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
		Double max=-1.0;
		for(int i=0;i<a.size();i++)
		{
			if(a.get(i).getAvgMark()>max)
				max=a.get(i).getAvgMark();
			
		}
		ArrayList<Student> b=new ArrayList<Student>();
		for(int i=0;i<a.size();i++)
			if(a.get(i).getAvgMark()==max)
				b.add(a.get(i));
		return b.toArray(new Student[b.size()]);
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
		// Add your implementation here
		if(student ==null) {
			throw new IllegalArgumentException();}
		ArrayList<Student> a=new ArrayList<Student>(Arrays.asList(students));
		Student ss= a.get(a.indexOf(student)+1);
		return ss;
	}
	}
