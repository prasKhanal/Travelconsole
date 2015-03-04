
package assignment1;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class TravelAgent implements java.io.Serializable {
	private String name;
	private HashMap customers = new HashMap(0);
	private HashMap flights = new HashMap(0);
   
     
       public TravelAgent(){}
	public TravelAgent(String name) {
           this.name=name;
           
	}

   public String getName() {
       return name;
   }

   public void setName(String name) {
       this.name = name;
   }
       

	public int addCustomer(String name,String surName, int childSeats, int adultSeats) {
		Customer c = new Customer(name, surName,childSeats, adultSeats);
	
         customers.put(c.getId(), c);
		return c.getId();
       
	}

	public int addBusinessFlight(String origin, String destination,Date date, int etd, int eta, double baseprice, double concession,double rate) {
           
          BusinessFlight fly = new BusinessFlight (origin, destination, date, etd, eta, baseprice, concession,rate);
          
           flights.put(fly.getFlightnum(), (Flight)fly);
           return fly.getFlightnum();
	}
       
       
       
       
       
       public int addEconomyFlight(String origin, String destination,Date date, int etd, int eta, double baseprice, double concession,double groupDiscount) {
           
          EconomyFlight fly = new EconomyFlight (origin, destination, date, etd, eta, baseprice, concession,groupDiscount);
           
           flights.put(fly.getFlightnum(), fly);
           
           
           return fly.getFlightnum();
           
       }
       
     public void addMovies(Movie movie, Flight flight){
      flight.addMovies(movie);
     }
       
     public HashMap getCustomerList(){
     return customers;
     }  
     public HashMap getFlightList(){
     return flights;
     }
       
     public void showCustomerId(){
     System.out.println("Customer:"+customers.keySet());
     }
     public void showFlightID(){
         System.out.println("Flight:"+flights.keySet());
     }
    public void runMaxCustomerId(){
        if(!customers.isEmpty()){
    ArrayList<Integer> intKeys = new ArrayList<Integer>(customers.keySet());
    int a = Collections.max(intKeys);
    Customer.setLastID(a);
    System.out.println("Max CustomerId Set To: "+a);
     
     }}
    public void runMaxFlightId(){
        if(!flights.isEmpty()) {
    ArrayList<Integer> intKeys = new ArrayList<Integer>(flights.keySet());
    int a = Collections.max(intKeys);
    Flight.setLastID(a);
    System.out.println("Max Flight Id Set To: "+a);
        }
     
     }
     public Customer getCustomer(int map){
     return ( (Customer)customers.get(map));
     }
     public Flight getFlight(int map){
     return ( (Flight)flights.get(map));
     }
     public int numberOfFlight(){return flights.size();}
     
     public String deleteCustomer(int a){
        Customer c = (Customer) customers.get(a);
        Iterator i= c.getFlight().iterator();
        while(i.hasNext()){
        getFlight((Integer)i.next()).removeCustomer(a);
        }
         customers.remove(a);
         
        
     return "Customer Deleted";
     }
     public String BookTicket(int CustomerId,int FlightId){
         Customer cust= getCustomer(CustomerId);
         Flight fly=getFlight(FlightId);
         double cost=0;
       if(fly instanceof BusinessFlight){
             cost=((BusinessFlight)(fly)).book(cust);
             cust.addFlight(FlightId);
             fly.addCustomer(CustomerId);
        }
     
     
       else {if(fly instanceof EconomyFlight){
            cost=((EconomyFlight)(fly)).book(cust);
            cust.addFlight(FlightId);
            fly.addCustomer(CustomerId);
        }}
        return "\nTotal Cost of Ticket is:"+cost;
        
     }
    public  Object[][] getCustomerDimension()  {
Object[][] list=new Object[50][7];
if(customers.size()>0){
   int i=0;
Iterator iterator = customers.keySet().iterator();
   while (iterator.hasNext()){
       int key = iterator.next().hashCode();
    
       list[i][0]=getCustomer(key).getId();
       list[i][1]=getCustomer(key).getName();
       list[i][2]=getCustomer(key).getSurName();
       list[i][3]=getCustomer(key).getAdultSeats();
       list[i][4]=getCustomer(key).getChildSeats();
       list[i][5]=getCustomer(key).getFlight().toString();
       list[i][6]=getCustomer(key).getCost();
       i++;
   }}
return list;
} 
    public Object[][] getFlightDimension(){
        Object[][] list=new Object[50][8];
        if(flights.size()>0){
       int i=0;
      Iterator iterator = flights.keySet().iterator();
      while (iterator.hasNext()){
       int key = iterator.next().hashCode();
       
       list[i][0]=getFlight(key).getFlightnum();
       list[i][1]=getFlight(key).getOrigin();
       list[i][2]=getFlight(key).getDestination();
       list[i][3]=getFlight(key).getDate();
       list[i][4]=getFlight(key).getEta();
       list[i][5]=getFlight(key).getBaseprice();
       list[i][6]=getFlight(key).getConcession();
       if(getFlight(key) instanceof BusinessFlight )
           list[i][7]="Business";
       if(getFlight(key) instanceof EconomyFlight )
           list[i][7]="Economy";
     
       i++;
       }
   }
      return list;      
        }
    public Object[][] getMovieDimension(){
        Object[][] list=new Object[50][3];
       int i=0;
      Iterator iterator = flights.keySet().iterator();
      while (iterator.hasNext()){
       int key = iterator.next().hashCode();
       if(!getFlight(key).getMovieList().isEmpty()){
       list[i][0]=getFlight(key).getFlightnum();
       Iterator<Movie> it=getFlight(key).getMovieList().iterator();
       while(it.hasNext()){
           Movie movie=it.next();
       list[i][1]=movie.getName();
       list[i][2]=movie.getLength();
       i++;
       System.out.print(i+",");
       }
       }
    }
      return list;
        }
    public static Date processDate(String date) throws ParseException {
		DateFormat dfs = DateFormat.getDateInstance(DateFormat.SHORT);
		Date then = null;
       then = dfs.parse(date);
       return then;
	}

   public String deleteFlight(Integer cId) {
      Flight c = (Flight) flights.get(cId);
        Iterator i= c.getCustomer().iterator();
        while(i.hasNext()){
        getCustomer((Integer)i.next()).removeFlight(cId);
        }
         flights.remove(cId);
            
     return "Customer Deleted";
   }
    }