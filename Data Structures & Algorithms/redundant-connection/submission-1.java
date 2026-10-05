class Solution {
    private class DSU {
        int[] parents;
        int[] rank;

        public DSU(int size) {
            this.parents = new int[size];
            this.rank = new int[size];

            for (int i = 1; i < size; i ++) this.parents[i] = i;
        }

        public int find(int i) {
            if (this.parents[i] != i) this.parents[i] = find(this.parents[i]);
            return this.parents[i];
        }

        public int[] union(int i, int j) {
            int parentI = this.find(i);
            int parentJ = this.find(j);

            if (parentI == parentJ) return new int[]{i + 1, j + 1};

            int rankI = rank[parentI];
            int rankJ = rank[parentJ];

            if (rankI > rankJ) {
                this.parents[parentJ] = parentI;
            } else if (rankJ > rankI) {
                this.parents[parentI] = parentJ;
            } else {
                this.parents[parentJ] = parentI;
                rank[parentI] ++;
            }
            return null;
        }
    }
    
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu = new DSU(edges.length);
        for (int i = 0; i < edges.length; i ++) {
            int[] result = dsu.union(edges[i][0] - 1, edges[i][1] - 1);
            if (result != null) return result;
        }
        return new int[0];
    }
}
