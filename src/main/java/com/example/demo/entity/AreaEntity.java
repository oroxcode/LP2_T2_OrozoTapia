package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name= "tb_area")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class AreaEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id")
	private Integer areaId;
	
	
	@Column(name="nombre_area",
			nullable = false,
			length = 45,
			columnDefinition = "VARCHAR(45)"
			)
	private String nombreArea;
}
