package model;

public interface BonusChargable {

    static final int BONUS_POINTS_FOR_NEW_RELEASE = 2;
    static final int BONUS_POINTS_FOR_OTHER = 1;
    static final int BONUS_CHARGE_FOR_RENT = 25;

    void chargeBonus(FilmType type);

    void dischargeBonus();
}