public class IntList {
    int first;
    IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. L is not allowed
     * to change. Must use recursion.
     *
     * This method is non-destructive非破坏性的, i.e. it must not modify the original
     * list.
     */
    public static IntList incrRecursiveNondestructive(IntList L, int x) {
        if (L == null) {
            return null;
        }
        return new IntList(L.first + x, incrRecursiveNondestructive(L.rest, x));
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. Modifies the original list.
     * You are not allowed to use "new" in this method.
     */
    public static IntList incrRecursiveDestructive(IntList L, int x) {
        if (L == null) {
            return null;
        }

        L.first += x;
        incrRecursiveDestructive(L.rest, x);
        return L;
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed
     * to use recursion. May not modify the original list.
     * 返回一个与L相同的IntList, 但每个元素的值都递增x.
     * 不允许使用递归, 不得修改原始列表.
     * 
     * 
     */
    public static IntList incrIterativeNondestructive(IntList L, int x) {
        IntList n = new IntList(L.first + x, null);
        IntList m = n;
        IntList p = L.rest;
        while (p != null) {
            m.rest = new IntList(p.first + x, null);
            m = m.rest;
            p = p.rest;
        }
        return n;
    }

    /**
     * Returns an IntList identical to L, but with
     * each element incremented by x. Not allowed
     * to use recursion. Modifies the original list.
     * You are not allowed to use "new" in this method.
     */
    public static IntList incrIterativeDestructive(IntList L, int x) {
        IntList p = L;
        while (p != null) {
            p.first += x;
            p = p.rest;
        }
        return L;
    }

    /**
     * Returns an IntList consisting of the elements of L1 followed by the
     * elements of L2.
     */
    public static IntList concatenate(IntList L1, IntList L2) {
        if (L2 == null)
            return L1;
        if (L1 == null)
            return L2;
        IntList p = L1;
        while (p.rest != null && p.rest.rest != null) {
            p = p.rest;
        }
        p.rest.rest = L2;
        return L1;
    }

    /*
     * =================================================================
     * OPTIONAL METHODS
     * =================================================================
     */

    /**
     * Returns the sum of all elements in the IntList.
     */
    public int sum() {
        // Optional: Fill in this code
        // if (rest == null)
        // return first;
        // return first + rest.sum();

        int total = 0;
        IntList p = this;
        while (p != null) {
            total += p.first;
            p = p.rest;
        }
        return total;
    }

    /**
     * Destructively adds x to the end of the list.
     */
    public void addLast(int x) {
        IntList p = this;
        while (p != null && p.rest.rest != null) {
            p = p.rest;
        }
        p.rest = new IntList(x, null);
    }

    /**
     * Destructively adds x to the front of this IntList.
     * This is a bit tricky to implement. The standard way to do this would be
     * to return a new IntList, but for practice, this implementation should
     * be destructive.
     */
    public void addFirst(int x) {
        // 关键技巧：创建一个新节点，其值为 x，rest 指向当前链表
        IntList newFirst = new IntList(this.first, this.rest);

        // 然后将当前节点的值改为 x
        this.first = x;

        // 最后将当前节点的 rest 指向刚刚创建的新节点
        this.rest = newFirst;
    }
}
