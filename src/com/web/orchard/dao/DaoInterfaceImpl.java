package com.web.orchard.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.web.orchard.model.Campusminds;
import com.web.orchard.model.Leads;
import com.web.orchard.model.OrchardTracks;

@Repository
public class DaoInterfaceImpl implements DaoInterface{
	
	public DaoInterfaceImpl() {
		
	}

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public String addCampusMind(Campusminds cm) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(cm);
			session.getTransaction().commit();
			
			return "Campus Mind Details Successfully added!";
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		
		}
	}

	@Override
	public String addLead(Leads lead) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(lead);
			session.getTransaction().commit();
			
			return "Lead Details Successfully added!";
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
			
		}
	}

	@Override
	public String addTrack(OrchardTracks ot) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.save(ot);
			session.getTransaction().commit();
			
			return "Track Details Successfully added!";
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
			
		}
	}

	@Override
	public List<Campusminds> getAllCampusMinds() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Campusminds> minds = session.createQuery("From Campusminds").list();
			return minds;
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Campusminds> getCampusMinds(int leadId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Leads> lead = session.createQuery("From Leads where leadsId = '" + leadId + "'").list();
			List<Campusminds> minds = lead.get(0).getCampusminds();
			return minds;
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<Leads> getLeads(int leadId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Leads> lead = session.createQuery("From Leads where leadsId = '" + leadId + "'").list();
			return lead;
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public List<OrchardTracks> getAllTracks() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<OrchardTracks> tracks = session.createQuery("From OrchardTracks").list();
			return tracks;
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}

	@Override
	public String deleteTrack(int trackId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<OrchardTracks> tracks = session.createQuery("delete OrhcardTracks where trackId = '" + trackId + "'").list();
			return "Track details deleted!";
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}

	@Override
	public Leads getLead(int leadId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Leads> leads = session.createQuery("From Leads where leadsId = '" + leadId + "'").list();
			return leads.get(0);
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}

	@Override
	public OrchardTracks getTrack(int trackId) {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<OrchardTracks> track = session.createQuery("From OrchardTracks where trackId = '" + trackId + "'").list();
			return track.get(0);
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
		
	}

	@Override
	public List<Leads> getAllLeads() {
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			List<Leads> leads = session.createQuery("From Leads").list();
			return leads;
		}catch(Exception e) {
			session.getTransaction().rollback();
			return null;
		}finally {
			session.close();
		}
	}
	
	

}
