import Customer.*;
import DaoOperation.daoOperation;
import ExitThread.mythread;

import java.util.InputMismatchException;
import java.util.Scanner;


public class main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);


        while(true){
            main_menu();
            System.out.println("enter the choice");
            int choice = sc.nextInt();
            switch (choice){
                case(1):
                    GuestDetails guest = new GuestDetails();
                    System.out.println("Enter customer ");
                    String GuestName= guest.setGuest_name(sc.next());
                    System.out.println("Enter Room Number");
                    String RoomNumber=guest.setRoom_number(sc.next());
                    System.out.println("Enter contact Number");
                    String contact_number= guest.setContact_number(sc.next());

                    // DB operation
                    daoOperation.addReservation(guest);

                    break;
                case (2):
                    daoOperation.seeAllReservations();
                    break;
                case (3):

                        System.out.print("Enter the ID :");
                        int id = sc.nextInt();
                        System.out.print("Enter the Name: ");
                        String name= sc.next();

                        // DB operation
                        daoOperation.getRoomNumber(id, name);

                    break;
                case (4):

                    System.out.print("Enter the ID :");
                    int update_id = sc.nextInt();
                    daoOperation.updateReservation(update_id);
                    break;

                case (5):
                    System.out.print("Enter the ID to delete:");
                    int delete_id= sc.nextInt();
                    daoOperation.deleteReservation(delete_id);
                    break;

                case (6):
                    mythread mythread=new mythread();
                    mythread.start();

                    break;

                default:
                    System.out.println("Invalid entry!!!!!!");
            }
        }

    }
    public static void main_menu(){
        System.out.println("---------Hotel Reservation System---------");
        System.out.println("1. Reserve a Room");
        System.out.println("2. View All Reservations");
        System.out.println("3. Get Room Number");
        System.out.println("4. Update Reservation");
        System.out.println("5. Delete Reservation");
        System.out.println("6. Exit");
    }
}
