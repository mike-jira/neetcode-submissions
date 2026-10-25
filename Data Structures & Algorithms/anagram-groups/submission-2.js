class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        const result = {}
        for (const string of strs) {
            const sortedString = string.split('').sort().join()
            if (!result[sortedString]) {
                result[sortedString] = [];
            }
            result[sortedString].push(string);
        }
        return Object.values(result);
    }
}
