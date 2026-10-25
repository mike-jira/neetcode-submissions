class Solution {
    /**
     * @param {character[][]} board
     * @return {boolean}
     */
    isValidSudoku(board) {
        const map = {
            x: Object.assign(
                {},
                ...Array.from({ length: 9 }, (_, i) => ({ [i]: {} }))
            ),
            y: Object.assign(
                {},
                ...Array.from({ length: 9 }, (_, i) => ({ [i]: {} }))
            ),
            g: Object.assign(
                {},
                ...Array.from({ length: 9 }, (_, i) => ({ [i]: {} }))
            )
        }

        for (let i = 0; i < 9; i++) {
            for (let j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    const currentGridNo = this.findGridNo(j, i);
                    if (map.x[i][board[i][j]] || map.y[j][board[i][j]] || map.g[currentGridNo][board[i][j]]) {
                        return false;
                    }
                    map.x[i][board[i][j]] = true;
                    map.y[j][board[i][j]] = true;
                    map.g[currentGridNo][board[i][j]] = true;
                }
            }
        }

        return true;
    }
    findGridNo(x, y) {
        if (x < 3) {
            if (y < 3) {
                return 0
            } else if (y < 6) {
                return 1
            } else {
                return 2
            }
        } else if (x < 6) {
            if (y < 3) {
                return 3
            } else if (y < 6) {
                return 4
            } else {
                return 5
            }
        } else {
            if (y < 3) {
                return 6
            } else if (y < 6) {
                return 7
            } else {
                return 8
            }
        }
    }
}
