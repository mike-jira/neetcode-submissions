/** Pair class to store key-value pairs */
// class Pair {
//   /**
//    * @param {number} key The key to be stored in the pair
//    * @param {string} value The value to be stored in the pair
//    */
//   constructor(key, value) {
//       this.key = key;
//       this.value = value;
//   }
// }
class Solution {
    /**
     * @param {Pair[]} pairs
     * @returns {Pair[]}
     */
    quickSort(pairs) {
        this._quickSort(pairs, 0, pairs.length - 1)
        return pairs;
    }
    _quickSort(pairs, start, end) {
        if (end - start + 1 <= 1) {
            return;
        }

        let pivot = pairs[end];
        let swapPointer = start;

        for (let i = start; i < end; i++) {
            if (pairs[i].key < pivot.key) {
                const temp = pairs[swapPointer];
                pairs[swapPointer] = pairs[i];
                pairs[i] = temp;
                swapPointer++;
            }
        }

        pairs[end] = pairs[swapPointer];
        pairs[swapPointer] = pivot;

        this._quickSort(pairs, start, swapPointer - 1);
        this._quickSort(pairs, swapPointer + 1, end);
    }
}

