package intergalactic.numeral;

import java.util.HashMap;

import intergalactic.unit.ValueUnit;

public class TransactionValues {
	private HashMap<String, ValueUnit> romanArabicNumerals=new HashMap<String, ValueUnit>();
	private HashMap<String, ValueUnit> intergalacticTransactionValues=new HashMap<String,ValueUnit>();
	
	
	
	public TransactionValues(){

		String I = "I";
		ValueUnit unit = new ValueUnit(I,1,3);
		romanArabicNumerals.put(I, unit);
		
		String V="V";
	    unit = new ValueUnit(V,5,1);
	    romanArabicNumerals.put(V, unit);
		
		String X="X";
	    unit = new ValueUnit(X,10,3);
	    romanArabicNumerals.put(X, unit);
		
		String L="L";
	    unit = new ValueUnit(L,50,1);
	    romanArabicNumerals.put(L, unit);
		
		String C="C";
	    unit = new ValueUnit(C,100,3);
	    romanArabicNumerals.put(C, unit);

		String D="D";
	    unit = new ValueUnit(D,500,1);
	    romanArabicNumerals.put(D, unit);
		
		String M="M";
	    unit = new ValueUnit(M,1000,3);
	    romanArabicNumerals.put(M, unit);
		
	}
	
	public ValueUnit getValue(String key){
		return intergalacticTransactionValues.get(key);
	}
	
	public boolean isValue(String key){
		return intergalacticTransactionValues.containsKey(key);
	}

	public boolean isRomanNumeral(String key){
		return romanArabicNumerals.containsKey(key);
	}
	
	public void setValue(String intergalacticalIsRoman){
		String[] units= intergalacticalIsRoman.split(" is ");
		String romanLetter=units[1];
		ValueUnit unit = romanArabicNumerals.get(romanLetter);
		String intergalacticalUnit= units[0];
		unit.setUnit(intergalacticalUnit);
		intergalacticTransactionValues.put(intergalacticalUnit,  unit);
	}
}