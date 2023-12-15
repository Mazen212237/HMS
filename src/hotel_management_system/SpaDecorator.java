package hotel_management_system;

// Concrete decorator class for adding spa to the booking
class SpaDecorator implements BookingDecorator {
    // Spa cost
    private static final Double SPA_COST = 50.0;

    @Override
    public Double decorateBooking(Double currentTotal) {
        return currentTotal + SPA_COST;
    }
}
