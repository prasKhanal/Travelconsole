package assignment1;


import java.util.*;
import java.text.*;

public abstract class Flight implements java.io.Serializable  {

   private static int lastFlightnum = 100;
   private  int flightnum;
   private String origin;
   private String destination;
   private Date date;
   private int etd;
   private int eta;
   protected double baseprice;
   protected double concession;
   private List <Integer> customer=new ArrayList(0);
   private List<Movie> movies = new ArrayList<Movie>(0);

   protected Flight() {
       //no arg constructor
        this.flightnum = ++lastFlightnum;
   }

   public Flight(String origin, String destination, Date date, int etd, int eta, double baseprice, double concession) {
       this.flightnum = ++lastFlightnum;
       this.origin = origin;
       this.destination = destination;
       this.date = date;
       this.etd = etd;
       this.eta = eta;
       this.baseprice = baseprice;
       this.concession = concession;
      
   }
   public List getCustomer(){return customer;}
   
   public void addCustomer(int customer){
       this.customer.add(customer);
       }
   public void removeCustomer(int customer){
       this.customer.remove((Object)customer);
   }

   public String getOrigin() {
       return origin;
   }

   public void setOrigin(String origin) {
       this.origin = origin;
   }

   public void setDestination(String destination) {
       this.destination = destination;
   }

   public String getDestination() {
       return destination;
   }

   public void setDate(Date date) {
       this.date = date;
   }
public int getFlightnum(){
   return flightnum;
}
   public Date getDate() {
       return date;
   }

   public void setEtd(int etd) {
       this.etd = etd;
   }

   public int getEtd() {
       return etd;
   }

   public void setEta(int eta) {
       this.eta = eta;

   }

   public int getEta() {
       return eta;
   }

   public void setBaseprice(double baseprice) {
       this.baseprice = baseprice;

   }

   public double getBaseprice() {
       return baseprice;
   }

   public void setConcession(double concession) {
       this.concession = concession;

   }

   public double getConcession() {
       return concession;
   }

   public String toString() {
       

       return  "getFlightnum()";
   }
  public String addMovies(Movie movie){
    
  boolean contain=false;
    for(int i=0;i<movies.size();i++){
        if(movie.equals(movies.get(i))){
          contain=true;
      
      }}
        if(contain&&!movies.isEmpty()){return "Movie is already in the List";}
        else{movies.add(movie);
        return movie.toString()+"Added";
        }
  }
  public static void setLastID(int id){
       Flight.lastFlightnum=id;
       }
  public static int getLastID(){
       return Flight.lastFlightnum;
       }
  
  

   public abstract double book(Customer c);

   public List<Movie> getMovieList() {
       return movies;
   }
   public String [] movieNameList(){
   Iterator iterator = movies.iterator();
   String [] moviesName= new String [movies.size()];
   int i=0;
   while(iterator.hasNext()){
   Movie m=(Movie)(iterator.next());
   moviesName[i]=m.getName();
   i++;
   }
   return moviesName;

   }
   
   public Movie moviefromName(String name){
    Movie m1 = null;
   Iterator iterator = movies.iterator();
   while(iterator.hasNext()){
   Movie m=(Movie)(iterator.next());
   System.out.print(m.getName()+"="+name);
   if(m.getName().equals(name)){
       m1=m;
   break;
   }
       }
   return m1;

   }

  public String deleteMovie(String mName) {
     movies.remove( moviefromName(mName));
     return "Movie Deleted";
   }
}