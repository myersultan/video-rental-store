package model;

import java.util.List;

public interface RentalDAO {
    void rentItem(Person person, Film item, int days, Boolean termsAcceptance);

    List<RentalTransaction> getAllRentals();

    List<RentalTransaction> getAllRentalsForCustomer(Person person);
}
