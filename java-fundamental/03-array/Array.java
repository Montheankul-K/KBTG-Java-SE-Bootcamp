public class Array {
    public static void main(String[] args) {
        String[] msg = { "Hello", "Hi" };
        System.out.println("msg[0]: " + msg[0]);
        System.out.println("msg[1]: " + msg[1]);

        msg[0] = "Greeting";
        System.out.println("msg[0]: " + msg[0]);

        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println("nums length: " + nums.length);
    }
}
