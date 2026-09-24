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
        return merge(0, pairs.size() - 1, pairs);
    }
    private List<Pair> merge(int start, int end, List<Pair> pairs) {
        if (end - start + 1 <= 1) {
            return pairs;
        }

        int mid = start + (end - start) / 2;
        merge(start, mid, pairs);
        merge(mid + 1, end, pairs);

        sort(start, mid, end, pairs);

        return pairs;
    }
    private void sort(int start, int mid, int end, List<Pair> pairs) {
        int lLen = mid - start + 1;
        int rLen = end - mid;

        Pair[] l = new Pair[lLen];
        Pair[] r = new Pair[rLen];
        
        for (int i = 0; i < lLen; i++) {
            l[i] = pairs.get(start + i);
        }

        for (int j = 0; j < rLen; j++) {
            r[j] = pairs.get(mid + j + 1);
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
