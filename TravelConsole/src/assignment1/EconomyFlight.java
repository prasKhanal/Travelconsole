package assignment1;
import java.util.Date;

import java.util.Date;


public class EconomyFlight extends Flight implements java.io.Serializable {
	private double groupDiscount;

	public EconomyFlight(String origin, String destination, Date date,
			int etd, int eta, double baseprice, double concession,
			double groupDiscount)
			{
			super(origin,  destination,  date,  etd,  eta, baseprice, concession);
                       //this call to super may not suffice your requirements. You may have to call the other constructor
	
                       this.groupDiscount=groupDiscount;
	}

	@Override
	public double book(Customer c) {
		c.addFlight();
              double cost=0;
              int totalSeat=c.getAdultSeats()+c.getChildSeats();
                      if(totalSeat>4) 
                          cost=4*super.baseprice+(totalSeat-4)*groupDiscount/100;
		//put your statements guys
               c.addCost(cost);

		return cost ;
	}
       


   public double getGroupDiscount() {
       return this.groupDiscount;
   }
   public void setGroupDiscount(double discount){
   this.groupDiscount=discount;
   }
   public String toString() {
		return "\nType; Economy"+"\nId:"+getFlightnum()+"\nOrigin:"+
                       getOrigin()+"\nDestination:"+getDestination()+"\nDate:"+
                       getDate()+"\nETA:"+getEta()+"\nBase Price"+baseprice+"\nConcession:"+
                       concession+"\nDiscount:"+
                       getGroupDiscount()+"\n----------\n";
	}

}


	

