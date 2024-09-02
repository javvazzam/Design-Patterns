package facade.antipattern;

class AccountService {
    public void createAccount(String accountType) {
        System.out.println("Creating a " + accountType + " account.");
    }
}

class CustomerService {
    public void addCustomer(String name) {
        System.out.println("Adding customer " + name);
    }
}

class LoanService {
    public void applyForLoan(String loanType, double amount) {
        System.out.println("Applying for a " + loanType + " loan of " + amount);
    }
}

class BankClient {
    public static void main(String[] args) {
        CustomerService customerService = new CustomerService();
        AccountService accountService = new AccountService();
        LoanService loanService = new LoanService();

        customerService.addCustomer("John Doe");
        accountService.createAccount("Savings");

        loanService.applyForLoan("Home", 100000);

        customerService.addCustomer("Jane Doe");
        accountService.createAccount("Checking");
        loanService.applyForLoan("Auto", 20000);
    }
}

