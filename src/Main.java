import model.*;

public class Main {
    public static void main(String[] args) {

        RentalStore rentalStore = new RentalStore();
        for (Film item : rentalStore.getInventory().getAllItems())
            System.out.println(item.getName() + " : " + item.getType() + " : " + item.isAvailable());

        System.out.println("----------------------------------");

        for (RentalTransaction rentalTransaction : rentalStore.getAllRentals()) {
            System.out.println(rentalTransaction.getPerson().getName() + " rents " + rentalTransaction.getItem().getName() + " on " + rentalTransaction.getDays() + " days. Total price: " + rentalTransaction.getPrice() + " EUR");
        }

    }
}
