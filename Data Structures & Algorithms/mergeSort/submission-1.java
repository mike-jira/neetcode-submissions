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
        int length1 = mid - start + 1;
        int length2 = end - mid;

        // create temp array
        Pair[] l = new Pair[length1];
        Pair[] r = new Pair[length2];

        // copy element to temp array
        for (int i = 0; i < length1; i++) {
            l[i] = pairs.get(start + i);
        }

        for (int i = 0; i < length2; i++) {
            r[i] = pairs.get(mid + 1 + i);
        }

        // merge
        int left = 0;
        int right = 0;
        int s = start;

        while (left < length1 && right < length2) {
            if (l[left].key <= r[right].key) {
                pairs.set(s, l[left]);
                left++;
            } else {
                pairs.set(s, r[right]);
                right++;
            }
            s++;
        }

        while (left < length1) {
            pairs.set(s, l[left]);
            left++;
            s++;
        }

        while (right < length2) {
            pairs.set(s, r[right]);
            right++;
            s++;
        }
    }
}
