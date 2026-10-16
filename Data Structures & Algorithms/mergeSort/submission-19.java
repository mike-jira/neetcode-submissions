// Definition for a pair.
// class Pair {
//     public int key;
//     public String value;
//
//     public Pair(int key, String value) {
//         this.key = key;
//         this.value = value;
//     }
// }
class Solution {
    public List<Pair> mergeSort(List<Pair> pairs) {
        return mergeSort(0, pairs.size() - 1, pairs);
    }
    private List<Pair> mergeSort(int start, int end, List<Pair> pairs) {
        if (end > start) {
            int mid = start + (end - start) / 2;

            mergeSort(start, mid, pairs);
            mergeSort(mid + 1, end, pairs);

            merge(start, mid, end, pairs);
        }

        return pairs;
    }
    private void merge(int start, int mid, int end, List<Pair> pairs) {
        int lLen = mid - start + 1;
        int rLen = end - mid;

        Pair[] L = new Pair[lLen];
        Pair[] R = new Pair[rLen];

        for (int i = 0; i < lLen; i++) {
            L[i] = pairs.get(start + i);
        }

        for (int i = 0; i < rLen; i++) {
            R[i] = pairs.get(mid + i + 1);
        }

        int left = 0;
        int right = 0;
        int s = start;

        while (left < lLen && right < rLen) {
            if (L[left].key <= R[right].key) {
                pairs.set(s, L[left]);
                left++;
            } else {
                pairs.set(s, R[right]);
                right++;
            }
            s++;
        }

        while (left < lLen) {
            pairs.set(s, L[left]);
            left++;
            s++;
        }

        while (right < rLen) {
            pairs.set(s, R[right]);
            right++;
            s++;
        }
    }
}
