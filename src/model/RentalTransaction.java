package model;

public class RentalTransaction {

    private static final double PREMIUM_FEE = 40;
    private static final double REGULAR_FEE = 30;

    private Person person;
    private Film item;
    private int days;
    private double price;
    private boolean termsAcceptance;

    public RentalTransaction(Person person, Film item, int days, boolean termsAcceptance) {
        this.person = person;
        this.item = item;
        this.days = days;
        this.price = calculate();
        this.termsAcceptance = termsAcceptance;
    }

    public Person getPerson() {
        return person;
    }

    public Film getItem() {
        return item;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
        this.price = calculate();
    }

    public double getPrice() {
        return price;
    }

    private double calculate() {
        switch (item.getType()) {
            case NEW:
                this.price = PREMIUM_FEE * days;
                break;
            case REGULAR:
                if (days > 3) {
                    this.price = REGULAR_FEE + REGULAR_FEE * (days - 3);
                } else {
                    this.price = REGULAR_FEE * days;
                }
                break;
            case OLD:
                if (days > 5) {
                    this.price = REGULAR_FEE + REGULAR_FEE * (days - 5);
                } else {
                    this.price = REGULAR_FEE * days;
                }
                break;
        }
        return this.price;
    }

    public boolean isTermsAccepted() {
        return termsAcceptance;
    }

    public void setTermsAcceptance(boolean termsAcceptance) {
        this.termsAcceptance = termsAcceptance;
    }
}


