package com.gcl.crm.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Potential {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String phoneNumber;

    private String date;

    private String name;

    @Column(unique = true)
    private String email;

    private String source;

    private String address;

    private String mktId;

    private String mktTeam;

    private String sale;

    private String course;

    private String initialState;

    private String firstCare;

    private String secondCare;

    private String thirdCare;

    private String tradingAccount;

    private String marginAccount;

    private String note;

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Potential)) {
            return false;
        }
        Potential potential = (Potential) o;
        if (this.phoneNumber == null){
            return this.email.equals(potential.getEmail());
        }
        if (this.email == null){
            return this.phoneNumber.equals(potential.getPhoneNumber());
        }
        return this.phoneNumber.equals(potential.getPhoneNumber())
                || this.email.equals(potential.getEmail());
    }
}
