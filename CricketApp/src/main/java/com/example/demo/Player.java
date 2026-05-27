package com.example.demo;

import jakarta.persistence.*;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String country;
    private String role;
    private String battingStyle;
    private String imageUrl;

    // Default Constructor required by JPA
    public Player() {}

    public Player(String name, String country, String role, String battingStyle, String imageUrl) {
        this.name = name;
        this.country = country;
        this.role = role;
        this.battingStyle = battingStyle;
        this.imageUrl = imageUrl;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public String getRole() { return role; }
    public void setRole(String role) { this.role = role; }

    public String getBattingStyle() { return battingStyle; }
    public void setBattingStyle(String battingStyle) { this.battingStyle = battingStyle; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
