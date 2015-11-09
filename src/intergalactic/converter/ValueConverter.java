package intergalactic.converter;

import intergalactic.numeral.TransactionValues;
import intergalactic.unit.ValueUnit;
import intergalactic.util.CommonMessages;

public class ValueConverter {
	
	
	private TransactionValues roman;
	
	public ValueConverter(TransactionValues roman){
		this.roman=roman;
	}
	
	public String convertIntergalacticRomanToArabicNumerals(String intergalacticTransactionUnit){
		String[] units=intergalacticTransactionUnit.split(" ");		
		int arabicNumeral=0;
		int numberOfUnitInARow=1;
		int numberOfPreceedingUnitsInARow=0;
		ValueUnit preceedingUnit = new ValueUnit("", 0,0);
		for(String valueUnit:units){
			
			if(!roman.isValue(valueUnit)){		
				return CommonMessages.invalidInput;
			}
			
			ValueUnit unit = roman.getValue(valueUnit);
			
			int addValue=0;
			int firstArabicNumeral=0;
			if(arabicNumeral>firstArabicNumeral){
				if(unit.equals(preceedingUnit)){
					numberOfUnitInARow++;
				}else{
					numberOfPreceedingUnitsInARow=numberOfUnitInARow;
					numberOfUnitInARow=1;
				}
	
				if(!unit.validNumberOfInput(numberOfUnitInARow) ||
						!unit.validPreeceeding(preceedingUnit, numberOfPreceedingUnitsInARow)){
					return CommonMessages.invalidInput;
				}else if(unit.isBiggerThan(preceedingUnit)){
					addValue=unit.getEarthUnit()-2*preceedingUnit.getEarthUnit();
				}
			}
			
			if(addValue==0){			
				addValue=unit.getEarthUnit();
			}
			arabicNumeral=arabicNumeral+addValue;
			preceedingUnit=unit;
		}
		return Integer.toString(arabicNumeral);
	}

}