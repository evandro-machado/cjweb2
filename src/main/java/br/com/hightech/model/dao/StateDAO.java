package br.com.hightech.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.hightech.model.entity.State;

@Repository
public class StateDAO {

//	Entity Manager Dependency injection
	@PersistenceContext
	EntityManager em;
	
	public StateDAO(){
//		 em = JPAUtil.openConection();
	}
	
	@Transactional
	public void save(State state) throws DAOException{
		try{
			em.merge(state);
		}catch (Exception e){
			throw new DAOException("Not able to save state.",e);
		}
	}
	
	@Transactional
	public void delete(State state){
		State stateRemove = readById(state.getId());
		em.remove(stateRemove);
	}
	
	@SuppressWarnings("unchecked")
	public List<State> readAll(){
		Query hql = em.createQuery("select e from State e");
		return hql.getResultList();		
	}
	
	public State readById(Long id){
		return em.find(State.class, id);
	}
	
	
}
