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
        return split(0, pairs.size() - 1, pairs);
    }
    private List<Pair> split(int start, int end, List<Pair> pairs) {
        if (end - start + 1 <= 1) {
            return pairs;
        }

        int mid = start + (end - start) / 2;

        split(start, mid, pairs);
        split(mid + 1, end, pairs);

        sort(start, mid, end, pairs);

        return pairs;
    }
    private void sort(int start, int mid, int end, List<Pair> pairs) {
        int lLen = mid - start + 1;
        int rLen = end - mid;

        Pair[] left = new Pair[lLen];
        Pair[] right = new Pair[rLen];

        for (int i = 0; i < lLen; i++) {
            left[i] = pairs.get(start + i);
        }

        for (int i = 0; i < rLen; i++) {
            right[i] = pairs.get(mid + i + 1);
        }

        int l = 0;
        int r = 0;
        int s = start;

        while (l < lLen && r < rLen) {
            if (left[l].key <= right[r].key) {
                pairs.set(s, left[l]);
                l++;
            } else {
                pairs.set(s, right[r]);
                r++;
            }
            s++;
        }

        while (l < lLen) {
            pairs.set(s, left[l]);
            l++;
            s++;
        }

        while (r < rLen) {
            pairs.set(s, right[r]);
            r++;
            s++;
        }
    }
}
