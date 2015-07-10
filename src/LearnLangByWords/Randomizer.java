package LearnLangByWords;

import java.util.ArrayList;
import java.util.Random;

public class Randomizer {
	private static int amount = 10;
	public static ArrayList<String> randArray(ArrayList<String> src){
		int [] rand_inds = GenerateRandValuesArray (amount, src.size());
		ArrayList<String> res = new ArrayList<String>(); 
		for( int ind : rand_inds ){
			res.add(src.get(ind));
		}
		return res;
	}
	
	//@GenerateRandValuesArray
	//There is method for generating int array with unique values randomly in range with size 
	public static int [] GenerateRandValuesArray ( int amount,int size){
		//check params
		if(amount > size){
			return null;
		}
		
		Random generator = new Random (System.currentTimeMillis());
		
		int[] numbers = new int[amount];
        boolean[] check = new boolean[size];
        int amountFilled = 0;
        int trial;
        while (amountFilled < amount) {
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
