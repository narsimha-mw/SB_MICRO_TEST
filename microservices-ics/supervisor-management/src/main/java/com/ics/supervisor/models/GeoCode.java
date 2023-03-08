package com.ics.supervisor.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity(name = "geo_code")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "geo_code")
public class GeoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "geoCode_id")
    private Integer id;
    @Column(name = "geoCodeX")
    private String latitude;
    @Column(name = "geoCodeY")
    private String longitude;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String category= "retailer";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @Transient
    private String location_type ="Force";
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "market_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Supervisor supervisor;

}
