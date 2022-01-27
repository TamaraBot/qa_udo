package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicContainer.dynamicContainer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicNode;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

class DynamicTestPrimer {

	Student s1 = new Student();
	Student s2 = new Student();
	
	@TestFactory
	@Tag("negative")
	Collection <DynamicTest> dynamicTest1(){
		
		s1.setAge(25);
		s2.setAge(50);
		
		return Arrays.asList(
				DynamicTest.dynamicTest("dTest1", ()-> assertEquals(25,s1.getAge())),
				DynamicTest.dynamicTest("dTest2", ()-> assertEquals(50,s2.getAge()))
				);
	}
	//пример динамического теста
	@TestFactory
	@Tag("negative")
	Stream<DynamicTest> dynamicTestsGetters() {

	    Student[] studentsObjects = {new Student("Sergey", "Nasedkin", 49), new Student("Ivan", "Nesterov", 38), new Student("Gleb", "Petrov", 18)};

	    String[] firstNameTest = {"Sergey", "Ivan", "Gleb"};
	    String[] lastNameTest = {"Nasedkin", "Nesterov", "Petrov"};
	    Integer[] ageTest = {49, 38, 18};

	    List<DynamicTest> dynamicTests = new ArrayList<>();

	    for (int i = 0; i < studentsObjects.length; i++) {
	        int k = i;
	        DynamicTest dynamicTestFirstName = DynamicTest.dynamicTest("DynamicTest getFirstName(" + firstNameTest[k] + ")", 
	        		() -> {assertEquals(firstNameTest[k], studentsObjects[k].getFirstName());
	        });
	        DynamicTest dynamicTestLastName = DynamicTest.dynamicTest("DynamicTest getLastName(" + lastNameTest[k] + ")", () -> {
	            assertEquals(lastNameTest[k], studentsObjects[k].getLastName());
	        });
	        DynamicTest dynamicTestAge = DynamicTest.dynamicTest("DynamicTest getAge(" + ageTest[k] + ")", () -> {
	            assertEquals(ageTest[k], studentsObjects[k].getAge());
	        });

	        dynamicTests.add(dynamicTestFirstName);
	        dynamicTests.add(dynamicTestLastName);
	        dynamicTests.add(dynamicTestAge);

	    }

	    return dynamicTests.stream();
	}
	//пример с контейнерами
	@TestFactory
	Stream<DynamicNode> testGettersNameandAge() {
	 List<Student> n = new ArrayList<Student>();
	  n.add(new Student("Mark", "Petrov", 19));
	  n.add(new Student("Ivan", "Nikulin", 18));
	  n.add(new Student("Artur-Alex", "Sidorov", 40));
	  n.add(new Student("Serg", "Moroz", 25));
	 
	  
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
