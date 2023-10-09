import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String onRepeat;
        ArrayList<Integer> orderofRes = new ArrayList<>();
        doublylinkedList list = new doublylinkedList();

        // 1 train car = 10 seats
        for (int i = 0; i < 10; i++) {
            list.insertAtEnd(0); // Initialize empty seats
        }

        do {
            System.out.println("Menu: Train Reservation System Console VR.");
            System.out.println(" (1) Available seats list \n (2) Check Seat availability \n (3) Reserve a seat \n (4) Cancel Reservation \n (5) Reserved seats list queue");

            int choiceMenu = scan.nextInt();
            switch (choiceMenu) {
                case 1:
                    listAvailableSeats.listavailableSeats(list);
                    list.displayForward();
                    break;
                case 2:
                    availsearch.isSeatAvailable(list);
                    list.displayForward();
                    break;
                case 3:
                    reserveSeat.reserveSeat(list, orderofRes);
                    list.displayForward();
                    break;
                case 4:
                    cancelReservation.cancelReservation(list, orderofRes);
                    list.displayForward();
                    break;
                case 5:
                    listReservedSeats.listreservedSeats(orderofRes);
                    list.displayForward();
                    break;
                default:
                    System.out.println("N/A Value inputted");
                    break;
            }

            System.out.print("Go back to Menu? (Yes/No): ");
            onRepeat = scan.next();
        } while (onRepeat.equalsIgnoreCase("Yes"));
    }
}

class reserveSeat {
    public static void reserveSeat(doublylinkedList list, ArrayList order) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Seat number to reserve: ");
        int seatNumber = scan.nextInt();
        Node current = list.getHead();
        int count = 1;

        while (current != null && count < seatNumber) {
            current = current.next;
            count++;
        }

        if (current != null) {
            // Set the seat value to the reservation, but check if it's not already reserved (-1)
            if (current.data == 0) {
                current.data = seatNumber;
                order.add(current.data);
            }
        }
    }
}
class cancelReservation{
    public static void cancelReservation(doublylinkedList list, ArrayList order){
        Scanner scan = new Scanner(System.in);
        System.out.print("Seat number to cancel reservation: ");
        int seatNumber = scan.nextInt();
        Node current = list.getHead();
        while(current!= null){
            if(current.data == seatNumber){
                current.data = 0;
                order.remove(Integer.valueOf(seatNumber));
            }
            current = current.next;
        }
    }
}

class availsearch {
    public static void isSeatAvailable(doublylinkedList list) {
        Node current = list.getHead();
        Scanner scan = new Scanner(System.in);
        System.out.print("Input seat number to check (1-10): ");
        int seatToCheck = scan.nextInt();

        boolean isAvailable = true; // Assume the seat is available by default

        while (current != null) {
            if (current.data == seatToCheck) {
                isAvailable = false; // Seat is reserved
                break; // No need to continue checking
            }
            current = current.next;
        }

        if (seatToCheck <= 10 && seatToCheck > 0) {
            if (isAvailable) {
                System.out.println("Seat " + seatToCheck + " is available.");
            } else {
                System.out.println("Seat " + seatToCheck + " is already reserved.");
            }
        } else {
            System.out.println("Seat N/A");
        }
    }
}

class listAvailableSeats{
    public static void listavailableSeats(doublylinkedList list){
        System.out.println("\nList of available seats");
        Node current = list.getHead();
        int counter = 1;

        while(current != null){
            if (current.data == 0){
                System.out.println("Seat "+ counter +" is available");
            }
            else{
                System.out.println("Seat "+ counter +" is already reserved");
            }
            current = current.next;
            counter++;

        }
    }
}

class listReservedSeats{
    public static void listreservedSeats (ArrayList orderofRes){
        System.out.println("\nReserved seats Queue: ");
        for(Object i: orderofRes){
            System.out.println(i);
        }

    }
}




