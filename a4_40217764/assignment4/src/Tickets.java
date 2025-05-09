
public class Tickets {
	
	// Keeping track of the number of tickets
	// Using double since ticket fees are in decimal

	private static double REGULAR_TICKET_FEE = 3.50;
	private static double JUNIOR_TICKET_FEE = 2.50;
	private static double SENIOR_TICKET_FEE = 1.00;
	private static double DAILY_TICKET_FEE = 10.00;
	private static double WEEKLY_TICKET_FEE = 40.00;

	private int rt = 0;
	private int jt = 0;
	private int st = 0;
	private int dt = 0;
	private int wt = 0;

	public Tickets() {

	}

	public Tickets(int rt, int jt, int st, int dt, int wt) {
		this.rt = rt;
		this.jt = jt;
		this.st = st;
		this.dt = dt;
		this.wt = wt;
	}

	// Copy constructor
	
	public Tickets(Tickets t) {
		this.rt = t.getRt();
		this.jt = t.getJt();
		this.st = t.getSt();
		this.dt = t.getDt();
		this.wt = t.getWt();

	}

	/*
	 * Add given number to total ticket count
	 * Using a method which allows us to increase the number of each ticket
	 */
	
	public void addTickets(int rt, int jt, int st, int dt, int wt) {
		this.rt += rt;
		this.jt += jt;
		this.st += st;
		this.dt += dt;
		this.wt += wt;

	}

	 // Using a method which returns a double indicating the total value of the tickets
	
	public double ticketsTotal() {

		double total = this.rt * REGULAR_TICKET_FEE + this.jt * JUNIOR_TICKET_FEE + this.st * SENIOR_TICKET_FEE
				+ this.dt * DAILY_TICKET_FEE + this.wt * WEEKLY_TICKET_FEE;

		return total;

	}

	// Using a method which will return a string indicating the count of each ticket
	
	@Override
	public String toString() {
		return "Tickets [rt=" + rt + " x $"+REGULAR_TICKET_FEE+
				", jt=" + jt + " x $"+JUNIOR_TICKET_FEE+
				", st=" + st + " x $"+SENIOR_TICKET_FEE+
				", dt=" + dt + " x $"+DAILY_TICKET_FEE+
				", wt=" + wt +" x $"+WEEKLY_TICKET_FEE+ "]";
	}

	public int getRt() {
		return rt;
	}

	public void setRt(int rt) {
		this.rt = rt;
	}

	public int getJt() {
		return jt;
	}

	public void setJt(int jt) {
		this.jt = jt;
	}

	public int getSt() {
		return st;
	}

	public void setSt(int st) {
		this.st = st;
	}

	public int getDt() {
		return dt;
	}

	public void setDt(int dt) {
		this.dt = dt;
	}

	public int getWt() {
		return wt;
	}

	public void setWt(int wt) {
		this.wt = wt;
	}

	
	//Returns true if number of each ticket type is the same
	
	public boolean equals(Tickets t) {

		if (this.getRt()==t.getRt() && this.getJt() == t.getJt()
				&&this.getSt()==t.getSt() && this.getDt()==t.getDt()
				&& this.getWt() == t.getWt()) 		
			return true;
		else
			return false;

	}

}
