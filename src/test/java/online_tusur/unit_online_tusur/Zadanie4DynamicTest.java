package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.function.Executable;

class Zadanie4DynamicTest {

	//Тесты негативные для  возраста, имени, фамилии
	@TestFactory
	@Tag("negative")
	Collection<DynamicTest> dynamicTestStudents() {
		//создаем список студентов s
	
	ArrayList<Student> s = new ArrayList<Student>();
	//добавляем в список студентов, вызывая конструктор класса Student
	s.add(new Student("Aleksey", "Morozov", 50));
	s.add(new Student("Tamara", "pavlova", 34));
	s.add(new Student("OLEG", "Titov", 18));

	List<Integer> exp = Arrays.asList(50,34,18);
	List<String> exp1 = Arrays.asList("Aleksey","Tamara","Oleg");
	List<String> exp2 = Arrays.asList("Morozov","Pavlova","Titov");

	// Массив для значений, которые ожидаем
	ArrayList<DynamicTest> res = new ArrayList<>(); //для возраста
	ArrayList<DynamicTest> res1 = new ArrayList<>(); // для имени
	ArrayList<DynamicTest> res2 = new ArrayList<>();//для возраста
	
	for (int i = 0; i < s.size(); i++) {

	String firstName;
	String lastName;
	int x,y;
	String z,q;
	//создаем списки имени, фамилии, возраста, которые должны получит геттером
	x = s.get(i).getAge();
	firstName=s.get(i).getFirstName();
	lastName=s.get(i).getLastName();

	//переменные для ожидаемых
	y=exp.get(i);
	z=exp1.get(i);
	q=exp2.get(i);
	
	@SuppressWarnings("unused")
	Executable exec = () -> assertEquals(x, y);
	Executable exec1 = () -> assertEquals(firstName, z);
	Executable exec2 = () -> assertEquals(lastName, q);
	
	
	DynamicTest dTest = dynamicTest("test"+i+"{"+firstName+", "+lastName+", "+x+"}",
	() ->{assertEquals(y,x);});
	
	res.add(dTest);
	
	for (int i1 = 0; i1 < s.size(); i1++) {
	DynamicTest dTest1 = dynamicTest("test"+i1+"{"+firstName+", "+lastName+", "+x+"}",
			() ->{assertEquals(z,firstName);});
	
			res1.add(dTest1);
	}		
	for (int i2 = 0; i2 < s.size(); i2++) {
	DynamicTest dTest2 = dynamicTest("test"+i2+"{"+firstName+", "+lastName+", "+x+"}",
			() ->{assertEquals(q,lastName);});
			res2.add(dTest2);
			}
	}
	return res;
	}
	
	
			@TestFactory
		Stream<DynamicNode> TestWithConteiner() {
		 List<Student> n = new ArrayList<Student>();
		  n.add(new Student("Petr", "Sidorov", 17));
		  n.add(new Student("Pavel", "Chizhov", 60));
		  n.add(new Student("Gleb", "SHVARZ", 50));
		  n.add(new Student("Mikhail", "Saltykov-Shchedrin", 31));
		 
		  
		  List<DynamicNode> res = new ArrayList<>();
		  List<DynamicTest> res1 = new ArrayList<>();
		  List<DynamicTest> res2 = new ArrayList<>(); 
		  List<DynamicTest> res3 = new ArrayList<>(); 
		  
		  
		  
		  for(int i=0; i < n.size(); i++) {
		      
		      String FirstName = n.get(i).getFirstName();
		      
		 
		      res1.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(FirstName.length() >= 0);}));
		 
		      }
		  res.add(dynamicContainer("Names",res1.stream()));
		  
		  for(int i=0; i < n.size(); i++) {
		     
		      String LastName = n.get(i).getLastName();
		  
		      res2.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(!LastName.isEmpty());}));
		 
		      }
		  res.add(dynamicContainer("Surnames",res2.stream()));
		  
		  for(int i=0; i < n.size(); i++) {
		         
		      int age = n.get(i).getAge();
		       
		      res3.add(DynamicTest.dynamicTest("test"+i, () -> {assertTrue(age >= 18 && age <= 50);}));
		 
		      }
		  res.add(dynamicContainer("Age",res3.stream()));
		 
		  return res.stream();
		  	
		}


	}

