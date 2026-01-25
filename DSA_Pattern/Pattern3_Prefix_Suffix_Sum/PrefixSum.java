package DSA_Pattern.Pattern3_Prefix_Suffix_Sum;

public class PrefixSum {
    public static void main(String[] args) {
        int[] nums = {-1,2,-3,2,4,-4};
        prefixSum(nums);
        for (int ele : nums) {
            System.out.print(ele + " ");
        }
    }

    public static void prefixSum(int[] arr) {
        int pre = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] += pre;
            pre = arr[i];
        }
    }
}
