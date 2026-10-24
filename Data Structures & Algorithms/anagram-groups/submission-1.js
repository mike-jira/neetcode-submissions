class Solution {
    /**
     * @param {string[]} strs
     * @return {string[][]}
     */
    groupAnagrams(strs) {
        const result = {}
        for (let s of strs) {
            const sortedS = s.split('').sort().join('');
            if (!result[sortedS]) {
                result[sortedS] = [];
            }
            result[sortedS].push(s);
        }
        return Object.values(result)
    }
}
