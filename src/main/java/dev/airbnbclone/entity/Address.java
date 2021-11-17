package dev.airbnbclone.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(name="address_seq", sequenceName = "address_seq",initialValue = 1, allocationSize = 1)
@Table(name = "address")
public class Address {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String city;

    private String street;

    private String uf;


    @OneToMany(
        mappedBy = "address", 
        cascade = CascadeType.ALL, 
        fetch = FetchType.EAGER, 
        orphanRemoval = true)    
    @JsonManagedReference
    @Fetch(value = FetchMode.SUBSELECT)
    public Set<Offer> offers = new HashSet<>();

    public void addOffer(Offer offer){
        offers.add(offer);
    offer.setAddress(this);
}

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return this.street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getUf() {
        return this.uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Set<Offer> getOffers() {
        return this.offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }


}
