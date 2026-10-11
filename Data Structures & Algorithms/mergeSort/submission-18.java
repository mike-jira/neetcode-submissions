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
        if (start < end) {
            int mid = start + (end - start) / 2;

            mergeSort(start, mid, pairs);
            mergeSort(mid + 1, end, pairs);

            merge(start, mid, end, pairs);
        }
        return pairs;
    }
    private void merge(int start, int mid, int end, List<Pair> pairs) {
        int lLength = mid - start + 1;
        int rLength = end - mid;

        Pair[] L = new Pair[lLength];
        Pair[] R = new Pair[rLength];

        for (int i = 0; i < lLength; i++) {
            L[i] = pairs.get(start + i);
        }

        for (int i = 0; i < rLength; i++) {
            R[i] = pairs.get(mid + i + 1);
        }

        int l = 0;
        int r = 0;
        int s = start;

        while (l < lLength && r < rLength) {
            if (L[l].key <= R[r].key) {
                pairs.set(s, L[l]);
                l++;
            } else {
                pairs.set(s, R[r]);
                r++;
            }
            s++;
        }

        while (l < lLength) {
            pairs.set(s, L[l]);
            l++;
            s++;
        }

        while (r < rLength) {
            pairs.set(s, R[r]);
            r++;
            s++;
        }
    }
}
