public class Main {
    public static void main(String[] args) {
        Loan loanA = new Loan("p loan", 20000.0d, 8.5f);
        loanA.calculateInterest();
        System.out.println(loanA);
        System.out.println();

        Mortgage loanB = new Mortgage("mortgage loan", 21000.0d, 8.0f);
        loanB.calculateInterest();
        System.out.println(loanB);
        System.out.println();

        Auto loanC = new Auto("corporate loan", 20500.0d, 9.0f);
        loanC.calculateInterest();
        System.out.println(loanC);
    }
}
