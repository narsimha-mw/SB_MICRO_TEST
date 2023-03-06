package com.ics.performances.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "performance_kpi")
public class PerformanceKPI implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="sales_id", referencedColumnName = "sales_id")
    private Sales sales; // FK for Sales table(sales_id)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="order_id", referencedColumnName = "order_id")
    private Orders orders; // FK for Orders table(order_id)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="outlet_id", referencedColumnName = "active_outlet_id")
    private ActiveOutlets activeOutlets; // FK for ActiveOutlets table(outlet_id)
}
