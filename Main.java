import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        doublylinkedList list = new doublylinkedList();
        Scanner scan = new Scanner(System.in);

        // 1 train car = 10 seats
        for (int i = 0; i < 10; i++) {
            list.insertAtEnd(0); // Initialize empty seats
        }



        // Reserve seat 5 and 7
        reserveSeat.reserveSeat(list, 7);
        reserveSeat.reserveSeat(list, 5);
        list.displayForward();
        System.out.print("Seat to check: ");

        int seatToCheck = scan.nextInt();
        if(seatToCheck <= 10 && seatToCheck > 0){
         if (availsearch.isSeatAvailable(list, seatToCheck)) {
            System.out.println("Seat " + seatToCheck + " is available.");
        } else{
            System.out.println("Seat " + seatToCheck + " is already reserved.");
        }
        }
        else{
            System.out.println("Seat N/A");
        }

        System.out.print("\nCancel Reserved Seat: ");
        int cancel;
        cancelReservation.cancelReservation(list,cancel = scan.nextInt());
        list.displayForward();


        listAvailableSeats.listavailableSeats(list);
        listReservedSeats.listreservedSeats(list);
    }
}

class reserveSeat {
    public static void reserveSeat(doublylinkedList list, int seatNumber) {
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
            }
        }
    }
}
class cancelReservation{
    public static void cancelReservation(doublylinkedList list, int seatNumber){
        Node current = list.getHead();
        while(current!= null){
            if(current.data == seatNumber){
                current.data = 0;
            }
            current = current.next;
        }
    }
}

class availsearch {
    public static boolean isSeatAvailable(doublylinkedList list, int seatNumber) {
        Node current = list.getHead();

        while (current != null) {
            if (current.data == seatNumber) {
                return false; // Seat is reserved
            }
            current = current.next;
        }
        return true; // Seat is available
    }
}

class listAvailableSeats{
    public static void listavailableSeats(doublylinkedList list){
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
    public static void listreservedSeats (doublylinkedList list){
        Node current = list.getHead();
        int counter = 1;


        while(current != null){
            if(current.data != 0){
                System.out.println();
            }
            current = current.next;
            counter++;

        }
    }
}




