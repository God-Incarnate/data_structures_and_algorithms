package algorithms.searching;

public class BinarySearch {
    static int[] sortedArr={2,5,6,8,9,15,16,17,18,21,55,97,113};

    static void main(String[] args) {

        //Since both the left and right boundaries in the "closed interval" representation are defined as closed,
        // the operations to narrow the interval through pointers and are also symmetric.
        // This makes it less error-prone, so the "closed interval" approach is generally recommended.
        System.out.println(binarySearchCloseIntervalMethod(15));

        System.out.println(binarySearchLeftClosedRightOpenIntervalMethod(55));
    }

    public static int binarySearchCloseIntervalMethod(int target) {
        int i=0,j=sortedArr.length-1,m=0;
        while (i<=j) {
            m=i+(j-i)/2;
            if (sortedArr[m]<target) {
                i=m+1;
            } else if (sortedArr[m]>target) {
                j=m-1;
            } else {
                return m;
            }
        }
        return -1;
    }

    public static int binarySearchLeftClosedRightOpenIntervalMethod(int target) {
        int i=0,j=sortedArr.length,m=0;

        while (i<j) {
            m=i+(j-i)/2;
            if (sortedArr[m]<target) {
                i=m+1;
            } else if (sortedArr[m]>target) {
                j=m;
            } else {
                return m;
            }
        }
        return -1;
    }
}
