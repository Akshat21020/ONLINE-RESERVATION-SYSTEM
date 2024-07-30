package proj;

public class Train_Details {
		String from;
		String to;
		String trainname;
		String classtype;
		int no_oftickets;
		String departure_date;
		String return_date;
		int PNR_number;
		
	public Train_Details(String from,String to,String trainname,String classtype,int no_oftickets,String departure_date,String return_date) {
			this.from = from;
			this.to = to;
			this.trainname = trainname;
			this.classtype = classtype;
			this.no_oftickets = no_oftickets;
			this.departure_date = departure_date;
			this.return_date = return_date;
		}
		public String getDeparture() {
			return from;
		}
		public String getDestination() {
			return to;
		}
		public String getTrainname() {
			return trainname;
		}
		public String getClasstype() {
			return classtype;
		}
		public int getNooftickets(){
			return no_oftickets;
		}
		public String getDeparture_Date() {
			return departure_date;
		}
		public String getReturn_Date() {
			return return_date;
		}
		public int getPNR() {
			return PNR_number;
		}
}
