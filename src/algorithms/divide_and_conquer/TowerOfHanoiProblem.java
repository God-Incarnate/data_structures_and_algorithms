package algorithms.divide_and_conquer;

public class TowerOfHanoiProblem {
    static void main(String[] args) {

        towerOfHanoi(3,'A','B','C');
    }

    public static void towerOfHanoi(int n, char src,char destination,char auxiliary){
        if( n==1){
            System.out.println("Move Disk 1 from: "+src+" -> "+destination);
            return;
        }

        towerOfHanoi(n-1,src,auxiliary,destination);

        System.out.println("Move Disk "+n+" from: "+src+" -> "+destination);

        towerOfHanoi(n-1,auxiliary,destination,src);
    }
}
