package intergalactic.main;

import java.util.LinkedList;
import java.util.Scanner;
import intergalactic.converter.TransactionConverter;

public class Converter {

	public static void main(String[] args) {
		TransactionConverter converter= new TransactionConverter();
		Scanner sc = new Scanner(System.in);
		System.out.println("Please input the path to the file");
		String filePath=sc.nextLine();
		LinkedList<String> outputList=new LinkedList<String>();
		try{
			outputList=converter.convertFileInputToArabicCurrency(filePath);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			sc.close();
		}
		for(String outputLine:outputList){
			System.out.println(outputLine);
		}
	}


}
