package flag;
// Citation: permute and swap taken from lab on sorting

import java.util.Arrays;
import java.util.Random;

public class MainTest {
	static Random generator = new Random();
	public static void main(String[] args) {
		DutchNationalFlagSorter sorter = new DutchNationalFlagSorter();
		String[] strs = new String[] {"r", "r", "r", "w", "w", "w", "w", "w", "b", "b"};
		StringClassifier cl = new StringClassifier() {
			
			@Override
			public int classify(String val) {
				switch (val) {
				case "r":
					return -1;
				case "w":
					return 0;
				case "b":
					return 1;
				default:
					return 0;
				} // switch
			} // classify(String)
		};
		for (int i = 0; i < 50; i++) {
			permute(strs);
//			System.out.println(Arrays.toString(strs));
			sorter.dnf(strs, cl);
			System.out.println(Arrays.toString(strs));
		} // for
		
	} // main (String[])

	public static <T> T[] permute(T[] values)
	  {
	    for (int i = 0; i < values.length; i++)
	      {
	        swap(values, i, generator.nextInt(values.length));
	      } // for
	    return values;
	  } // permute(T)
	 public static <T> void swap(T[] values, int i, int j)
	  {
	    T tmp = values[i];
	    values[i] = values[j];
	    values[j] = tmp;
	  } // swap(T[], int, int)
} // class MainTest
