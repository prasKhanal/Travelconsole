       /*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

package assignment1;

import java.util.ArrayList;
import java.util.List;


public class Customer implements java.io.Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int lastID = 0;
	private int id;
	private String name;
       private String surName;
	private int childSeats = 0;
	private int adultSeats = 0;
	private int numFlights = 0;
	private double cost = 0.0;
       private  List<Object> flights=new ArrayList(0);
  
     //default constructor
       public Customer(){
      
           
       }
	public Customer(String name,String surname, int childSeats, int adultSeats) {
           this.surName=surname;
           this. name=name;
           this. childSeats=childSeats;
           this.adultSeats=adultSeats;
           //id set to last set id +1
           this.id= ++lastID;
           

	}
      //getter and setter for last id
       public static void setLastID(int id){
       Customer.lastID=id;
       }
       public static int getLastID(){
       return lastID;}
       //customer name getter and setter
       public String getName(){
           return name;
       }
       public void setName(String Name){
           this.name=Name;
       }
       //getter fo customer unique id
        public String getSurName(){
           return surName;
       }
        public void addFlight(int id){
            flights.add((Object)id);
        }
        public List getFlight(){
       return flights;
        }
        public void removeFlight(int id){
        flights.remove((Object)id);
        }
        
       public void setSurName(String Name){
           this.surName=Name;
       }
	public int getId() {
		return id;
	}

	public int getChildSeats() {
		return childSeats;
	}
       public void setChildSeats(int CSeats){
           childSeats=CSeats;
       }

	public int getAdultSeats() {
		return adultSeats;
	}
       public void setAdultSeats(int ASeats){
           adultSeats=ASeats;
       }
       //total cost is added with the call of methods
	public void addCost(double amount){
           this.cost += amount;
           
       }
       
	public void addFlight(){
           this.numFlights++;
     
	}
       public int getNumFlights(){return numFlights;}
       
       public double getCost(){return cost;}
	public String toString(){
           return"\nId: "+ getId()+"\nName: "+getName()+"\nSurName: "+getSurName()+ "\nChildSeats: "+getChildSeats()+"\nAdultSeats: "+ 
                   getAdultSeats()+"\nNumber Of Flights:"+getNumFlights()+"\nList Of FlightsId:"+getFlight()+"\nTotal Cost: "+getCost()+"\n____________\n";
	}
}