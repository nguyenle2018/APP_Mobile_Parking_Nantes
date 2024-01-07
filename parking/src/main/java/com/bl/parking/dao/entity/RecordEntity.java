package com.bl.parking.dao.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecordEntity {
	
			
		@JsonProperty(value = "idobj")
		private int identtifiant;
		
		@JsonProperty(value = "grp_nom")
		private String grpNom;
		
		@JsonProperty(value = "grp_exploitation")
		private int grpExploitation;
		
		@JsonProperty(value = "grp_disponible")
		private int grpDisponible;
				
		@JsonProperty(value = "grp_statut")
		private String grpStatut;
		
		@JsonProperty(value = "grp_horodatage")
		private String grpHorodatage;
		
		public int getIdentifiant() {
			return identtifiant;
		}
		
		public void setIdentifian(int identtifiant) {
			this.identtifiant = identtifiant;
		}
		
		public String getGrpNom() {
			return grpNom;
		}
		
		public void setGrpNom(String grpNom) {
			this.grpNom = grpNom;
		}
		
		public int getGrpExploitation() {
			return grpExploitation;
		}
		
		public void setGrpExploitation(int grpExploitation) {
			this.grpExploitation = grpExploitation;
		}
		
		public int getGrpDisponible() {
			return grpDisponible;
		}
		
		public void setGrpDisponible(int grpDisponible) {
			this.grpDisponible = grpDisponible;
		}
		
		public String getGrpStatut() {
			return grpStatut;
		}
		
		public void setGrpStatut(String grpStatut) {
			this.grpStatut = grpStatut;
		}
		
		public String getGrpHorodatage() {
			return grpHorodatage;
		}
		
		public void setGrpHorodatage(String grpHorodatage) {
			this.grpHorodatage = grpHorodatage;
		}
	
	
		
		
		
		
	
}
