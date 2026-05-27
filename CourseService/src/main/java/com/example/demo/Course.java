package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class Course {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String instructor;
	public Course() {
		super();
	}
	public Course(Long id, String title, String instructor, Integer maxSeats) {
		super();
		this.id = id;
		this.title = title;
		this.instructor = instructor;
		this.maxSeats = maxSeats;
	}
	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", instructor=" + instructor + ", maxSeats=" + maxSeats + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getInstructor() {
		return instructor;
	}
	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}
	public Integer getMaxSeats() {
		return maxSeats;
	}
	public void setMaxSeats(Integer maxSeats) {
		this.maxSeats = maxSeats;
	}
	private Integer maxSeats;
}
