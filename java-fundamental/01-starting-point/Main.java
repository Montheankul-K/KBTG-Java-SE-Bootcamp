public class Main {

    public static void main(String[] args) {
        // statically type language : ภาษาทื่ต้องรู้ type ขณะ compile time
        String greeting = "Hello World";
        System.out.println("string: " + greeting);

        int loanTerm = 8;
        System.out.println("int: " + loanTerm);

        float interestRate = 7.5f;
        System.out.println("float: " + interestRate);

        double loanAmount = 10000.0d;
        System.out.println("double: " + loanAmount);

        boolean isApprove = true;
        System.out.println("boolean: " + isApprove);

        char grade = 'A';
        // char ใช้ ''
        System.out.println("char: " + grade);
    }
}

// javac : compile >> จะได้ Main.class
// java : run >> run Main.class