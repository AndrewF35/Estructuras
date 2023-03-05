package nonSequential;

public class DisjointUnionSets {
    private int[] rank, parent;

    public DisjointUnionSets() {
        this(10);
    }

    public DisjointUnionSets(int capacity) {
        this.rank = new int[capacity];
        this.parent = new int[capacity];
        this.makeSet();
    }


    public int find(int x) {
        if(parent[x] != x) {
            parent[x] = this.find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = this.find(x);
        int yRoot = this.find(y);
        if(xRoot == yRoot) return; //The values belong to the same set
        if(rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else { //The tree has the same size
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }

    private void makeSet() {
        for (int i = 0; i< this.parent.length; i++) {
            this.parent[i] = i;
            this.rank[i] = 0;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Elements: ");
        StringBuilder sb1 = new StringBuilder();
        sb1.append("Parents:  ");
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Ranks:    ");
        StringBuilder sb3 = new StringBuilder();

        for (int i = 0; i < this.parent.length; i++) {
            sb.append(i + " ");
            sb1.append(parent[i] + " ");
            sb2.append(rank[i] + " ");
        }

        sb3.append(sb.toString() + "\n");
        sb3.append(sb1.toString() + "\n");
        sb3.append(sb2.toString());

        return sb3.toString();

    }
}
