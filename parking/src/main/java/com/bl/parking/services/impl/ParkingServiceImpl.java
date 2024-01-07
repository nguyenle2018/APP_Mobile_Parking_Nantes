package com.bl.parking.services.impl;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bl.parking.dao.ParkingAPIDAO;
import com.bl.parking.dao.entity.RecordEntity;
import com.bl.parking.dao.entity.ReponseParkingAPIEntity;
import com.bl.parking.models.Parking;
import com.bl.parking.services.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService {

	@Autowired
	public ParkingAPIDAO parkingAPIDAO; 
	
	
	@Override
	public List<Parking> getListeParkings() {
		
		ReponseParkingAPIEntity reponse = parkingAPIDAO.getListeParkings();
		return transformEntityToModel(reponse);
	}


	private List<Parking> transformEntityToModel(ReponseParkingAPIEntity reponse) {
		List<Parking> resultat = new ArrayList<Parking>();
		for(RecordEntity record: reponse.getRecords()) {
			Parking parking = new Parking();
			parking.setIdentifiant(record.getIdentifiant());
			parking.setNom(record.getGrpNom());
			parking.setStatut(getLibelleStatut(record));
			parking.setNbPlacesTotal(record.getGrpExploitation());
			parking.setNbPlacesDispo(record.getGrpDisponible());
			parking.setHeureMaj(getHeureMaj(record));
			resultat.add(parking);
		}
		return resultat;
	}


	private String getHeureMaj(RecordEntity record) {
		OffsetDateTime dateMaj = OffsetDateTime.parse(record.getGrpHorodatage());	
		OffsetDateTime dateMajWithOffsetPlus2 = dateMaj.withOffsetSameInstant(ZoneOffset.of("+02:00"));
		return dateMajWithOffsetPlus2.getHour() + "h" + dateMajWithOffsetPlus2.getMinute() ;
	}


	private String getLibelleStatut(RecordEntity record) {
		switch(record.getGrpStatut()) {
			case "1":{
				return "FERME";
			}
			case "2":{
				return "ABONNES";
			}
			case "5":{
				return "OUVERT";
			}
		}
		return "Données non disponible";
	}

}
