package com.vote.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Data
public class ElectionResult {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Election Name must be required")
	private String electionName;
	
	@OneToOne
	@JoinColumn(name="winner_id")
	@JsonIgnore
	private Candidate winner;
	
	@JsonProperty("winnerId")
	public Long getWinnerId() {
		return winner!=null?winner.getId():null;
	}
	
	
	private int totalVotes;
	
}
