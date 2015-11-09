package test;


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import intergalactic.converter.ValueConverter;
import intergalactic.numeral.TransactionValues;
import intergalactic.util.CommonMessages;

public class ValueConverterTest {
	private ValueConverter converter;

	private String I ="glob";;
	private String V="prok";
	private String X="pish";
	private String L="tegj";
	private String C="cesar";
	private String D="david";
	private String M="martin";
	
	@Before public void initialize(){
		TransactionValues roman= new TransactionValues();
		roman.setValue(I.concat(" is I"));
		roman.setValue(V.concat(" is V"));
		roman.setValue(X.concat(" is X"));
		roman.setValue(L.concat(" is L"));
		roman.setValue(C.concat(" is C"));
		roman.setValue(D.concat(" is D"));
		roman.setValue(M.concat(" is M"));

		converter=new ValueConverter(roman);
	}
	
	@Test
	public void IisSetTo1() {
		assertEquals("1", converter.convertIntergalacticRomanToArabicNumerals(I));
	}

	@Test
	public void VisSetTo5() {
		assertEquals( "5",converter.convertIntergalacticRomanToArabicNumerals(V));
	}
	
	@Test
	public void XisSetTo10() {
		assertEquals( "10",converter.convertIntergalacticRomanToArabicNumerals(X));
	}
	

	@Test
	public void LisSetTo50(){
		 assertEquals("50", converter.convertIntergalacticRomanToArabicNumerals(L));
	 }

	@Test
	public void CisSetTo100(){
		 assertEquals("100", converter.convertIntergalacticRomanToArabicNumerals(C));
	 }
	@Test
	public void DisSetTo500(){
		 assertEquals("500", converter.convertIntergalacticRomanToArabicNumerals(D));
	 }
	@Test
	public void MisSetTo1000(){
		 assertEquals("1000", converter.convertIntergalacticRomanToArabicNumerals(M));
	 }	

	@Test
	public void twoFollowingIShouldBeAdded(){
		assertEquals("2", converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(I)));
	}
	
	@Test
	public void XFollowedByTwoIShouldBeAdded(){
		assertEquals("12",converter.convertIntergalacticRomanToArabicNumerals(X.concat(" ").concat(I).concat(" ").concat(I)));
	}
	
	@Test
	public void ICanBeSubtractedFromV(){
		assertEquals("4",converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(V)));
	}
	
	@Test
	public void ICanBeSubtractedFromX(){
		assertEquals("9",converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(X)));
	}
	
	@Test
	public void ICanBeSubtractedFromXWhenInTheMiddle(){
		assertEquals("19",converter.convertIntergalacticRomanToArabicNumerals(X.concat(" ").concat(I).concat(" ").concat(X)));
	}
	
	@Test
	public void ICanOnlyBeSubtractedFromVandXNotL(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(L)));
	}
	@Test
	public void ICanOnlyBeSubtractedFromVandXNotC(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(C)));
	}
	@Test
	public void ICanOnlyBeSubtractedFromVandXNotD(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(D)));
	}
	@Test
	public void ICanOnlyBeSubtractedFromVandXNotM(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(M)));
	}

		
	@Test
	public void XCanBeSubtractedFromL(){
		assertEquals("40",converter.convertIntergalacticRomanToArabicNumerals(X.concat(" ").concat(L)));
	}
		
	@Test
	public void XCanBeSubtractedFromC(){
		assertEquals("90",converter.convertIntergalacticRomanToArabicNumerals(X.concat(" ").concat(C)));
	}
		
		
	@Test
	public void XCanOnlyBeSubtractedFromLandCNotD(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(D)));
	}
	@Test
	public void XCanOnlyBeSubtractedFromLandCNotM(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(M)));
	}
	
	@Test
	public void CCanBeSubtractedFromD(){
		assertEquals("400",converter.convertIntergalacticRomanToArabicNumerals(C.concat(" ").concat(D)));
	}
		
	@Test
	public void CCanBeSubtractedFromM(){
		assertEquals("900",converter.convertIntergalacticRomanToArabicNumerals(C.concat(" ").concat(M)));
	}


	@Test
	public void IShouldBeAbleToHave3InARow(){
		assertEquals( "3",converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(I).concat(" ").concat(I)));
	}
	@Test
	public void IShouldBeAbleToHave3InARowButNotMore(){
		assertEquals(CommonMessages.invalidInput,
				converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(I).concat(" ").concat(I).concat(" ").concat(I)));
	}
	
	@Test
	public void XShouldBeAbleToHave3InARow(){
		assertEquals( "30",converter.convertIntergalacticRomanToArabicNumerals(X.concat(" ").concat(X).concat(" ").concat(X)));
	}
	
	@Test
	public void XShouldBeAbleToHave3InARowButNotMore(){
		assertEquals(CommonMessages.invalidInput,converter
				.convertIntergalacticRomanToArabicNumerals(X.concat(" ").concat(X).concat(" ").concat(X).concat(" ").concat(X)));
	}

	@Test
	public void CShouldBeAbleToHave3InARow(){
		assertEquals( "300",converter.convertIntergalacticRomanToArabicNumerals(C.concat(" ").concat(C).concat(" ").concat(C)));
	}
	
	@Test
	public void CShouldBeAbleToHave3InARowButNotMore(){
		assertEquals(CommonMessages.invalidInput,
				converter.convertIntergalacticRomanToArabicNumerals(C.concat(" ").concat(C).concat(" ").concat(C).concat(" ").concat(C)));
	}
	@Test
	public void MShouldBeAbleToHave3InARow(){
		assertEquals( "3000",converter.convertIntergalacticRomanToArabicNumerals(M.concat(" ").concat(M).concat(" ").concat(M)));
	}
	
	@Test
	public void MShouldBeAbleToHave3InARowButNotMore(){
		assertEquals(CommonMessages.invalidInput,
				converter.convertIntergalacticRomanToArabicNumerals(M.concat(" ").concat(M).concat(" ").concat(M).concat(" ").concat(M)));
	}

	@Test
	public void VCanNeverBeRepeated(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(V.concat(" ").concat(V)));
	}

	@Test
	public void LCanNeverBeRepeated(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(L.concat(" ").concat(L)));
	}

	@Test
	public void DCanNeverBeRepeated(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(D.concat(" ").concat(D)));
	}


	@Test 
	public void VcannotBeSubtracted(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(V.concat(" ").concat(X)));
	}
	@Test 
	public void LcannotBeSubtracted(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(L.concat(" ").concat(C)));
	}
	@Test 
	public void DcannotBeSubtracted(){
		assertEquals(CommonMessages.invalidInput,converter.convertIntergalacticRomanToArabicNumerals(D.concat(" ").concat(M)));
	}
	
	
	@Test
	public void onlyOneSmallNumberMayBeSubtracted(){
		assertEquals(CommonMessages.invalidInput, 
				converter.convertIntergalacticRomanToArabicNumerals(I.concat(" ").concat(I).concat(" ").concat(X)));
	}


	
}