
package assignment1;

import java.util.Date;


public class BusinessFlight extends Flight implements java.io.Serializable {

	private double rate;

	public BusinessFlight (String origin, String destination, Date date,
			int etd, int eta, double baseprice, double concession,
			double rate) {
		super(origin, destination, date, etd, eta, baseprice, concession);
               this.rate=rate;
               
                       //call  constructor with arguments
		//statements
	}

	@Override
	public double book(Customer c) {
           
             
              c.addFlight();
              double cost =rate*c.getAdultSeats()* super.baseprice + rate*c.getChildSeats()*super.concession*super.baseprice; 
		//calculation of cost
               c.addCost(cost);
		return cost ;
	}
   @Override
	public String toString() {
		return "\nType; Business"+"\nId:"+getFlightnum()+"\nOrigin:"+getOrigin()+"\nDestination:"+getDestination()+"\nDate:"+getDate()+"\nETA:"+getEta()+"\nBase Price"+baseprice+"\nConcession:"+concession+"\nRate:"+getRate()+"\n--------\n";
	}
       
       public double getRate(){return rate;}
       
       public void setRate(double rate){this.rate=rate;}
}