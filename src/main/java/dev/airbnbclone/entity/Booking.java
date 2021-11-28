package dev.airbnbclone.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@SequenceGenerator(name = "booking_seq", sequenceName = "booking_seq", initialValue = 1, allocationSize = 1)
@Table(name = "booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double payment;

    private Long numberOfGuests;

    private String desired_dates;

    @ManyToOne
    @JoinColumn(name = "offer_id")
    public Offer offer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User user;

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDesired_dates() {
        return this.desired_dates;
    }

    public void setDesired_dates(String desired_dates) {
        this.desired_dates = desired_dates;
    }

    public Double getPayment() {
        return this.payment;
    }

    public void setPayment(Double payment) {
        this.payment = payment;
    }

    public Offer getOffer() {
        return this.offer;
    }

    public void setOffer(Offer offer) {
        this.offer = offer;
    }

    public Booking() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberOfGuests() {
        return this.numberOfGuests;
    }

    public void setNumberOfGuests(Long numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

}
