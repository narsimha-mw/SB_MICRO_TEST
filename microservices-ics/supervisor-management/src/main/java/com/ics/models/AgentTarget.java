package com.ics.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "agent_target")
public class AgentTarget implements Serializable {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "entity_id")
        private Integer entityId;
        @Column(name = "target_value")
        @NonNull
        @NotBlank
        @NotEmpty
        private Double targetValue;
        @Column(name = "acquisition_target")
        private Double AcquisitionTarget;
        @Column(name = "principal_target")
        private Double principalTarget;
        @Column(name="target_month")
        private int targetMonth;
        @Column(name="target_year")
        private int targetYear;
        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name ="agent_id", referencedColumnName = "user_id")
        private AdminUser adminUser; // FK for adminUser table(user_id)
        @CreationTimestamp
        @Column(name = "created_at") // TODO annotation added for dynamic
        private LocalDateTime createdAt;
        @UpdateTimestamp
        @Column(name = "updated_at") // TODO annotation added for dynamic
        private LocalDateTime updatedAt;

}
