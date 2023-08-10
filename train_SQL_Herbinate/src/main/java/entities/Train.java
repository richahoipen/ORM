package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Train")
@NamedQuery(name = "Train.findAll", query = "FROM Train")
public class Train 
{
	
	/**
	 * @return the route
	 */
	public Route getRoute() {
		return route;
	}
	/**
	 * @param route the route to set
	 */
	public void setRoute(Route route) {
		this.route = route;
	}
	public List<Coach> getCoach() {
		return coach;
	}
	/**
	 * @param coach the coach to set
	 */
	public void setCoach(List<Coach> coach) {
		this.coach = coach;
	}
	@Override
	public String toString() {
		return "Train [code=" + code + ", name=" + name + ", dateDepart=" + dateDepart + ", stationStart="
				+ stationStart + ", stationEnd=" + stationEnd + ", ticketPrice=" + ticketPrice + ", person=" + person
				+ "]";
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dateDepart
	 */
	public LocalDate getDateDepart() {
		return dateDepart;
	}
	/**
	 * @param dateDepart the dateDepart to set
	 */
	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}
	/**
	 * @return the stationStart
	 */
	public String getStationStart() {
		return stationStart;
	}
	/**
	 * @param stationStart the stationStart to set
	 */
	public void setStationStart(String stationStart) {
		this.stationStart = stationStart;
	}
	/**
	 * @return the stationEnd
	 */
	public String getStationEnd() {
		return stationEnd;
	}
	/**
	 * @param stationEnd the stationEnd to set
	 */
	public void setStationEnd(String stationEnd) {
		this.stationEnd = stationEnd;
	}
	/**
	 * @return the ticketPrice
	 */
	public double getTicketPrice() {
		return ticketPrice;
	}
	/**
	 * @param ticketPrice the ticketPrice to set
	 */
	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}
	/**
	 * @return the person
	 */
	public List<Person> getPerson() {
		return person;
	}
	/**
	 * @param person the person to set
	 */
	public void setPerson(List<Person> person) {
		this.person = person;
	}
	@Id
	@Column(name="code",length=100,nullable=false)
	private String code;
	@Column(name="name",length=100,nullable=false)
	private String name;
	@Column(name="dateDepart",length=100,nullable=false)
	private LocalDate dateDepart;
	@Column(name="stationStart",length=100,nullable=false)
	private String stationStart;
	@Column(name="stationEnd",length=100,nullable=false)
	private String stationEnd;
	@Column(name="ticketPrice",length=100,nullable=false)
	private double ticketPrice;
	@OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
	private List<Person> person = new ArrayList<>();
	@OneToMany(mappedBy = "train", cascade = CascadeType.ALL)
	private List<Coach> coach = new ArrayList<>();
	@OneToOne(mappedBy = "train", cascade = CascadeType.ALL, orphanRemoval = true)
	private Route route;
	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Train(String code, String name, LocalDate dateDepart, String stationStart, String stationEnd,
			double ticketPrice) {
		super();
		this.code = code;
		this.name = name;
		this.dateDepart = dateDepart;
		this.stationStart = stationStart;
		this.stationEnd = stationEnd;
		this.ticketPrice = ticketPrice;
	}
	
}
