package com.tareas.tarea8;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class Tarea8ApplicationTests {

	tarea8 Test = new tarea8();
	@Test
	void contextLoads() {
		assertEquals("Queue: <br><br>Sorted List: <br>", Test.print());
		Test.addOriginal();
		assertEquals("Queue: <br>Social Security Number: 12345 Work: Publicity<br>Social Security Number: 54321 Work: Marketing<br>Social Security Number: 789 Work: Distribution<br>Social Security Number: 345 Work: Design<br><br>Sorted List: <br>Social Security Number: 345 Name: Rob Days: 22<br>Social Security Number: 789 Name: Alex Days: 15<br>Social Security Number: 12345 Name: John Days: 5<br>Social Security Number: 54321 Name: Mike Days: 4<br>", Test.print());
		assertEquals("Added Successfully", Test.add(234, "Paula", "Accounting", 73));
		assertEquals("Queue: <br>Social Security Number: 12345 Work: Publicity<br>Social Security Number: 54321 Work: Marketing<br>Social Security Number: 789 Work: Distribution<br>Social Security Number: 345 Work: Design<br>Social Security Number: 234 Work: Accounting<br><br>Sorted List: <br>Social Security Number: 234 Name: Paula Days: 73<br>Social Security Number: 345 Name: Rob Days: 22<br>Social Security Number: 789 Name: Alex Days: 15<br>Social Security Number: 12345 Name: John Days: 5<br>Social Security Number: 54321 Name: Mike Days: 4<br>", Test.print());
		assertEquals("Updated Successfully", Test.add(789, "Sofia", "Manager", 34));
		assertEquals("Queue: <br>Social Security Number: 12345 Work: Publicity<br>Social Security Number: 54321 Work: Marketing<br>Social Security Number: 789 Work: Manager<br>Social Security Number: 345 Work: Design<br>Social Security Number: 234 Work: Accounting<br><br>Sorted List: <br>Social Security Number: 234 Name: Paula Days: 73<br>Social Security Number: 345 Name: Rob Days: 22<br>Social Security Number: 789 Name: Sofia Days: 34<br>Social Security Number: 12345 Name: John Days: 5<br>Social Security Number: 54321 Name: Mike Days: 4<br>", Test.print());
		assertEquals("Social Security Number: 234 Name: Paula Work: Accounting Days: 73<br>Social Security Number: 345 Name: Rob Work: Design Days: 22<br>Social Security Number: 789 Name: Sofia Work: Manager Days: 34<br>Social Security Number: 54321 Name: Mike Work: Marketing Days: 4<br>Social Security Number: 12345 Name: John Work: Publicity Days: 5<br>", Test.empty());
	}

}
