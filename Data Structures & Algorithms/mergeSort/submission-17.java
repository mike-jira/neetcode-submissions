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
        mergeSort(pairs, 0, pairs.size() - 1);
        return pairs;
    }
    private List<Pair> mergeSort(List<Pair> pairs, int start, int end) {
        if (end > start) {
            int mid = start + (end - start) / 2;

            mergeSort(pairs, start, mid);
            mergeSort(pairs, mid + 1, end);

            merge(pairs, start, mid, end);

            return pairs;
        }
        return pairs;
    }
    private void merge(List<Pair> pairs, int start, int mid, int end) {
        int lLen = mid - start + 1;
        int rLen = end - mid;

        Pair[] l = new Pair[lLen];
        Pair[] r = new Pair[rLen];

        for (int i = 0; i < lLen; i++) {
            l[i] = pairs.get(start + i);
        }

        for (int i = 0; i< rLen; i++) {
            r[i] = pairs.get(mid + 1 + i);
        }

        int left = 0;
        int right = 0;
        int s = start;

        while (left < lLen && right < rLen) {
            if (l[left].key <= r[right].key) {
                pairs.set(s, l[left]);
                left++;
            } else {
                pairs.set(s, r[right]);
                right++;
            }
            s++;
        }

        while (left < lLen) {
            pairs.set(s, l[left]);
            left++;
            s++;
        }

        while (right < rLen) {
            pairs.set(s, r[right]);
            right++;
            s++;
        }
    }
}
