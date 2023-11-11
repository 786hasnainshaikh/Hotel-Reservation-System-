package DaoOperation;
import DaoConnection.*;
import Customer.*;

import java.sql.*;
import java.util.Scanner;

public class daoOperation {
    static Scanner sc=new Scanner(System.in);
    static Connection con=connection.getConnection();

    public static void  addReservation(GuestDetails guest){
       String query="insert into reservations (Guest_name, Room_Number, Contact_Number) values(?,?,?)";
       try{

           PreparedStatement pstm= con.prepareStatement(query);

           pstm.setString(1, guest.getGuest_name());
           pstm.setString(2, guest.getRoom_number());
           pstm.setString(3, guest.getContact_number());

           int i = pstm.executeUpdate();
           if (i>0){
               System.out.println("Data inserted into database.......");
           }else {
               System.out.println("something went wrong");
           }
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public static void seeAllReservations(){
        String queery="select * from  reservations;";
        try{
            PreparedStatement pstm= con.prepareStatement(queery);
            ResultSet resultSet= pstm.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt(1);
                String guestName=resultSet.getString(2);
                int roomNumber=resultSet.getInt(3);
                String contactNumber=resultSet.getString(4);
                Timestamp timestamp= resultSet.getTimestamp(5);

                System.out.println("" +
                        "Guest ID: " + id +" "
                        + "Guest Name: " + guestName
                        +" " + "RoomNumber: "+roomNumber+" "
                        + "Contact Number: " +contactNumber+" "
                        + "Date: "+" "+ timestamp);
                System.out.println();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void getRoomNumber(int id, String name){
        String queery="select * from  reservations where Reservation_id=? and Guest_name=? ";
        try{
            PreparedStatement pstm= con.prepareStatement(queery);

            pstm.setInt(1,id);
            pstm.setString(2,name);

            ResultSet resultSet= pstm.executeQuery();
            if (resultSet.next()){
                int RoomNumber=resultSet.getInt("Room_Number");
                System.out.println("Room Number: " + RoomNumber );
            }
            else {
                System.out.println("please enter valid name and id");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public static void updateReservation(int update_id){

        // first check if reservation id not exist it will return and will not execute further
        if(!isReservationExist(update_id)){
            return;
        }

        System.out.println("Enter the new Guest Name");
        String new_name=sc.next();
        System.out.println("Enter the new Room number");
        int new_room_number= sc.nextInt();
        System.out.println("Enter the new Contact Number");
        String new_contact_number= sc.next();

        String queery ="update reservations set Guest_name=?, Room_Number=?, Contact_Number=?  where Reservation_id=?";
        try{
            PreparedStatement pstm= con.prepareStatement(queery);

            pstm.setString(1,new_name);
            pstm.setInt(2,new_room_number);
            pstm.setString(3, new_contact_number);
            pstm.setInt(4,update_id);

            int i = pstm.executeUpdate();

            if(i>0){
                System.out.println("Data Updated Successfully");
            }
            else{
                System.out.println("Something went wrong");
            }
        }catch (Exception e){
            e.printStackTrace();
        }


    }

    public static void deleteReservation(int delete_id){
        String queery="delete from reservations where Reservation_id=?";

        // first check if reservation id not exist it will return and will not execute further
        if(!isReservationExist(delete_id)){
            return;
        }

        try{
            PreparedStatement pstm= con.prepareStatement(queery);
            pstm.setInt(1, delete_id);
            int i = pstm.executeUpdate();
            if (i>0){
                System.out.println("Data is Deleted Successfully");
            }
            else {
                System.out.println("Something went wrong");
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public static boolean isReservationExist(int id){
        String queery="select Reservation_id from  reservations where Reservation_id=?";
        try{
            PreparedStatement pstm= con.prepareStatement(queery);
            pstm.setInt(1,id);

            ResultSet resultSet = pstm.executeQuery();
            if(resultSet.next()){
                System.out.println("Reservation exist");
                return resultSet.next();
            } else {
                System.out.println("Reservation not exist");
                return false;
            }
        }catch (Exception e){
            e.printStackTrace();
        } return false;
    }

}
