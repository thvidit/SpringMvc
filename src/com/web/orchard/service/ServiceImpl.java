package com.web.orchard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.orchard.dao.DaoInterface;
import com.web.orchard.model.Campusminds;
import com.web.orchard.model.Leads;
import com.web.orchard.model.OrchardTracks;

@Service
@Transactional
public class ServiceImpl implements ServiceInterface{
	
	public ServiceImpl() {

	}

	@Autowired
	private DaoInterface dao;
	

	@Override
	public String addCampusMind(Campusminds cm) {
		return dao.addCampusMind(cm);
	}

	@Override
	public String addLead(Leads lead) {
		return dao.addLead(lead);
	}

	@Override
	public String addTrack(OrchardTracks ot) {
		return dao.addTrack(ot);
	}

	@Override
	public List<Campusminds> getAllCampusMinds() {
		return dao.getAllCampusMinds();
	}

	@Override
	public List<Campusminds> getCampusMinds(int leadId) {
		return dao.getCampusMinds(leadId);
	}

	@Override
	public List<Leads> getLeads(int leadId) {
		return dao.getLeads(leadId);
	}

	@Override
	public List<OrchardTracks> getAllTracks() {
		return dao.getAllTracks();
	}

	@Override
	public String deleteTrack(int trackId) {
		return dao.deleteTrack(trackId);
	}

	@Override
	public Leads getLead(int leadId) {
		return dao.getLead(leadId);
	}

	@Override
	public OrchardTracks getTrack(int trackId) {
		return dao.getTrack(trackId);
	}

	@Override
	public List<Leads> getAllLeads() {
		return dao.getAllLeads();
	}
	
	

}
