public class Loan {
    private String applicantName;
    private double loanAmount;
    private float interestRate;

    public Loan(String applicantName) {
        this.applicantName = applicantName;
    }

    public Loan(String applicantName, double loanAmount, float interestRate) {
        this.applicantName = applicantName;
        this.loanAmount = loanAmount;
        this.interestRate = interestRate;
    }

    public static void info() {
        // static method จะติดอยู่กับ class ไม่ได้ติดอยู่กับ instance ไม่สามารถ refer attribute ได้
        System.out.println("Loan:: static - info()");
    }

    public void show() {
        System.out.println("Loan:: show()" + this.applicantName);
    }

    public String toString() {
        return "Applicant Name: " + applicantName + "\n" + "Loan Amount: " + loanAmount + "\n" + "Interest Rate: "
                + interestRate;
    }
}
