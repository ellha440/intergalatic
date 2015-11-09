package intergalactic.numeral;

import java.util.HashMap;

import intergalactic.unit.CurrencyUnit;

public class TransactionCurrency {
	
	
	private HashMap<String, CurrencyUnit> intergalacticCurrency=new HashMap<String, CurrencyUnit>();
	

	public CurrencyUnit getCurrency(String key){
		return intergalacticCurrency.get(key);
	}
	public boolean isCurrency(String key){
		return intergalacticCurrency.containsKey(key);
	}
		
	

	
	public void setCurrency(String valueOfIntergalacticCurrency, double intergalacticValue){
		CurrencyUnit unit= new CurrencyUnit(valueOfIntergalacticCurrency,intergalacticValue);
		intergalacticCurrency.put(unit.getIntergalacticalTransactionUnit(), unit);
			
	}
}
