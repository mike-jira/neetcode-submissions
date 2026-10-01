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
        return mergeSort(pairs, 0, pairs.size() - 1);
    }
    private List<Pair> mergeSort(List<Pair> pairs, int start, int end) {
        if (end - start + 1 <= 1) {
            return pairs;
        }

        int mid = start + (end - start) / 2;
        mergeSort(pairs, start, mid);
        mergeSort(pairs, mid + 1, end);

        sort(pairs, start, mid, end);

        return pairs;
    }
    private void sort(List<Pair> pairs, int start, int mid, int end) {
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
