package intergalactic.converter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.LinkedList;

import intergalactic.numeral.TransactionCurrency;
import intergalactic.numeral.TransactionValues;
import intergalactic.util.CommonMessages;

public class TransactionConverter {

	private LinkedList<String> readFile(String filePath) throws Exception {

		LinkedList<String> fileInputLines = new LinkedList<String>();
		BufferedReader bufferedReader = null;
		try {
			FileReader fileReader = new FileReader(filePath);
			bufferedReader = new BufferedReader(fileReader);

			String inputLine = new String();
			while ((inputLine = bufferedReader.readLine()) != null) {
				fileInputLines.add(inputLine);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
		return fileInputLines;
	}

	public LinkedList<String> convertFileInputToArabicCurrency(String filePath) throws Exception {
		TransactionValues romanNumerals = new TransactionValues();
		TransactionCurrency intergalacticalNumerals = new TransactionCurrency();
		LinkedList<String> outputList = new LinkedList<String>();
		LinkedList<String> inputFileLines = readFile(filePath);
		for (String input : inputFileLines) {
			if (isRomanInput(input)) {
				romanNumerals.setValue(input);
			} else if (isQuestion(input)) {
				CurrencyConverter currencyConverter = new CurrencyConverter(romanNumerals, intergalacticalNumerals);
				String output = currencyConverter.convertQuestionToAnswer(input);
				outputList.add(output);
			} else {
				handleCurrency(romanNumerals, intergalacticalNumerals, outputList, input);
			}
		}
		return outputList;
	}

	private void handleCurrency(TransactionValues romanNumerals,
			TransactionCurrency intergalacticalNumerals, LinkedList<String> outputList, String input) {
		String[] words = input.split(" ");
		String romanValues = new String();
		String currencyValue = new String();
		for (int i = 0; i < words.length; i++) {
			String key = words[i];
			if (romanNumerals.isValue(key)) {
				romanValues = romanValues.concat(key).concat(" ");
			} else {
				currencyValue = currencyValue.concat(key).concat(" ");
			}
		}
		ValueConverter romanConverter = new ValueConverter(romanNumerals);
		String arabicNumerials = romanConverter.convertIntergalacticRomanToArabicNumerals(romanValues.trim());
		if (arabicNumerials.equalsIgnoreCase(CommonMessages.invalidInput)) {
			outputList.add(CommonMessages.invalidInput);
		} else {
			intergalacticalNumerals.setCurrency(currencyValue.trim(), Double.parseDouble(arabicNumerials));
		}
	}

	private boolean isQuestion(String input) {
		String question = input.substring(0, 3);
		String questionMark = input.substring(input.length() - 1);
		if (question.equalsIgnoreCase("how") || questionMark.equals("?")) {
			return true;
		} else {
			return false;
		}
	}

	private boolean isRomanInput(String input) {
		String romanNumeral = input.substring(input.length() - 1);
		TransactionValues romans = new TransactionValues();
		return romans.isRomanNumeral(romanNumeral);
	}

}
