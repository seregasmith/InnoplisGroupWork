package LearnLangByWords;

import java.util.Random;

public class Randomizer {
	//@GenerateRandValuesArray
	//There is method for generating int array with unique values randomly in range with size 
	public static int [] GenerateRandValuesArray (int size){
		Random generator = new Random (System.currentTimeMillis());
		
		int[] numbers = new int[size];
        boolean[] check = new boolean[size];
        int amountFilled = 0;
        int trial;
        while (amountFilled < size) {
            trial = generator.nextInt(size);
            if (!check[trial]) {
                check[trial] = true;
                numbers[amountFilled] = trial;
                amountFilled++;
            }
        }
		
		return numbers;
	}
	
	
}
