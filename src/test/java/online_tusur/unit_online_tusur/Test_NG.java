package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;
import static org.testng.Assert.assertTrue;

import java.util.ArrayList;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test_NG {

	private Student s = new Student();
	
	@SuppressWarnings("unused")
	private ArrayList<Student> emp;

		@BeforeTest
		private void setUp() {
			emp = new ArrayList<Student>();
		}
	
		@AfterTest
		private void tearDown() {
			emp.clear();
		}
	
	//Тест для сравнения заданных и полученных значений возраста, а также сравнения среднего возраста с нулем
	@Test (threadPoolSize=5)
	@Parameters({"a", "d"})

		void TestNG_SetAvg(@Optional("50") int a, @Optional("18") int d) {
			int param =  a;
			s.setAge(param);
			long id=Thread.currentThread().getId();
		    System.out.println("thread=" +id);
		    			assertEquals(s.getAge(),d);

		}
	@DataProvider (name = "data", parallel=true)
	public static Object[][] getAge() {
		return new Object[][]{{0,18}, {18,18}, {50,50}, {25,25}};
	}
	
	@SuppressWarnings("static-access")
	@Test (dataProvider = "data")
	void TestAge(int input, int expected) {
		s.setAge(input);
		int actualAge = s.getAge();
		Student[] array = {s};
		long id=Thread.currentThread().getId();
	    System.out.println("thread=" +id);
	     
		assertEquals(expected, actualAge);
		assertNotNull(s.avgAge(array));
	}
	}
	
	