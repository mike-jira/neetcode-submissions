// Definition for a pair.
// class Pair {
//     int key;
//     String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> quickSort(List<Pair> pairs) {
        return quickSort(0, pairs.size() - 1, pairs);
    }
    private List<Pair> quickSort(int start, int end, List<Pair> pairs) {
        if (end - start + 1 <= 1) {
            return pairs;
        }

        Pair pivot = pairs.get(end);
        int left = start;

        for (int i = start; i < end; i++) {
            if (pairs.get(i).key < pivot.key) {
                Pair temp = pairs.get(left);
                Pair current = pairs.get(i);
                pairs.set(left, current);
                pairs.set(i, temp);
                left++;
            }
        }

        Pair currLeft = pairs.get(left);
        
        pairs.set(left, pivot);
        pairs.set(end, currLeft);

        // sort left side
        quickSort(start, left - 1, pairs);

        // sort right side
        quickSort(left + 1, end, pairs);

        return pairs; 
    }
}
