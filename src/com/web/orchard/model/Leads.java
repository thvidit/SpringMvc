package com.web.orchard.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Leads")
public class Leads implements Serializable{
	
	private static final long serialVersionUID = -7988799579036225137L;
	
	int leadsId;
	int mId;
	String name;
	
	List<Campusminds> campusminds;
	OrchardTracks orchardTrack;
	
	public Leads() { /* Empty Constructor */ }
	
	public Leads(int mId, String name, List<Campusminds> campusminds) {
		super();
		this.mId = mId;
		this.name = name;
		this.campusminds = campusminds;
	}
	
	@Id
	@GeneratedValue
	public int getLeadsId() {
		return leadsId;
	}

	public void setLeadsId(int leadsId) {
		this.leadsId = leadsId;
	}

	public int getmId() {
		return mId;
	}

	public void setmId(int mId) {
		this.mId = mId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(targetEntity = Campusminds.class, mappedBy="lead", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Campusminds> getCampusminds() {
		return campusminds;
	}

	public void setCampusminds(List<Campusminds> campusminds) {
		this.campusminds = campusminds;
	}

	@OneToOne(targetEntity = OrchardTracks.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "trackId")
	public OrchardTracks getOrchardTrack() {
		return orchardTrack;
	}

	public void setOrchardTrack(OrchardTracks orchardTrack) {
		this.orchardTrack = orchardTrack;
	}
	

}
