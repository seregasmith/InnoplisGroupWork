package LearnLangByWords;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class RandomizerTest {

	@Test
	public void TestGenerateRandValuesArray() {
		int [] arr = Randomizer.GenerateRandValuesArray(6,10);
		Map<Integer, Byte> uniqueArr = new HashMap<Integer, Byte>();
		for(Integer i : arr){
			if (!uniqueArr.containsKey(i)){
				uniqueArr.put(i, (byte) 0);
			}else{
				fail("The array shoul be unique");
			}
//			System.out.println(i);
		}
	}
	
	@Test
	public void TestRandArray() {
		String[] tmp = {
				"Cow","Dog","Cat","Catch","Take",
				"Earth","Sheet","Hello","World","Make",
				"Cold","Hot","What","Match","Brake"
				};
		ArrayList<String> example = new ArrayList<String>();
		for( String it : tmp ){
			example.add(it);
		}
		ArrayList<String> arr = Randomizer.randArray(example);
		Map<String, Byte> uniqueArr = new HashMap<String, Byte>();
		for(String i : arr){
			if (!uniqueArr.containsKey(i)){
				uniqueArr.put(i, (byte) 0);
			}else{
				fail("The array shoul be unique");
			}
			System.out.println(i);
		}
	}

}
