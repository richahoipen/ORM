package entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;

import jakarta.persistence.Table;

@Entity
@Table(name = "Person")
@NamedQuery(name = "Person.findAll", query = "FROM Person")
public class Person 
{

	/**
	 * @return the coach
	 */
	public Coach getCoach() {
		return coach;
	}
	/**
	 * @param coach the coach to set
	 */
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	@Override
	public String toString() {
		return "Person [personId=" + personId + ", personName=" + personName + ", personAge=" + personAge
				+ ", personAddress=" + personAddress + "]";
	}
	/**
	 * @return the personId
	 */
	public String getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(String personId) {
		this.personId = personId;
	}
	/**
	 * @return the personName
	 */
	public String getPersonName() {
		return personName;
	}
	/**
	 * @param personName the personName to set
	 */
	public void setPersonName(String personName) {
		this.personName = personName;
	}
	/**
	 * @return the personAge
	 */
	public int getPersonAge() {
		return personAge;
	}
	/**
	 * @param personAge the personAge to set
	 */
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	/**
	 * @return the personAddress
	 */
	public String getPersonAddress() {
		return personAddress;
	}
	/**
	 * @param personAddress the personAddress to set
	 */
	public void setPersonAddress(String personAddress) {
		this.personAddress = personAddress;
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
	@Column(name="personId",length=100,nullable=false)
	private String personId;
	@Column(name="personName",length=100,nullable=false)
	private String personName;
	@Column(name="personAge",length=100,nullable=false)
	private int personAge;
	@Column(name="personAddress",length=100,nullable=false)
	private String personAddress;
	@ManyToOne
    @JoinColumn(name = "code")
	private Train train;
	@ManyToOne
    @JoinColumn(name = "number")
	private Coach coach;
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Person(String personId, String personName, int personAge, String personAddress) {
		super();
		this.personId = personId;
		this.personName = personName;
		this.personAge = personAge;
		this.personAddress = personAddress;
	}
	
	
	
}
