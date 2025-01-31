package com.petclinic.pojos;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="users")
public class User extends BaseEntity{
	
	@Column(name="firstname",length = 50)
	String firstName;
	@Column(name="lastname",length = 50)
	String lastName;
	int age;
	@Enumerated(EnumType.STRING)
	Role role;
	@Column(length = 8)
	String password;
	@Column(length = 50,unique = true,nullable = false)
	String email;
	@Column(length = 13)
	String phoneNo;
	@Column(length = 255)
	String address;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

//	@OneToOne
//	@JoinColumn(name="owner_id")
//	private PetOwner petowner;
}
