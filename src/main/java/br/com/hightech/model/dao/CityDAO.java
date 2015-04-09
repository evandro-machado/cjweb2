package br.com.hightech.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hightech.model.entity.City;
import br.com.hightech.model.entity.State;

@Repository
public class CityDAO {

//	Entity Manager Dependency injection
	@PersistenceContext
	EntityManager em;
	
	public CityDAO(){
//		 em = JPAUtil.openConection();
	}
	
	@Transactional
	public void save(City city) throws DAOException{
		try{
			em.merge(city);
		}catch (Exception e){
			throw new DAOException("Not able to save city.",e);
		}
	}
	
	@Transactional
	public void delete(City city){
		City cityRemove = readById(city.getId());
		em.remove(cityRemove);
	}
	
	@SuppressWarnings("unchecked")
	public List<City> readAll(){
		Query hql = em.createQuery("select c from City c");
		return hql.getResultList();		
	}
	
	public City readById(Long id){
		return em.find(City.class, id);
	}

	public List<City> readCities(State state) {
		Query hql = em.createQuery("select c from City c where c.state=:sta");
		hql.setParameter("sta", state);
		return hql.getResultList();	
	}
	
	
}
