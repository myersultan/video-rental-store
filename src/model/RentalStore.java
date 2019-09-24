package model;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class RentalStore implements RentalDAO {

    private Inventory inventory;
    private List<RentalTransaction> rentalTransactions;

    public RentalStore() {
        this.inventory = new Inventory();
        this.rentalTransactions = new LinkedList<>();
        generateFakeRentalTransactions();
    }

    public Inventory getInventory() {
        return inventory;
    }

    private void generateFakeRentalTransactions() {
        rentItem(new Customer("Customer1"), inventory.getAllAvailableItems().get(new Random().nextInt(inventory.getAllAvailableItems().size() - 1) + 1), new Random().nextInt(30) + 1, true);
        rentItem(new Customer("Customer2"), inventory.getAllAvailableItems().get(new Random().nextInt(inventory.getAllAvailableItems().size() - 1) + 1), new Random().nextInt(30) + 1, true);
    }

    @Override
    public void rentItem(Person person, Film item, int days, Boolean termsAcceptance) {
        if (item.isAvailable()) {
            RentalTransaction newRentalTransaction = new RentalTransaction(person, item, days, termsAcceptance);

            if (!rentalTransactions.contains(newRentalTransaction)) {
                rentalTransactions.add(newRentalTransaction);
            }
        }
    }

    @Override
    public List<RentalTransaction> getAllRentals() {
        return rentalTransactions;
    }

    @Override
    public List<RentalTransaction> getAllRentalsForCustomer(Person person) {
        List<RentalTransaction> rentalTransactionsForCustomer = new LinkedList<>();
        for (RentalTransaction rentalTransaction : rentalTransactions) {
            if (rentalTransaction.getPerson().equals(person)) {
                rentalTransactionsForCustomer.add(rentalTransaction);
            }
        }
        return rentalTransactionsForCustomer;
    }

}


