package observer.antipattern;

class StockDisplay {
    public void update(float price) {
        System.out.println("Stock Display: Price updated to " + price);
    }
}

class StockLogger {
    public void update(float price) {
        System.out.println("Stock Logger: Price logged at " + price);
    }
}

class StockAlert {
    public void update(float price) {
        if (price > 100) {
            System.out.println("Stock Alert: Price exceeded $100!");
        }
    }
}

class Stock {
    private float price;

    public void setPrice(float price) {
        this.price = price;
    }
}

