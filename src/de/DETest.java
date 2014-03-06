package de;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class DETest {

	@Test
	public void test() {
		for (double i = -7; i < 7; i += 0.3) {
			for (int j = 2; j < 11; j++) {
				assertEquals("For " + i + "^" + j, Math.pow(i, j),
						ExercisesDE.expt(i, j), 0.001);
			} // for
		} // for
	} // test()

	@Test
	public void testBinarySearch() throws Exception {
		for (int s = 1; s < 32; s++) {
			int[] arr = new int[s];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i * 2;
			} // for
			for (int i = 0; i < arr.length; i++) {
				assertEquals("For i = " + i, i,
						ExercisesDE.binarySearch(2 * i, arr));
				assertEquals("For odd number " + (2 * i + 1), -1,
						ExercisesDE.binarySearch(2 * i + 1, arr));
			} // for
		} // for
	} // testBinarySearch

} // class DETest
