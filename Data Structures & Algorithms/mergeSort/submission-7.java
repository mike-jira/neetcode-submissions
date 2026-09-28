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
        if (pairs.size() <= 1) {
            return pairs;
        }
        return s(0, pairs.size() - 1, pairs);
    }
    private List<Pair> s(int start, int end, List<Pair> pairs) {
        if (end - start + 1 <= 1) {
            return pairs;
        }

        int mid = start + (end - start) / 2;
        
        s(start, mid, pairs);
        s(mid + 1, end, pairs);
    
        m(start, mid, end, pairs);

        return pairs;
    }
    private void m(int start, int mid, int end, List<Pair> pairs) {
        int lLen = mid - start + 1;
        int rLen = end - mid;

        Pair[] l = new Pair[lLen];
        Pair[] r = new Pair[rLen];

        for (int i = 0; i < lLen; i++) {
            l[i] = pairs.get(start + i);
        }

        for (int i = 0; i < rLen; i++) {
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
