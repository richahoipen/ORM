package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
@Entity
@Table(name = "Chair")
@NamedQuery(name = "Chair.findAll", query = "FROM Chair")
public class Chair 
{
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
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Coach getCoach() {
		return coach;
	}
	/**
	 * @param coach the coach to set
	 */
	public void setCoach(Coach coach) {
		this.coach = coach;
	}
	@Id
	@Column(name="numberInChar",length=100,nullable=false)
	private int number;
	@Column(name="type",length=100,nullable=false)
	private String type;
	@Column(name="price",length=100,nullable=false)
	private double price;
	@ManyToOne
    @JoinColumn(name = "number")
	private Coach coach;
	public Chair() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Chair(int number, String type, double price) {
		super();
		this.number = number;
		this.type = type;
		this.price = price;
	}
	
}
