public class Loop {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("i: " + i);
        }
        System.out.println();

        int[] numbers = { 1, 2, 3, 4, 5 };
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("numbers[%d]: %d".formatted(i, numbers[i]));
        }
        System.out.println();

        int i = 0;
        while (i < numbers.length) {
            System.out.println("numbers[%d]: %d".formatted(i, numbers[i]));
            i++;
        }
        System.out.println();

        int[] nums = { 1, 2, 3, 4, 5 };
        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            if (n % 2 == 0) {
                System.out.println("%d: is even.".formatted(nums[j]));
            } else if (n == 3) {
                System.out.println("%d: is three.".formatted(nums[j]));
            } else {
                System.out.println("%d: is odd.".formatted(nums[j]));
            }
        }
    }
}
