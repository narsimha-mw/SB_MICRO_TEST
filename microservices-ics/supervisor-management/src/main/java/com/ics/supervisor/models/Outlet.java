package com.ics.supervisor.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "outlet")
public class Outlet implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "outlet_id")
    private Integer outletId;
    @Column(name = "created_at") // TODO annotation added for dynamic
    @CreationTimestamp
    private LocalDateTime createdAt;
    @Column(name = "updated_at") // TODO annotation added for dynamic
    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
