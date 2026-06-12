package Leetcode.June;

public class L3751_Total_Waviness_of_Numbers_in_Range_I {
    public static void main(String[] args) {
        int num1 = 4848, num2 = 4848;
        System.out.println(totalWaviness(num1, num2));
    }

    public static int totalWaviness(int num1, int num2) {
        int count = 0;

//        if (num1 > num2) {
//            for (int i = num2; i <= num1; i++) {
//                int a = i % 10;
//                int b = (i / 10) % 10;
//                int c = (i / 100) % 10;
//                if (((a>b) && (b<c)) || ((a<b) && (b>c))) count++;
//            }
//        }
//        if (num2 > num1) {
//            for (int i = num1; i <= num2; i++) {
//                int a = i % 10;
//                int b = (i / 10) % 10;
//                int c = (i / 100) % 10;
//                if (((a>b) && (b<c)) || ((a<b) && (b>c))) count++;
//            }
//        }

        for (int num = num1; num <= num2; num++) {
            count += getwaviness(num);
        }
        return count;
    }

    private static int getwaviness(int num) {
        int count = 0;
        String s = Integer.toString(num);
        char[] nums = s.toCharArray();

        for (int i = 1; i < nums.length - 1; i++) {
            if (((nums[i-1] > nums[i]) && (nums[i] < nums[i+1])) ||
                    ((nums[i-1] < nums[i]) && (nums[i] > nums[i+1])))
                count++;
        }

        return  count;
    }
}
