import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("auto loan");
        // Auto เป็นได้ทั้ง type Loan และ BaseLoan ทำให้เห็นพฤติกรรมของทั้ง 2 type
        auto.calculateInterest();
        System.out.println(Arrays.toString(auto.paymentOptions()));
    }
}
