package Lab3;

import Lab3.Client.Client;
import Lab3.amenity.AType;
import Lab3.amenity.Amenity;
import Lab3.amenity.Category;
import Lab3.apartment.*;
import Lab3.booking.Booking;
import Lab3.booking.BProcess;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
public class Work {
    private static final String OPERATOR = "\n\n\n";

    public static void main(String[] args) {
        TestResources.cottage3.printInfo();
        System.out.println(OPERATOR);
        TestResources.hotel1.printInfo();
        System.out.println(OPERATOR);
        TestResources.hotel1.printRoomInfo(TestResources.room1); // subtask 4
        System.out.println(OPERATOR);

        BProcess bookingService = new BProcess();

        TestResources.checkIsDateAvailable(bookingService, TestResources.cottage1, TestResources.bookingDate1); // subtask 6
        try {
            bookingService.bookAccommodation(TestResources.client1, TestResources.cottage1, // subtask 7
                    TestResources.bookingDate1, TestResources.bookingDate2);
            bookingService.bookAccommodation(TestResources.client1, TestResources.cottage1,
                    TestResources.bookingDate1, TestResources.bookingDate1);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
        TestResources.checkIsDateAvailable(bookingService, TestResources.cottage1, TestResources.bookingDate1);

        bookingService.printBookings(); // Метод для виводу всіх бронювань

        try {
            System.out.println(bookingService.getBookingHistoryForAccommodation(TestResources.cottage1)); // subtask additional
            System.out.println(bookingService.getBookingHistoryForAccommodation(TestResources.cottage2));
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        System.out.println(OPERATOR);

        AccProcess accommodationService = new AccProcess(TestResources.getAccommodations(), bookingService.getBookingHistory());

        accommodationService.printStatistics(TestResources.cottage1); // 2000 * 0,8 = 1600 * 6 = 9600 + 2000 = 11600 subtask 8

        List<Accommodation> foundAccommodations = accommodationService.searchAccommodation(AType.WI_FI, Type.LUXURY); // subtask 10
        foundAccommodations.forEach(accommodation -> System.out.println(accommodation.getName()));
    }

    static class TestResources {
        private static final Amenity amenity1 = new Amenity(AType.WI_FI);
        private static final Amenity amenity2 = new Amenity(AType.KITCHEN);
        private static final Amenity amenity3 = new Amenity(AType.BATHROOM);
        private static final Amenity amenity4 = new Amenity(AType.SECOND_BATHROOM);
        private static final Amenity amenity5 = new Amenity(AType.SPA);
        private static final Amenity amenity6 = new Amenity(AType.FOOTBALL_STADIUM);
        private static final Amenity amenity7 = new Amenity(AType.SWIMMING_POOL);
        private static final Amenity amenity8 = new Amenity(AType.SOFA, 1, Capacity.ADULT);
        private static final Amenity amenity9 = new Amenity(AType.DOUBLE_SOFA, 2, Capacity.ADULT);
        private static final Amenity amenity10 = new Amenity(AType.CHILD_BED, 1, Capacity.CHILD);
        private static final Amenity amenity11 = new Amenity(AType.DOG_HOUSE, 1, Capacity.ANIMAL);

        private static final Accommodation cottage1 = new Cottage("Cottage 1", Type.ECONOMIC, 3, 2000,
                new ArrayList<>(List.of(amenity1, amenity2, amenity3, amenity5, amenity9)));
        private static final Accommodation cottage2 = new Cottage("Cottage 2", Type.STANDARD, 6, 2500,
                new ArrayList<>(List.of(amenity1, amenity2, amenity3, amenity5, amenity8)));
        private static final Accommodation cottage3 = new Cottage("Cottage 3", Type.LUXURY, 10, 5000,
                new ArrayList<>(List.of(amenity1, amenity2, amenity3, amenity4, amenity5, amenity6, amenity7, amenity10)));
        private static final Accommodation cottage4 = new Cottage("Cottage 4", Type.LUXURY, 3, 7000,
                new ArrayList<>(List.of(amenity1, amenity2, amenity3, amenity4, amenity5, amenity6, amenity7, amenity11)));

        private static final Room room1 = new Room("Room 1", Type.APARTMENT, 3, 800,
                new ArrayList<>(List.of(amenity1, amenity2, amenity10)));
        private static final Room room2 = new Room("Room 2", Type.APARTMENT, 4, 1000,
                new ArrayList<>(List.of(amenity1, amenity4, amenity9)));
        private static final Room room3 = new Room("Room 3", Type.APARTMENT, 3, 1500,
                new ArrayList<>());

        private static final Hotel hotel1 = new Hotel("Hotel 1", 5000, Type.LUXURY,
                new ArrayList<>(List.of(amenity1, amenity2, amenity3, amenity11)),
                new ArrayList<>(List.of(room1, room2, room3)));

        private static final Client client1 = new Client("Ivan", "Ivanenko", "+380123456789", "ivan@gmail.com");

        private static final LocalDate bookingDate1 = LocalDate.parse("2024-03-26");
        private static final LocalDate bookingDate2 = LocalDate.parse("2024-04-02");

        private static List<Accommodation> getAccommodations() {
            return List.of(cottage1, cottage2, cottage3, cottage4, room1, room2, room3, hotel1);
        }

        private static void checkIsDateAvailable(BProcess bookingService, Accommodation accommodation, LocalDate date) {
            if (bookingService.isDateAvailable(accommodation, date)) {
                System.out.println("Accommodation " + accommodation.getName() + " is available on " + date);
            } else {
                System.err.println("Accommodation " + accommodation.getName() + " is NOT available on " + date);
            }
        }

        private TestResources() {
            throw new IllegalStateException("Utility class");
        }
    }
}