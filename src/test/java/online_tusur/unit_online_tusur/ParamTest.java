package online_tusur.unit_online_tusur;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class ParamTest {

	Student s = new Student();
	Student s1 = new Student();
	Student s2 = new Student();
	
	@ParameterizedTest
	@Tag("positive")
	@ValueSource(ints = {18,50,45, Integer.MAX_VALUE})
	void testWithValueSource(int param) {
		s.setAge(param);
		assertTrue(s.getAge()>=18);
	}

	
	@ParameterizedTest
	@Tag("positive")
	@MethodSource("intMethod2")
	void testWithValueSourse(Integer param) {
		s.setAge(param);
		assertNotEquals(18,s.getAge());
	}
	static Stream <Integer> intMethod1(){
		return Stream.of(25,50);
	}
	
	static IntStream intMethod2(){
		return IntStream.range(18,50);
	}
	
	
	@ParameterizedTest
	@Tag("positive")
	@CsvFileSource(resources = "name.csv")
	void testWithCsvSource(String param) {
		s.setFirstName(param);
		assertNotNull(s.getFirstName());
	}
	
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

}
