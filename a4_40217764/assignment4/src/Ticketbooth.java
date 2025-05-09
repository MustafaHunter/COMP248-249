import java.util.Arrays;

public class Ticketbooth {

	private Tickets t;
	private OPUSCard[] cards = new OPUSCard[5];


	public Ticketbooth() {
		t = new Tickets();
		cards= null;
	}

	public Ticketbooth(Tickets t, OPUSCard[] cards) {
		this.t = t;
		this.cards = cards;
	}

	// Using a method which will return true if the total value of the tickets of two Ticketbooth objects are equal, and false otherwise
	
	public boolean isEqualValue(Ticketbooth t) {
		if (this.getTickets().ticketsTotal() == t.getTickets().ticketsTotal())
			return true;
		else return false;

	}

	// Using a method which will return true if the number of each type of tickets of two Ticketbooth objects are equal, and false otherwise
	
	public boolean isEqualCount(Ticketbooth t) {
		if (this.getTickets().equals(t.getTickets()))
			return true;
		else return false;

	}

	// Using a method which will return the total value of the tickets in a ticketbooth
	
	public double getTotalValue() {
		return this.getTickets().ticketsTotal();	
	}

	// Using a method which will return the number of OPUS cards in a ticketbooth
	
	public int getNumberOfOPUSCards() {
		int cnt=0;
		for (int i = 0; i < cards.length; i++) {				
			if(cards[i]!=null)
			cnt++;
		}
		return cnt;
	}

	// Using a method which will add a new OPUS card to a ticketbooth
	
	public void addOPUSCard(OPUSCard c) {		
		cards[getNumberOfOPUSCards()] = c;	
	}

	// Using a method which will remove an OPUS card from a ticketbooth
	
	public boolean removeOPUSCard(int index) {

		if (getNumberOfOPUSCards()>0) {
			cards[index] = null;
			return true;			
		} else return false;
	}

	// Using a method which will update the expiry month and year of an OPUS card
	
	public void updateExpirationDate(OPUSCard c, int expirationMonth, int expirationYear) {
		c.setExpiration_month(expirationMonth);
		c.setExpiration_year(expirationYear);
	}

	// Using a method which will add tickets to a ticketbooth
	
	public double addTicketsToBooth(int rt, int jt, int st, int dt, int wt) {	
		t.addTickets(rt, jt, st, dt, wt);
		return t.ticketsTotal();

	}

	
	// Using a method which will return true if the total value of tickets and the number of OPUS cards tickets of two Ticketbooth are equal
	
	public boolean equals(Ticketbooth tb) {

		if (this.getTickets().ticketsTotal()==tb.getTickets().ticketsTotal()
				&& this.getNumberOfOPUSCards() == tb.getNumberOfOPUSCards())
			return true;
		else return false;		
	}

	public Tickets getTickets() {
		return t;
	}
	

	public OPUSCard[] getCards() {
		return cards;
	}

	
	// Using a method which will return a string indicating the number of each ticket
	
	@Override
	public String toString() {
		String cardsString = "";
		int cnt=0;
		for (int i =0;i<cards.length;i++) {
			if (cards[i]!=null){
				cardsString+="Card "+(i)+": "+cards[i]+"\n";
				cnt++;
			}
			if (cnt==0) cardsString="No OPUS cards\n";

		}	
		return "Ticketbooth:\n[t=" + t + ", \nCards=\n"+cardsString; 
	}





}
