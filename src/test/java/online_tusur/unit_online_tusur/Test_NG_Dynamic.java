package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;

public class Test_NG_Dynamic {
	
	Student s = new Student();
	
	//private ArrayList<Student> s = new ArrayList<Student>();
	
	private String  expected, actual;
	
	@Factory(dataProvider = "data")
	public Test_NG_Dynamic (String c, String actual) {
		this.expected = expected;
		this.actual = actual;
	}
	
	@DataProvider (name = "data")
	public static Object[][] getLastName() {
		return new Object[][]{{"Morozov","Morozov"}, {"Pavlova","pavlova"}, {"Titov","TITOV"}};
	}
		@Test 
		void TestLastName() {
			s.setLastName(actual);
			String actualValue = s.getFirstName();
			assertEquals(actualValue, expected);
		}
}
		
	