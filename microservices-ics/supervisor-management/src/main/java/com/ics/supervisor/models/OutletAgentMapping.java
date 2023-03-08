package com.ics.supervisor.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "outlet_agent_mapping")
public class OutletAgentMapping implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Integer entityId;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="agent_id", referencedColumnName = "user_id")
    private Supervisor supervisor; // FK for adminUser table(user_id)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="outlet_id", referencedColumnName = "outlet_id")
    private Outlet outlet; // FK for Outlet table(outlet_id)

}
