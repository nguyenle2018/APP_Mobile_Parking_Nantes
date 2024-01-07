package com.bl.parking.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.bl.parking.dao.ParkingAPIDAO;
import com.bl.parking.dao.entity.ReponseParkingAPIEntity;


@Repository
public class ParkingAPIDAOImpl implements ParkingAPIDAO {
	
	private static final String URL_API_OPEN_DATA = "https://data.nantesmetropole.fr/api/explore/v2.1/catalog/datasets/244400404_parkings-publics-nantes-disponibilites/records?limit=20";
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public ReponseParkingAPIEntity getListeParkings() {		
		return restTemplate.getForEntity(URL_API_OPEN_DATA, ReponseParkingAPIEntity.class).getBody();
	}

}
