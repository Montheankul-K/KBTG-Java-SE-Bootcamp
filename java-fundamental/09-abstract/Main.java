public class Main {
    public static void main(String[] args) {
        Auto auto = new Auto("auto loan", 10000.0d, 7.5f);
        auto.calculateInterest();
        System.out.println(auto.getApplicantName());
        System.out.println();

        Mortgage mortgage = new Mortgage("mortgage loan", 15000.0d, 8.5f);
        mortgage.calculateInterest();
        System.out.println(mortgage.getApplicantName());
    }
}
