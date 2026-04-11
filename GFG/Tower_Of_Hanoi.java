package GFG;

class Tower_Of_Hanoi {
    public static void towerOfHanoi(int n, char fromRod, char toRod, char auxRod){
        if (n == 0) return;
        towerOfHanoi(n - 1, fromRod, auxRod, toRod);
        System.out.println("Disk " + n + " moved from " + fromRod + " to " + toRod);
        towerOfHanoi(n - 1, auxRod, toRod, fromRod);
    }

    public static void main(String args[]){
        int n = 4;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}