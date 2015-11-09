package intergalactic.unit;

public class ValueUnit {

	private String unit;
	private int earthUnit;
	private int maxNumberInARow;

	
	public ValueUnit(String unit, int earthUnit, int maxNumberInARow){
		this.unit=unit;
		this.earthUnit=earthUnit;
		this.maxNumberInARow=maxNumberInARow;
	}
	
	public String getUnit(){
		return unit;
	}
	public void setUnit(String unit){
		this.unit=unit;
	}
	public int getEarthUnit(){
		return earthUnit;
	}
	
	
	public boolean equals(ValueUnit compersionUnit){
		return compersionUnit.getUnit().equals(unit);
	}
	
	
	public boolean isBiggerThan(ValueUnit compersionUnit){
		return earthUnit>compersionUnit.getEarthUnit();
	}

	/**
	 * The symbols "I", "X", "C", and "M" can be repeated three times in succession, but no more. 
	 * (They may appear four times if the third and fourth are separated by a smaller value, such as XXXIX.) 
	 * "D", "L", and "V" can never be repeated.
	 * */
	
	public boolean validNumberOfInput(int numberOfInput){
		if(numberOfInput>maxNumberInARow){
			return false;
		}else{
			return true;
		}
	}
	public boolean validPreeceeding(ValueUnit compersionUnit,
			int numberOfInput){
		if(isBiggerThan(compersionUnit)){
			if(!validPreceedingNumberOfInput(numberOfInput) 
					|| compersionUnit.equalsForbiddenValue()
					|| !validPreceedingBeforeValueNoMoreThanMaxTimesBigger(compersionUnit)){
				return false;
			}else{
				return true;
			}
		}else{
			return true;
		}
		
	}
	/**
	 * V", "L", and "D" can never be subtracted.
	 * */
	private boolean equalsForbiddenValue(){
		int [] preeceedingValueForbidden  = {5,50,500};
		for(int i= 0; i<preeceedingValueForbidden.length;i++){
			if(earthUnit==preeceedingValueForbidden[i]){
				return true;
			}
		}
		return false;
	}
	
	/**
	 * "I" can be subtracted from "V" and "X" only. 
	 * "X" can be subtracted from "L" and "C" only. 
	 * "C" can be subtracted from "D" and "M" only.
	 * */
	private boolean validPreceedingBeforeValueNoMoreThanMaxTimesBigger(ValueUnit compersionUnit){
		int maxTimesBigger=10;
		if(compersionUnit.getEarthUnit()*maxTimesBigger<earthUnit){
			return false;
		}else{
			return true;
		}
	}

	/**
	 * Only one small-value symbol may be subtracted from any large-value symbol.
	 * */
	private boolean validPreceedingNumberOfInput(int numberOfInput){
		int maxNumberOfPreceedingInput = 1;
		if(numberOfInput>maxNumberOfPreceedingInput){
			return false;
		}else{
			return true;
		}
	}
}
