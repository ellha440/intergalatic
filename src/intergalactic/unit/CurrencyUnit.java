package intergalactic.unit;

public class CurrencyUnit {
	private String intergalacticalTransactionUnit;
	private double valueOfOneUnit;
	private String currency;

	
	/**valueOfIntergalacticCurrency "Silver is 34 Credits" "denominator is 34 currency"
	 * intergalacticValue "2"
	 * */
	public CurrencyUnit (String valueOfIntergalacticCurrency, double intergalacticValue){
		String transactionUnit[]= valueOfIntergalacticCurrency.split(" is ");
		intergalacticalTransactionUnit=transactionUnit[0];
		String [] valueAndCurrency=transactionUnit[1].split(" ");
		valueOfOneUnit= Double.parseDouble(valueAndCurrency[0])/intergalacticValue;
		currency=valueAndCurrency[1];
	}
	
	public String getCurrency() {
		return currency;
	}

	public double getValueOfOneUnit() {
		return valueOfOneUnit;
	}

	public String getIntergalacticalTransactionUnit() {
		return intergalacticalTransactionUnit;
	}

	
	

}
