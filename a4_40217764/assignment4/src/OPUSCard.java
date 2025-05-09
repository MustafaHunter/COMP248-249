
public class OPUSCard {

	/* Keeping track of the OPUS card type
	 * Keeping track of the name of card holder
	 * Keeping track of expiry month as an integer and the expiry year as an integer.
	*/

	private String card_type;
	private String cardholer_name;
	private int expiration_month;
	private int expiration_year;

	public OPUSCard() {
		// TODO Auto-generated constructor stub
	}

	public OPUSCard(String card_type, String cardholder_name, int expiration_month, int expiration_year) {	
		this.card_type = card_type;
		this.cardholer_name = cardholder_name;
		this.expiration_month = expiration_month;
		this.expiration_year = expiration_year;
	}

	public OPUSCard(OPUSCard c) {
		this.card_type = c.getCard_type();
		this.cardholer_name = c.getCardholer_name();
		this.expiration_month = c.getExpiration_month();
		this.expiration_year = c.getExpiration_year();
	}
	public String getCard_type() {
		return card_type;
	}

	public String getCardholer_name() {
		return cardholer_name;
	}


	public int getExpiration_month() {
		return expiration_month;
	}

	public void setExpiration_month(int expiration_month) {
		if ((expiration_month<1)||(expiration_month>12))
			expiration_month=0;
		this.expiration_month = expiration_month;
	}

	public int getExpiration_year() {
		return expiration_year;
	}

	public void setExpiration_year(int expirtation_year) {
		this.expiration_year = expirtation_year;
	}

	// Using a method which will return a string indicating the number of each ticket 
	
	@Override
	public String toString() {
		return "OPUSCard [card_type=" + card_type + ", cardholer_name=" + cardholer_name + ", expiration_month="
				+ expiration_month + ", expiration_year=" + expiration_year + "]";
	}

	// Using a method which will return true if the total of the value of tickets and number of OPUS cards tickets are equal
	
	public boolean equals(OPUSCard c) {

		if (this.getCard_type()==c.getCard_type() && this.getCardholer_name() == c.getCardholer_name()
				&& this.getExpiration_month() == c.getExpiration_month() && this.getExpiration_year() == c.getExpiration_year())
			return true;
		else return false;
		
	}


}
