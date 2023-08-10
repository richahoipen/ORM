package dataBase;

import java.time.LocalDate;

import entities.Chair;
import entities.Coach;
import entities.Person;
import entities.Route;
import entities.Train;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class Herbinate 
{
	public static void main(String[] args) 
	{
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("trainCompany");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		try 
		{
			//Train(String code, String name, LocalDate dateDepart, String stationStart, String stationEnd,double ticketPrice)			
			Train train1=new Train("SPT2","SG-PT",LocalDate.of(2023,8,10),"SaiGon station","PhanThiet Station", 2000000);
			//Person(String personId, String personName, int personAge, String personAddress)
			Person person1=new Person("001","Van Teo",30,"Phu Nhuan");
			Person person2=new Person("002","Van Tung",30,"Phu Tho");
			Person person3=new Person("003","Hoang Tung",40,"Van Tho");
			//Coach(int id, int number, String type, String name)
			Coach coach1=new Coach(1,"VIP",40);
			Coach coach2=new Coach(2,"VIP",40);
			Coach coach3=new Coach(3,"NORMAL",40);
			Coach coach4=new Coach(4,"NORMAL",40);
			Coach coach5=new Coach(5,"NORMAL",40);
			//Chair(int number, String type, double price) 
			Chair chair1=new Chair(1,"Soft",2000);
			Chair chair2=new Chair(2,"Soft",2000);
			Chair chair3=new Chair(3,"Soft",2000);
			Chair chair4=new Chair(4,"Soft",2000);
			Chair chair5=new Chair(5,"Soft",2000);
			//Route(int numberRoute, String stationDepart, String stationArrive, double length)
			Route r1=new Route(1,"Sai Gon","Phan Thiet",200);
			//Set cho train
			r1.setTrain(train1);
			train1.setRoute(r1);
			//Đặt Train cho từng coach
			train1.getCoach().add(coach1);
			train1.getCoach().add(coach2);
			train1.getCoach().add(coach3);
			train1.getCoach().add(coach4);
			train1.getCoach().add(coach5);
			//Đặt Coach cho train
			coach1.setTrain(train1);
			coach2.setTrain(train1);
			coach3.setTrain(train1);
			coach4.setTrain(train1);
			coach5.setTrain(train1);
			
			//set
			train1.getPerson().add(person1);
			train1.getPerson().add(person2);
			train1.getPerson().add(person3);
			// Đặt Train cho từng Passenger
			person1.setTrain(train1);
			person2.setTrain(train1);
			person3.setTrain(train1);		
			//Đặt chair cho coach
			chair1.setCoach(coach1);
			chair2.setCoach(coach1);
			chair3.setCoach(coach2);
			chair4.setCoach(coach2);
			chair5.setCoach(coach3);
			//Đặt coach cho chair
			coach1.getChair().add(chair1);
			coach1.getChair().add(chair2);
			coach2.getChair().add(chair3);
			coach2.getChair().add(chair4);
			coach3.getChair().add(chair5);
			//Đặt coach cho person
			coach1.getPerson().add(person1);
			coach1.getPerson().add(person2);
			coach2.getPerson().add(person3);
			//Đặt person cho coach
			person1.setCoach(coach1);
			person2.setCoach(coach1);
			person3.setCoach(coach2);
			
			
			em.merge(train1);			
			System.out.println("Thành công");
			/*
			TypedQuery<LinhKien> queryLinhKien = em.createNamedQuery("LinhKien.findAll", LinhKien.class);
			List<LinhKien> listLinhKien= queryLinhKien.getResultList();
			System.out.println("Lấy danh sách LinhKien:");
			for (LinhKien l : listLinhKien) 
			{
				System.out.println(l.toString());
			}*/
			em.getTransaction().commit();
			em.close();
			emf.close();
		} catch (Exception e) 
		{
			em.getTransaction().rollback();
			System.out.println("Lỗi kết nối: " + e.getMessage());
		} finally 
		{
			em.close();
			emf.close();
		}
	}
}
