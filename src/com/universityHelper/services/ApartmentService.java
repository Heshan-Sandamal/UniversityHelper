package com.universityHelper.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.bson.types.ObjectId;

import com.mongodb.util.JSON;
import com.universityHelper.models.Apartment;
import com.universityHelper.models.ApartmentComment;
import com.universityHelper.models.ApartmentKey;
import com.universityHelper.models.LandLord;
import com.universityHelper.models.Student;
import com.universityHelper.models.University;

import javafx.beans.binding.When.ObjectConditionBuilder;

/**
 * Session Bean implementation class ApartmentService
 */

@Stateless
@LocalBean
public class ApartmentService implements ApartmentServiceLocal {

	@PersistenceContext
	EntityManager em;

	/**
	 * Default constructor.
	 */
	public ApartmentService() {
		// TODO Auto-generated constructor stub
	}

	// adding apartment to database
	@Override
	public boolean addApartment(Apartment apartment, String landLordId, String[] universityList) {

		try {
			// find landlord from db and create landLord object
			LandLord landLord = em.find(LandLord.class, landLordId);

			// University university1 = em.find(University.class,
			// "57510eea63256f310290a394");
			// University university2 = em.find(University.class,
			// "57556b336325f16548ffeeae");3

			String query = "SELECT c FROM University c where ";
			for (int x = 0; x < universityList.length; x++) {
				query += "c.name='" + universityList[x] + "'";
				if (x != universityList.length - 1) {

					query += " OR ";

				}

			}

			TypedQuery<University> queryRes = em.createQuery(query, University.class);
			// query.setParameter(1, );
			List<University> list = queryRes.getResultList(); // fetch
																// apartments

			// System.out.println(university);

			// set landLord to apartment
			apartment.setLandLordId(landLord);

			// set University for apartment
			if (apartment.getUniversity() == null) {

				apartment.setUniversity(new HashSet<University>());

			}

			for (University uni : list) {

				apartment.getUniversity().add(uni);
				// apartment.getUniversity().add(university2);

				// set apartment for university
				if (uni.getApartmentList() == null) {
					uni.setApartmentList(new HashSet<Apartment>());
				}

				uni.getApartmentList().add(apartment);
			}

			// university2.getApartmentList().add(apartment);
			// persists the apartment object to db
			em.persist(apartment);
			return true;

			// TypedQuery<Apartment> query = em.createQuery("SELECT c FROM
			// Apartment c", Apartment.class);
			// Apartment a = query.getSingleResult();
			// ApartmentKey gg = new ApartmentKey();
			// gg.setApartmentId(322);
			// gg.setOwnerId(landLord.getLandLordId());
			/*
			 * if (apt != null) {
			 * apartment.getApartmentKey().setApartmentId(apt.getApartmentKey().
			 * getApartmentId() + 1); } else {
			 * apartment.getApartmentKey().setApartmentId(0); }
			 */

			// apartment.getApartmentKey().setOwnerId(landLord.getLandLordId());
			// apartment.getApartmentKey().setApartmentId(321);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	// get registerd apartments
	public JsonObject getApartmentList(String universityName) {
		// create query to fetch apartment objects
		TypedQuery<Apartment> query = em.createQuery("SELECT c FROM Apartment c", Apartment.class);
		List<Apartment> list = query.getResultList(); // fetch apartments

		JsonObjectBuilder ob = Json.createObjectBuilder();
		System.out.println("result list" + list.size());

		JsonArrayBuilder job = Json.createArrayBuilder();

		University s = new University();
		s.setName(universityName);

		for (Apartment ap : list) {
			System.out.print("uni" + ap.getUniversity().toArray()[0]);
			if (ap.getUniversity().contains(s)) {
				JsonObjectBuilder ob2 = Json.createObjectBuilder();
				ob2.add("longitude", ap.getLongitude());
				ob2.add("lattitude", ap.getLattitide());
				ob2.add("apartmentKey", ap.getApartmentKey());
				ob2.add("address", ap.getAddress());
				ob2.add("payment", ap.getPayment());
				ob2.add("avilablePlaces", ap.getAvilablePlaces());
				ob2.add("name", ap.getName());
				ob2.add("rate", ap.getRate());

				job.add(ob2.build());

			}

		}
		JsonObjectBuilder jsonObject = ob.add("Apartment", job);
		return jsonObject.build();

	}

	@Override
	public Apartment getApartmentDetails(String apartmentKey) {

		Apartment apartment = em.find(Apartment.class, apartmentKey);
		
		Map<String,Double> ratingList=apartment.getRatings();
		
		Collection<Double> values=ratingList.values();
		
		double tot=0;
		for (Double val : values) {
			tot+=val;
		}
		
		double rate=(tot/values.size());
		rate =Math.round(rate * 100.0) / 100.0;
		System.out.println("Rate is "+rate);
		
		apartment.setRate(rate);
		
		return apartment;

	}

	@Override
	public ArrayList<Apartment> getApartmentListOfLandLord(String landLordId) {
		String query = "SELECT c FROM Apartment c";
		TypedQuery<Apartment> queryRes = em.createQuery(query, Apartment.class);
		// query.setParameter(1, );
		ArrayList<Apartment> list = (ArrayList<Apartment>) queryRes.getResultList(); // fetch
																						// apartments
		ArrayList<Apartment> matchList = new ArrayList<>();

		for (Apartment apartment : list) {
			if (apartment.getLandLordId().getLandLordId().equals(landLordId)) {
				matchList.add(apartment);
			}
		}

		return matchList;
	}

	@Override
	public boolean addComment(ApartmentComment acm, String apartmentId, String studentId) {

		Apartment apartment = em.find(Apartment.class, apartmentId);
		Student student = em.find(Student.class, studentId);

		acm.setApartment(apartment);
		acm.setStudent(student);

		if (student.getApartmentComment() == null) {
			student.setApartmentComment(new HashSet<ApartmentComment>());
		}

		student.getApartmentComment().add(acm);

		if (apartment.getApartmentComment() == null) {
			apartment.setApartmentComment(new HashSet<ApartmentComment>());
		}

		apartment.getApartmentComment().add(acm);

		em.persist(acm);

		return true;
	}

	@Override
	public ArrayList<ApartmentComment> getApartmentComments(String apartmentId) {

		String query = "SELECT c FROM ApartmentComment c order by c.dateAndTime Desc";
		TypedQuery<ApartmentComment> queryRes = em.createQuery(query, ApartmentComment.class);
		ArrayList<ApartmentComment> list = (ArrayList<ApartmentComment>) queryRes.getResultList();

		ArrayList<ApartmentComment> matchlist = new ArrayList<>();

		for (ApartmentComment acm : list) {
			if (acm.getApartment().getApartmentKey().equals(apartmentId)) {
				matchlist.add(acm);
			}
		}

		return matchlist;
	}

	@Override
	public boolean addRatings(String studentId, String apartmentId, Double rating) {

		Apartment apartment = em.find(Apartment.class, apartmentId);

		if (apartment.getRatings() == null) {
			apartment.setRatings(new HashMap<>());
		}

		Student student = new Student() {
			{
				setStudentId(studentId);
			}
		};

		double ratedValue=1;
		
		if (apartment.getStudentSubscribers().contains(student)) {
			Map<String, Double> studentRatings = apartment.getRatings();
			
			studentRatings.put(studentId, rating);
			
			
			
			

			em.merge(apartment);
			return true;
		} else {
			return false;
		}

	}

}
