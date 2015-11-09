package intergalactic.numeral;

import java.util.HashMap;

import intergalactic.unit.CurrencyUnit;

public class TransactionCurrency {
	
	
	private HashMap<String, CurrencyUnit> currencies = new HashMap<String, CurrencyUnit>();
	

	public CurrencyUnit getCurrency(String key){
		return currencies.get(key);
	}
	public boolean isCurrency(String key){
		return currencies.containsKey(key);
	}
		
	

	
	public void setCurrency(String valueOfIntergalacticCurrency, double intergalacticValue){
		CurrencyUnit unit= new CurrencyUnit(valueOfIntergalacticCurrency,intergalacticValue);
		currencies.put(unit.getIntergalacticalTransactionUnit(), unit);
			
	}
}
