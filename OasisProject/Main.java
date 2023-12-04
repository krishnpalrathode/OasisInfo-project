package OasisProject;
import java.util.*;

class trainDetail
 {  
    private String TrainName;
    private String DateOfJourney;
    private String FromPlace;
    private String ToDestination;


    public trainDetail( String trainName, String dateOfJourney, String fromPlace, String toDestination)
    {
        this.TrainName = trainName;
        this.DateOfJourney = dateOfJourney;
        this.FromPlace = fromPlace;
        this.ToDestination = toDestination;
    }
    
    public String getTrainName() {
        return TrainName;
    }
    
    public String getDateOfJourney() {
        return DateOfJourney;
    }

    public String getFromPlace() {
        return FromPlace;
    }

    public String getToDestination() {
        return ToDestination;
    }

    public  void detail(){
        System.out.println("Your Journey's Information");
        System.out.println("\nTrain Name :"+getTrainName()+"\nDate of Journey :"+getDateOfJourney()+"\nFrom Place :"+getFromPlace() +
        "\nTo Destination :"+getToDestination());
    }
}


class ReservationSystem {

    Scanner sc=new Scanner(System.in);
    Map<String,trainDetail> userDatabase=new HashMap<String,trainDetail>();
     String PNR="12345567";

  public void addReservation(trainDetail reservation) 
    {
        userDatabase.put(PNR, reservation);
        System.out.println("Reservation Generated :"+PNR);

        // Save to database or perform necessary actions
    }
    
    public void cancelReservation() {
        System.out.println("Enter PNR Number :");
        String pnr=sc.nextLine();
        if(pnr.equals(PNR)){
            System.out.println("Enter 1 to confirm Camcellation");
            int key=sc.nextInt();
            if(key==1){
                userDatabase.remove(PNR);
            }
        }
    }
}

public class Main 
{
    private static Scanner sc=new Scanner(System.in);
    static trainDetail reservation;
   Map<String,trainDetail> hm=new HashMap<>();
    
  public static void main(String[] args)
    {
     
         ReservationSystem reservations=new ReservationSystem();

         System.out.println("Enter Login ID :");
         String loginId=sc.nextLine();

        System.out.println("---------------------------");

        System.out.println("Enter Password :");
        String pw=sc.nextLine();
       
        System.out.println("************************************");
      
        
        Authenticate(loginId,pw,reservations);
   
    }

   private  static void Authenticate(String loginID ,String pw,ReservationSystem reservations)
    {
        
        if(loginID.equals("Div123") && pw.equals("5443")){
      
              enterDetails(reservations);

        }
        else{
            System.out.println("Invalid Login Id or Password");
        }

    }

    private static void enterDetails(ReservationSystem reservations){

        System.out.println("     WELCOME \n\n"+"ENTER  YOUR  JOURNEY  DETAILS\n");
         System.out.println("************************************");
      
        
        
        System.out.println("Enter Train Name :");
          String trainName=sc.nextLine();
        System.out.println("---------------------------");

        System.out.println("Enter Date Of Journey :"); 
          String date=sc.nextLine();
System.out.println("---------------------------");
        System.out.println("Enetr Place of Train Boarding :");
          String place=sc.nextLine();
System.out.println("---------------------------");

        System.out.println("Enter Destination :");
          String destination=sc.nextLine();
System.out.println("---------------------------");

        System.out.println("Enter 1 to continue Booking :");
          int key=sc.nextInt();
System.out.println("---------------------------");
                    
        if(key==1){

        reservation=new trainDetail(trainName, date, place, destination);
          reservation.detail();
          reservations.addReservation(reservation);

          System.out.println("Enter 2 to Cancel Reservation");
          int cancel=sc.nextInt();

          if(cancel==2){
          reservations.cancelReservation();
          System.out.println("Reservation Cancelled with PNR"+reservations.PNR);
          }
          

        }

       

    }
}