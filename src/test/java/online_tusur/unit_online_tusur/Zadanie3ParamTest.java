package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.*;
import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class Zadanie3ParamTest {

	Student s = new Student();
	
	//Тест для сравнения заданных и полученных значений возраста, а также сравнения среднего возраста с нулем
	@SuppressWarnings("static-access")
	@ParameterizedTest
	@Tag("positive")
	@CsvSource(value = {"0,18", "50,50", "25,25"})
	
	void testWithCSVSource(int input, int expected) {
		Student[] array = {s};		
		s.setAge(input);
		int actualValue = s.getAge();
		assertEquals(expected, actualValue);
		assertNotNull(s.avgAge(array));
	}
	
	}


