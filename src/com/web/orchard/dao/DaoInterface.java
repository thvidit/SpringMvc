package com.web.orchard.dao;

import java.util.List;

import com.web.orchard.model.*;

public interface DaoInterface {
	
	public String addCampusMind(Campusminds cm);
	
	public String addLead(Leads lead);
	
	public String addTrack(OrchardTracks ot);
	
	public List<Campusminds> getAllCampusMinds();
	
	public List<Campusminds> getCampusMinds(int leadId);
	
	public List<Leads> getLeads(int leadId);
	
	public List<OrchardTracks> getAllTracks();
	
	public String deleteTrack(int trackId);
	
	public Leads getLead(int leadId);
	
	public OrchardTracks getTrack(int trackId);
	
	public List<Leads> getAllLeads();
}
