//Модуль 09 Структурные паттерны. Адаптер
interface IPaymentProcessor {
    void processPayment(double amount);
}

class PayPalPaymentProcessor implements IPaymentProcessor {
    @Override
    public void processPayment(double amount) {
        System.out.println("Обработка платежа PayPal в размере $" + amount);
    }
}

class StripePaymentService {
    public void makeTransaction(double totalAmount) {
        System.out.println("Обработка платежа Stripe в размере $" + totalAmount);
    }
}

class StripePaymentAdapter implements IPaymentProcessor {
    private StripePaymentService stripeService;

    public StripePaymentAdapter(StripePaymentService stripeService) {
        this.stripeService = stripeService;
    }

    @Override
    public void processPayment(double amount) {
        stripeService.makeTransaction(amount);
    }
}

class SquarePaymentService {
    public void executePayment(double amount) {
        System.out.println("Обработка платежа Square в размере $" + amount);
    }
}

class SquarePaymentAdapter implements IPaymentProcessor {
    private SquarePaymentService squareService;

    public SquarePaymentAdapter(SquarePaymentService squareService) {
        this.squareService = squareService;
    }

    @Override
    public void processPayment(double amount) {
        squareService.executePayment(amount);
    }
}

public class Main_2 {
    public static void main(String[] args) {
        IPaymentProcessor paypalProcessor = new PayPalPaymentProcessor();
        IPaymentProcessor stripeProcessor = new StripePaymentAdapter(new StripePaymentService());
        IPaymentProcessor squareProcessor = new SquarePaymentAdapter(new SquarePaymentService());
        paypalProcessor.processPayment(100.0);
        stripeProcessor.processPayment(150.0);
        squareProcessor.processPayment(200.0);
    }
}

