package intergalactic.converter;

import intergalactic.numeral.TransactionCurrency;
import intergalactic.numeral.TransactionValues;
import intergalactic.unit.CurrencyUnit;
import intergalactic.util.CommonMessages;

public class CurrencyConverter {
	private TransactionValues romanNumerals;
	private TransactionCurrency intergalacticalNumerals;
	
	
	public CurrencyConverter(TransactionValues romanNumerals,
			TransactionCurrency intergalacticalNumerals){
		this.romanNumerals=romanNumerals;
		this.intergalacticalNumerals=intergalacticalNumerals;
	}
	

	/**
	 * Example valid questions:
	 * how much is pish tegj glob glob ?
	 * how many Credits is glob prok Silver ?
	 * 
	 * returns longAnswer of format
	 * pish tegj glob glob is 42
	 * glob prok Silver is 68 Credits
	 * */
	public String convertQuestionToAnswer(String question){
		String [] questionAndValuesAndQuestionMark= question.split(" is ");
		if(questionAndValuesAndQuestionMark.length<2){
			return CommonMessages.invalidInput;
		}
		String valuesAndQuestionMark= questionAndValuesAndQuestionMark[1];
		String intergalacticalUnits=valuesAndQuestionMark.substring(0, valuesAndQuestionMark.length()-2) ;
		String arabicCurrency= convertCurrencyToArabic(intergalacticalUnits);
		if(arabicCurrency.equals(CommonMessages.invalidInput)){
			return CommonMessages.invalidInput;
		}
		String answer=intergalacticalUnits.concat(" is ").concat(arabicCurrency);
		return answer;

	}
	
	
	public String convertCurrencyToArabic(String convert){	
		String units [] = convert.split(" ");
		String romanValues=new String();
		String arabicCurrency=new String();
		
		for(String key:units){
			if(romanNumerals.isValue(key)){
				romanValues=romanValues.concat(key).concat(" ");
			}else if(intergalacticalNumerals.isCurrency(key)){
				arabicCurrency = handleCurrency(romanValues, key);
			}else{
				return CommonMessages.invalidInput;
			}
		}
		
		if(arabicCurrency.length()==0 ){
			if(romanValues.length()>0){
				return convertRomanValues(romanValues.trim());
			}else{
				return CommonMessages.invalidInput;
			}
			
		}
		return arabicCurrency;
	}


	private String handleCurrency(String romanValues, String key) {
		CurrencyUnit intergalacticalUnit=intergalacticalNumerals.getCurrency(key);
		double valueOfOneUnit=intergalacticalUnit.getValueOfOneUnit();
		String arabicValues=convertRomanValues(romanValues.trim());
		int arabicValueOfIntergalacticalTransaction=(int)Math.round(
				Double.parseDouble(arabicValues)*valueOfOneUnit);
		String arabicCurrency= Integer.toString(arabicValueOfIntergalacticalTransaction)
				.concat(" ").concat(intergalacticalUnit.getCurrency());
		return arabicCurrency;
	}
	
	private String convertRomanValues(String romanValues){
		ValueConverter converter = new ValueConverter(romanNumerals);
		return converter.convertIntergalacticRomanToArabicNumerals(romanValues);
		
	}

	
	

}
