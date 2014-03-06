package flag;

public class DutchNationalFlagSorter {
	/**
	 * Rearrange vals so that red values precede white values and white values
	 * precede blue values.
	 * 
	 * @post Exist P and Q, 0 <= P <= Q <= vals.length, s.t. For all i, 0 <= i <
	 *       P, classifier.classify(vals[i]) < 0 For all i, P <= w < Q,
	 *       classifier.classify(vals[i]) == 0 For all i, Q <= i < vals.length,
	 *       classifier.classify(vals[i]) > 0 Values have neither been added to
	 *       nor removed from vals; the new vals is a permutation of the
	 *       original.
	 */
	public void dnf(String[] vals, StringClassifier classifier) {
		int r = 0, b = vals.length - 1;
		// iterate through unsorted (i to b)
		for (int i = 0; i <= b; i++) {
			int result = classifier.classify(vals[i]);
			String temp = vals[i];
			// if red, swap and increment r
			if (result < 0) {
				vals[i] = vals[r];
				vals[r] = temp;
				r++;
			} // if
			// if blue, also has to decrement i because i does not move (for
			// loop automatically increments i)
			else if (result > 0) {
				vals[i] = vals[b];
				vals[b] = temp;
				b--;
				i--;
			} // else if
				// if white, i++
		} // for
	} // dnf(String[], StringClassifier)
} // class DutchNationalFlagSorter
