public class Main {
    public static void main(String[] args) {
        // object
        Loan johnLoan = new Loan("home loan", 30000.0d, 8.5f);
        // ควรใช้ constructor แทนการแก้ไข attrribute โดยตรง
        // johnLoan.applicationName = "home loan";
        // johnLoan.loanAmount = 30000.0d;
        // johnLoan.interestedRate = 8.5f;
        System.out.println(johnLoan);
        System.out.println();

        johnLoan.setInterestRate(9.5f);
        System.out.println("Interest Rate: " + johnLoan.getInterestRate());
        System.out.println("Interest: " + johnLoan.calInterest());
        System.out.println();

        Loan janeLoan = new Loan("corporate loan", 35000.0d, 8.0f);
        System.out.println(janeLoan);
        System.out.println("Interest: " + johnLoan.calInterest(35000.0d, 8.0f));
        System.out.println();

        Loan jameLoan = new Loan("corporate loan");
        System.out.println(jameLoan);
    }
}
