class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length -1;

        while (left < right) {
            char l = s[left];
            char r = s[right];

            s[left] = r;
            s[right] = l;
            
            left++;
            right--;
        }
    }
}