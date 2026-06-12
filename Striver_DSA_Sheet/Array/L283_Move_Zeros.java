package Striver_DSA_Sheet.Array;

public class L283_Move_Zeros {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeros(nums);
        for (int ele : nums) System.out.print(ele + " ");
    }

    private static void moveZeros(int[] nums) {
        int n = nums.length;
        int insertPos = 0; // Pointer for the position to insert the next non-zero element

        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                nums[insertPos] = nums[i];
                insertPos++;
            }
        }

        for (int i = insertPos; i < n; i++) {
            nums[i] = 0;
        }
    }
}
