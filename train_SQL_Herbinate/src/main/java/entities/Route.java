package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Route")
@NamedQuery(name = "Route.findAll", query = "FROM Route")
public class Route 
{
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numberRoute;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Route other = (Route) obj;
		if (numberRoute != other.numberRoute)
			return false;
		return true;
	}
	/**
	 * @return the numberRoute
	 */
	public int getNumberRoute() {
		return numberRoute;
	}
	/**
	 * @param numberRoute the numberRoute to set
	 */
	public void setNumberRoute(int numberRoute) {
		this.numberRoute = numberRoute;
	}
	/**
	 * @return the stationDepart
	 */
	public String getStationDepart() {
		return stationDepart;
	}
	/**
	 * @param stationDepart the stationDepart to set
	 */
	public void setStationDepart(String stationDepart) {
		this.stationDepart = stationDepart;
	}
	/**
	 * @return the stationArrive
	 */
	public String getStationArrive() {
		return stationArrive;
	}
	/**
	 * @param stationArrive the stationArrive to set
	 */
	public void setStationArrive(String stationArrive) {
		this.stationArrive = stationArrive;
	}
	/**
	 * @return the length
	 */
	public double getLength() {
		return length;
	}
	/**
	 * @param length the length to set
	 */
	public void setLength(double length) {
		this.length = length;
	}
	/**
	 * @return the train
	 */
	public Train getTrain() {
		return train;
	}
	/**
	 * @param train the train to set
	 */
	public void setTrain(Train train) {
		this.train = train;
	}
	@Id
	@Column(name="numberRoute",length=100,nullable=false)
	private int numberRoute;
	@Column(name="stationDepart",length=100,nullable=false)
	private String stationDepart;
	@Column(name="stationArrive",length=100,nullable=false)
	private String stationArrive;
	@Column(name="length",length=100,nullable=false)
	private double length;
	//Nối bảng 1-1
	@OneToOne
    @JoinColumn(name = "code")
	private Train train;
	public Route() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Route(int numberRoute, String stationDepart, String stationArrive, double length) {
		super();
		this.numberRoute = numberRoute;
		this.stationDepart = stationDepart;
		this.stationArrive = stationArrive;
		this.length = length;
	}
	
}
