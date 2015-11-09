package test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import intergalactic.converter.TransactionConverter;

public class TransactionConverterTest {

	@Test
	public void shouldOutputLines() throws Exception{
		TransactionConverter converter=new TransactionConverter();
		LinkedList<String> outputList=converter.convertFileInputToArabicCurrency("/home/ellen/workspace/thoughtworks/src/txt/input.txt");
		List<String> expectedList=Arrays.asList("pish tegj glob glob is 42","glob prok Silver is 68 Credits",
						"glob prok Gold is 57800 Credits","glob prok Iron is 782 Credits",
						"I have no idea what you are talking about"	);
		assertEquals(expectedList,outputList);
	}
}
