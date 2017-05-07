package com.aamir.api.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.aamir.api.entity.User;

@Repository
public class UserRepoImpl implements UserRepo {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<User> findAll() {
		
		TypedQuery<User> query = em.createNamedQuery("User.findAll", User.class);
		return query.getResultList();
	}

	@Override
	public User findOne(String userId) {
		return em.find(User.class, userId);
	}
	
	@Override
	public User findByEmail(String email) {
		TypedQuery<User> query = em.createNamedQuery("User.findByEmail", User.class);
		query.setParameter("pEmail", email);

		List<User> user = query.getResultList();
		if (user != null && user.size() == 1) {
			return user.get(0);
		} else {
			return null;
		}
	}

	@Override
	public User create(User user) {
		em.persist(user);
		return user;
	}

	@Override
	public User update(User user) {
		return em.merge(user);
	}

	@Override
	public void delete(User user) {
 
		em.remove(user);
	}

}
