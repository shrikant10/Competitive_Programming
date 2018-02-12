package Algorithms;

public class Fenwick_Tree_BIT {

    static int get_parent(int index) {
        return index - (index & -index);
    }

    static int get_next(int index) {
        return index + (index & -index);
    }

    static void update_BIT(int BIT[], int index, int val) {
        int n = BIT.length;
        while (index < n) {
            BIT[index] += val;
            index = get_next(index);
        }
    }

    static long get_sum(int BIT[], int index) {
        index++;    // sum from 0 to index
        long sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index = get_parent(index);
        }
        return sum;
    }

    static int[] create_BIT(int a[]) {
        int n = a.length;
        int BIT[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            update_BIT(BIT, i + 1, a[i]);
        }
        return BIT;
    }

    public static void main(String[] args) {
        int input[] = {1,2,3,4,5,6,7};
        int BIT[] = create_BIT(input);
        update_BIT(BIT, 2, 5);
        System.out.println(get_sum(BIT,0));
        System.out.println(get_sum(BIT,1));
        System.out.println(get_sum(BIT,2));
        System.out.println(get_sum(BIT,3));
        System.out.println(get_sum(BIT,4));
        System.out.println(get_sum(BIT,5));
        System.out.println(get_sum(BIT,6));

    }
}


/* get_parent - 1>find 2's complement of the no.
                2>& it with original no.
                3>subtract the result from original no.  */


/* get_next - 1>find 2's complement of the no.
                2>& it with original no.
                3>add the result to original no.  */