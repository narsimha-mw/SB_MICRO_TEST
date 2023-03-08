package com.ics.supervisor.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agent_visit_plan")
public class AgentVisitPlan implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "entity_id")
    private Integer entityId;
    @Column(name = "week")
    private int agentVisitPlanWeek; // 1,2,3,4.(Monthly week's)

    // (ex: MONDAY....SUNDAY)
    @Column(name = "day")
    private String agentVisitPlanDay; // (ex: MONDAY....SUNDAY)
    @Column(name = "sequence")
    private int sequence; // filters fun..
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="agent_id", referencedColumnName = "user_id")
    private Supervisor supervisor; // FK for adminUser table(user_id)
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name ="outlet_id", referencedColumnName = "outlet_id")
    private Outlet outlet; // FK for Outlet table(outlet_id)

    @Column(name = "created_at") // TODO annotation added for dynamic
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at") // TODO annotation added for dynamic
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
