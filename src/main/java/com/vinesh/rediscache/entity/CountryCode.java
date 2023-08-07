package com.vinesh.rediscache.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigInteger;

@Entity
@Getter
@Setter
@ToString
@Table(name = "country_codes", schema = "public")
public class CountryCode implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private BigInteger id;
    private String code;

}
