/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 0;
        int right = n;

        return bisectionSearch(left, right);
    }

    public int bisectionSearch(int min, int max) {
        int mid = min + (max - min) / 2;

        int guessResult = guess(mid);

        if (guessResult > 0) {
            return bisectionSearch(mid + 1, max);
        } else if (guessResult < 0) {
            return bisectionSearch(min, mid - 1);
        } else {
            return mid;
        }
    }
}