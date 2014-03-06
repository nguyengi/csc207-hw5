package de;

public class ExercisesDE
{
  /**
   * Compute x^n.
   * 
   * @pre n >= 1.
   */
  public static double expt(double x, int n)
  {
    double result = x, temp = 1;
    int num = n;
    for (int i = 1; i <= (num / 2);)
      {
        // result = x^i
        // temp * result = x^(n - num + i)
        result *= result;
        i *= 2;
        if (i != num && i * 2 > num)
          {
            num = num - i;
            i = 1;
            temp = result * temp;
            result = x;
          } // if
      }
    return result * temp;
  } // expt (double, int)

  /**
   * Search for val in values, return the index of an instance of val.
   * 
   * @param val
   *          An integer we're searching for
   * @param values
   *          A sorted array of integers
   * @result index, an integer
   * @throws Exception
   *           If there is no i s.t. values[i] == val
   * @pre values is sorted in increasing order. That is, values[i] < values[i+1]
   *      for all reasonable i.
   * @post values[index] == val
   */
  public static int binarySearch(int i, int[] vals)
    throws Exception
  {
    int mid, start = 0, end = vals.length - 1;
    while (start <= end)
      {
        // I: vals[start] <= i && vals[end] >= i
        mid = (end + start) / 2;
        if (vals[mid] == i)
          {
            return mid;
          } // if
        else if (vals[mid] < i)
          {
            start = mid + 1;
          } // else it
        else
          {
            end = mid - 1;
          } // else
      } // while
    return -1; // STUB
  } // binarySearch
} // class ExercisesDE
