package online_tusur.unit_online_tusur;


import static org.testng.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.testng.annotations.Test;

public class TestMain {
	String fname1="Ivan";
	String fname2="Piter";
	String fname3="Roman";
	String lname1="Sidorov";
	String lname2="Petrov";
	String lname3="Romanov";
	int a1 =33;
	int a2=55;
	int a3=17;
	Student s1 = new Student();
	Student s2 = new Student();
	Student s3 = new Student();
	
	@Test
	
	void testMain() {
	s1.setAge(a1);
	s2.setAge(a2);
	s3.setAge(a3);
	String expectedStudent=fname1+" "+lname1;
	Student[] students = {s1,s2,s3};
	ByteArrayOutputStream output = new ByteArrayOutputStream();
	PrintStream old = System.out;
	System.setOut(new PrintStream(output));
	Main.main(new String[] {});
	assertEquals(expectedStudent+ "\r\n"+ "MAX=" + Student.maxAge(students)+ "\r\n",output.toString());
	System.setOut(old);
	}
	
}
