class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        if (m == 0) return new int[0];
        int n = mat[0].length;

        List<Integer> res = new ArrayList<>();
        boolean flag = true; // reverse first diagonal as in standard solution

        // Phase 1: start at top row, columns 0..n-1
        for (int col = 0; col < n; col++) {
            List<Integer> list = new ArrayList<>();
            int r = 0, c = col;
            while (r < m && c >= 0) {
                list.add(mat[r][c]);
                r++; c--;
            }
            if (flag) Collections.reverse(list);
            flag = !flag;
            res.addAll(list);
        }

        // Phase 2: start at last column, rows 1..m-1
        for (int row = 1; row < m; row++) {
            List<Integer> list = new ArrayList<>();
            int r = row, c = n - 1;
            while (r < m && c >= 0) {
                list.add(mat[r][c]);
                r++; c--;
            }
            if (flag) Collections.reverse(list);
            flag = !flag;
            res.addAll(list);
        }

        // convert to array
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) ans[i] = res.get(i);
        return ans;
    }
}
