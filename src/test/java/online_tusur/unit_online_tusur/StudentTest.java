package online_tusur.unit_online_tusur;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;


public class StudentTest {
	/*объект тестового класса  Student*/
	private Student s = new Student();	 	   

	    
//проверка возраста студента, входящий в диапазон
	  @Test
	  @Tag("positive")
	  void testAge_1() {
		int age = 30;
		s.setAge(age);
	    int expectedAge = 30;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);	

	  }
	 
	 //позитивный тест на возраст (граничное значение 50)
	 @Test
	  @Tag("positive")
	  void testAge_2() {
		int age = 50;
		s.setAge(age);
	    int expectedAge = 50;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);	
	  }
	 
	 //позитивный тест на возраст (граничное значение 18)
	 @Test
	  @Tag("positive")
	  void testAge_3() {
		int age = 18;
		s.setAge(age);
	    int expectedAge = 18;
	    int actualsAge=s.getAge();
	    assertEquals(expectedAge, actualsAge);	
	  }
	
	 
	 //негативный тест на написание фамилии с маленькой буквы
	 @Test
	 @Tag("negative")
	 void testLastNameInvalid() {
		 String fio = "petrov";
		 s.setLastName(fio);
		 String expectedName= "Petrov";
		 String actualsName = s.getLastName();
		 assertEquals(expectedName, actualsName); 	 
	 }

	  //негативный тест на возрат студента, выходящего за диапазон
	 @Test
	 @Tag("negative")
	 void testAgeInvalid() {
		 int age = - 17;
		 s.setAge(age);
		 int expectedAge=18;
		 int actualAge = s.getAge();
		 assertEquals(expectedAge, actualAge); 	 
	 }
	 
	 
	 //негативный тест на ввод имени всеми прописными буквами
	 @Test
	 @Tag("negative")
	 void testNameInvalid() {
		 String name = "IVAN";
		 s.setFirstName(name);
		 String expectedName= "Ivan";
		 String actualsName = s.getFirstName();
		 assertEquals(expectedName, actualsName); 	 
	 }

	 
	 
	 

}