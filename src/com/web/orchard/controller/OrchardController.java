package com.web.orchard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.web.orchard.model.CampusAndLead;
import com.web.orchard.model.LeadAndTrack;
import com.web.orchard.model.Leads;
import com.web.orchard.model.OrchardTracks;
import com.web.orchard.service.ServiceInterface;

@Controller

public class OrchardController {
	
	public OrchardController() {
		
	}
	
	@Autowired
	private ServiceInterface serviceImpl;

	@RequestMapping("addcampusmind")
	public ModelAndView addCampusMind(@ModelAttribute("cl") CampusAndLead cl) {
		return new ModelAndView("mindForm");
	}
	
	@RequestMapping("addlead")
	public ModelAndView addLead(@ModelAttribute("lt") LeadAndTrack lt) {
		return new ModelAndView("leadForm");
	}
	
	
	@RequestMapping("addtrack")
	public ModelAndView addTrack(@ModelAttribute("ot") OrchardTracks ot) {
		return new ModelAndView("trackForm");
	}
	
	@RequestMapping(value = {"getallcampusminds","/"})
	public ModelAndView getAllCampusMinds() {
		return new ModelAndView("mindList","mindList", serviceImpl.getAllCampusMinds());
	}
	
	@RequestMapping("getcampusminds")
	public ModelAndView getCampusMinds(@RequestParam("id") int id) {
		return new ModelAndView("mindList","mindList", serviceImpl.getCampusMinds(id));
	}
	
	@RequestMapping("getallleads")
	public ModelAndView getLeads() {
		return new ModelAndView("leadList","leadList",serviceImpl.getAllLeads());
	}
	
	@RequestMapping("getleads")
	public ModelAndView getLeads(@RequestParam("leadId") int leadId) {
		return new ModelAndView("mindsList","mindsList",serviceImpl.getLeads(leadId));
	}
	
	@RequestMapping("gettracks")
	public ModelAndView getAllTracks() {
		return new ModelAndView("trackList","trackList",serviceImpl.getAllTracks());
	}
	
	@RequestMapping("delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		serviceImpl.deleteTrack(id);
		return new ModelAndView("reirect:getTracks");
	}
	
	@RequestMapping("savemind")
	public ModelAndView saveCampusMind(@ModelAttribute("cl") CampusAndLead cl) {
		Leads realLead = serviceImpl.getLead(cl.getLeadsId());
		if(realLead != null) {
			cl.getCm().setLead(realLead);
			serviceImpl.addCampusMind(cl.getCm());
		}
		return new ModelAndView("mindList","mindList",serviceImpl.getAllCampusMinds());
	}
	
	@RequestMapping("savetrack")
	public ModelAndView saveTrack(@ModelAttribute("ot") OrchardTracks ot) {
		serviceImpl.addTrack(ot);
		return new ModelAndView("mindList","mindList",serviceImpl.getAllCampusMinds());
	}
	
	@RequestMapping("savelead")
	public ModelAndView saveLead(@ModelAttribute("lt") LeadAndTrack lt) {
		OrchardTracks ot = serviceImpl.getTrack(lt.getTrackId());
		if(ot != null) {
			lt.getLead().setOrchardTrack(ot);
			serviceImpl.addLead(lt.getLead());
		}
		return new ModelAndView("mindList","mindList",serviceImpl.getAllCampusMinds());
	}
	
	
}
