public class Main {
    public static void main(String[] args) {
        // สามารถใช้ type เป็น type ของ class แม่ก็ได้
        Mortgage mortgage = new Mortgage("mortgage loan", 10000.0d, 7.5f);
        System.out.println(mortgage);
        double rate = mortgage.calculateInterest();
        System.out.println("Interest: " + rate);
        System.out.println();

        Auto auto = new Auto("auto loan", 10000.0d, 7.5f);
        System.out.println(auto);
        double rate2 = auto.calculateInterest();
        System.out.println("Interest: " + rate2);
        System.out.println();
    }
}
