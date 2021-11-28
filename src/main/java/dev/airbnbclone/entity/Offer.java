package dev.airbnbclone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(name = "offer_seq", sequenceName = "offer_seq", initialValue = 1, allocationSize = 1)
@Table(name = "offer")
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numberOfBeds;

    private boolean isWifi;

    private boolean isKitchen;

    private boolean isTV;

    private int rating;

    private Double price;

    private String available_dates;

    private String description;

    @OneToMany(mappedBy = "offer", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    public Set<Booking> bookings = new HashSet<>();

    public void addBooking(Booking booking) {
        bookings.add(booking);
        booking.setOffer(this);
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    @JsonBackReference
    public Address address;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonBackReference
    public User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumberOfBeds() {
        return this.numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean isIsWifi() {
        return this.isWifi;
    }

    public boolean getIsWifi() {
        return this.isWifi;
    }

    public void setIsWifi(boolean isWifi) {
        this.isWifi = isWifi;
    }

    public boolean isIsKitchen() {
        return this.isKitchen;
    }

    public boolean getIsKitchen() {
        return this.isKitchen;
    }

    public void setIsKitchen(boolean isKitchen) {
        this.isKitchen = isKitchen;
    }

    public boolean isIsTV() {
        return this.isTV;
    }

    public boolean getIsTV() {
        return this.isTV;
    }

    public void setIsTV(boolean isTV) {
        this.isTV = isTV;
    }

    public int getRating() {
        return this.rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getAvailable_dates() {
        return this.available_dates;
    }

    public void setAvailable_dates(String available_dates) {
        this.available_dates = available_dates;
    }

    public Set<Booking> getBookings() {
        return this.bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }


    public Offer(int numberOfBeds, boolean isWifi, boolean isKitchen, boolean isTV, Double price, String available_dates, String description) {
        this.numberOfBeds = numberOfBeds;
        this.isWifi = isWifi;
        this.isKitchen = isKitchen;
        this.isTV = isTV;
        this.rating = 0;
        this.price = price;
        this.available_dates = available_dates;
        this.description = description;
        this.bookings = null;
        this.address = null;
        this.user = null;
    }


    public Offer() {
    }


}