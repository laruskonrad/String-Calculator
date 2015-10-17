package is.ru.stringcalculator;

public class Calculator {

	public static String delimiter = ",|\n";

	public static int add(String text) throws Exception {
		if(text.equals("")){
			return 0;
		}
		if(text.startsWith("//")){
			String[] split = text.split("\n", 2);
			delimiter = split[0].substring(2);
			text = split[1];
		}
		if(text.contains(",") || text.contains("\n") || text.contains(delimiter)) {
			return sum(splitNumbers(text));
		}
		else {
			return 1;
		}
	}

	private static int toInt(String number){
		return Integer.parseInt(number);
	}

	private static String[] splitNumbers(String numbers){
	    return numbers.split(delimiter);
	}
      
    private static int sum(String[] numbers) throws Exception {
    	checkForNegativeNumbers(numbers);

 	    int total = 0;
        for(String number : numbers){
		    total += toInt(number);
		}
		return total;
    }

    private static void checkForNegativeNumbers(String[] numbers) throws Exception{
    	for(int i = 0; i < numbers.length; i++){
    		if(toInt(numbers[i]) < 0){
    			throw new Exception("Negatives not allowed: " + getNegativeNumbers(numbers));
    		}
    	}
    }

    private static String getNegativeNumbers(String[] numbers){
    	String negativeNumbers = "";
    	for(int i = 0; i < numbers.length; i++){
    		if(toInt(numbers[i]) < 0){
    			negativeNumbers = negativeNumbers + numbers[i] + ",";
    		}
    	}

    	return negativeNumbers.substring(0, negativeNumbers.length()-1);    }
}
