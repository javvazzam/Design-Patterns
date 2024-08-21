package chainofresposability.chainofresponsability2.basic;

class PaymentRequest {
    private double amount;
    private boolean isProcessed;

    public PaymentRequest(double amount) {
        this.amount = amount;
        this.isProcessed = false;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isProcessed() {
        return isProcessed;
    }

    public void setProcessed(boolean isProcessed) { 
        this.isProcessed = isProcessed;
    }
}

class PaymentProcessor {
    public void process(PaymentRequest request) {
        processCreditCard(request);
    }

    private void processCreditCard(PaymentRequest request) {
        System.out.println("Attempting Credit Card payment...");
        if (request.getAmount() <= 1000) {
            request.setProcessed(true);
            System.out.println("Payment processed using Credit Card.");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentRequest request = new PaymentRequest(1500);
        PaymentProcessor processor = new PaymentProcessor();

        System.out.println("Processing request:");
        processor.process(request);
        System.out.println("Payment processed: " + request.isProcessed());
    }
}

//I want to add two new types of payment request, PayPal and Crypto, but the requests could change in execution time