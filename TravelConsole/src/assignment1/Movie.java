package assignment1;


public class Movie implements java.io.Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int length;
       
       public Movie(String name,int length){
           this.name=name;
           this.length=length;
       
       }
       public void setName(String name){
           this.name=name;
       }
       public void setLength(int length){
           this.length=length;
       }
       public String getName(){
           return name;
       }
       public int getLength(){
           return length;
       }

	public String toString() {
		return "\nMovie Name: "+getName() +"\nLength: "+ getLength()+"\n--------------\n";
	}

	// you may wish to use it, but may not be necessary
	@Override
	public boolean equals(Object o) {
		if (o instanceof Movie) {
			Movie m = (Movie) o;
			return (name.equals(m.name)) && (length == m.length);
		}
		return false;
       
	}
       
       
}
