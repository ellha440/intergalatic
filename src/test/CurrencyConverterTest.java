package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import intergalactic.converter.CurrencyConverter;
import intergalactic.numeral.TransactionCurrency;
import intergalactic.numeral.TransactionValues;
import intergalactic.util.CommonMessages;

public class CurrencyConverterTest {



	private String I ="glob";
	private String V="prok";
	private String X="pish";
	private String L="tegj";
	private String C="cesar";
	private String D="david";
	private String M="martin";
	private String silver="silver";
	private String gold="gold";
	private String iron="iron";
	private String howManyCreditIs ="how many Credits is";
	private String howMuchIs="how much is";
	private String questionMark=" ?";
	
	CurrencyConverter creditsConverter;
	
	@Before public void initialize(){
		TransactionValues roman= new TransactionValues();
		roman.setValue(I.concat(" is I"));
		roman.setValue(V.concat(" is V"));
		roman.setValue(X.concat(" is X"));
		roman.setValue(L.concat(" is L"));
		roman.setValue(C.concat(" is C"));
		roman.setValue(D.concat(" is D"));
		roman.setValue(M.concat(" is M"));
		TransactionCurrency intergalacticalNumerals=new TransactionCurrency();
		intergalacticalNumerals.setCurrency(silver.concat(" is 34 Credits"),2);
		intergalacticalNumerals.setCurrency(gold.concat(" is 57800 Credits"),4);
		intergalacticalNumerals.setCurrency(iron.concat(" is 3910 Credits"),20);
		creditsConverter=new CurrencyConverter(roman,intergalacticalNumerals);
		
	}
	
	@Test
	public void setIntegralCreditSilver(){
		assertEquals("34 Credits", 
				creditsConverter.convertCurrencyToArabic(I.concat(" ").concat(I).concat(" ").concat(silver)));
	}
	@Test
	public void setIntegralCreditGold(){
		assertEquals("57800 Credits", 
				creditsConverter.convertCurrencyToArabic(I.concat(" ").concat(V).concat(" ").concat("gold")));
	}
	@Test
	public void setIntegralCreditDouble(){
		assertEquals("3910 Credits", 
				creditsConverter.convertCurrencyToArabic(X.concat(" ").concat(X).concat(" ").concat("iron")));
	}
	@Test
	public void noCredits(){
		assertEquals("42", 
				creditsConverter.convertCurrencyToArabic(X.concat(" ").concat(L).concat(" ")
						.concat(I).concat(" ").concat(I)));
	}
	
	@Test
	public void checkIntegralCreditSilver(){
		assertEquals("68 Credits", 
				creditsConverter.convertCurrencyToArabic(I.concat(" ").concat(V).concat(" ").concat(silver)));
	}
	@Test
	public void checkIntegralCreditDouble(){
		assertEquals("782 Credits", 
				creditsConverter.convertCurrencyToArabic(I.concat(" ").concat(V).concat(" ").concat("iron")));
	}
	

	@Test
	public void howMuchIsXLII(){
		assertEquals("pish tegj glob glob is 42", 
				creditsConverter.convertQuestionToAnswer(howMuchIs.concat(" ").concat(X).concat(" ")
						.concat(L).concat(" ").concat(I).concat(" ").concat(I).concat(questionMark)
						));
	}
	
	@Test
	public void howMuchIsIVSilver(){
		assertEquals(I.concat(" ").concat(V).concat(" ").concat(silver).concat(" is 68 Credits"), 
				creditsConverter.convertQuestionToAnswer(howManyCreditIs.concat(" ").concat(I).concat(" ")
						.concat(V).concat(" ").concat(silver).concat(questionMark)));
	}


	@Test
	public void howManyCreditIsIVGold(){
		assertEquals(I.concat(" ").concat(V).concat(" ").concat(gold).concat(" is 57800 Credits"), 
				creditsConverter.convertQuestionToAnswer(howManyCreditIs.concat(" ").concat(I).concat(" ")
						.concat(V).concat(" ").concat(gold).concat(questionMark)));
	}
	@Test
	public void howManyCreditIsIVIron(){
		assertEquals(I.concat(" ").concat(V).concat(" ").concat(iron).concat(" is 782 Credits"), 
				creditsConverter.convertQuestionToAnswer(howManyCreditIs.concat(" ").concat(I).concat(" ")
						.concat(V).concat(" ").concat(iron).concat(questionMark)));
	}	
	
	@Test
	public void howMuchInvalidInput(){
		assertEquals(CommonMessages.invalidInput, 
				creditsConverter.convertQuestionToAnswer("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?"));
	}	

}
