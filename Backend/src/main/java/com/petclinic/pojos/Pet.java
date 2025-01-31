package com.petclinic.pojos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class Pet extends BaseEntity{
	
	@ManyToOne
	@JoinColumn(name="owner_id")
	private PetOwner owner;
	
	@Column(length=50)
	private String species;
	
	@Column(length=50)
	private String breed;
	
	@Column(length=50)
	private String name;
	
	
	private int age;
	
	
	@Enumerated(EnumType.STRING)
	private Gender gender;
	
	
}	
