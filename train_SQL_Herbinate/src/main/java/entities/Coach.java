package entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Coach")
@NamedQuery(name = "Coach .findAll", query = "FROM Coach")
public class Coach 
{
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
	/**
	 * @return the chair
	 */
	public List<Chair> getChair() {
		return chair;
	}
	/**
	 * @param chair the chair to set
	 */
	public void setChair(List<Chair> chair) {
		this.chair = chair;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + number;
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
		Coach other = (Coach) obj;
		if (number != other.number)
			return false;
		return true;
	}
	/**
	 * @return the number
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * @param number the number to set
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the numberChair
	 */
	public int getNumberChair() {
		return numberChair;
	}
	/**
	 * @param numberChair the numberChair to set
	 */
	public void setNumberChair(int numberChair) {
		this.numberChair = numberChair;
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
	@Column(name="number",length=100,nullable=false)
	private int number;
	@Column(name="type",length=100,nullable=false)
	private String type;
	@Column(name="numberChair",length=100,nullable=false)
	private int numberChair;
	@ManyToOne
    @JoinColumn(name = "code")
	private Train train;
	@OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
	private List<Chair> chair = new ArrayList<>();
	@OneToMany(mappedBy = "coach", cascade = CascadeType.ALL)
	private List<Person> person = new ArrayList<>();
	public Coach() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Coach(int number, String type, int numberChair) {
		super();
		this.number = number;
		this.type = type;
		this.numberChair = numberChair;
	}
	
	
}
