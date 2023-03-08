package com.ics.supervisor.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supervisor")
public class Supervisor implements Serializable {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
        @Column(name = "user_id")
        private int userId;
        @Column(name = "firstname")
        @NonNull
        @NotBlank
        @NotEmpty
        private String firstname;
        @Column(name = "lastname")
        @NonNull
        @NotBlank
        @NotEmpty
        private String lastname;
        @Column(name = "email")
        @Email
        private String email;
        @Column(name = "username")
        private String username;
        @Column(name="employee_id")
        private String employee_id;
        @Column(name="fos_user_type")
        private int fos_user_type;
        @Column(name = "supervisor_id")
        private int supervisor_id;
        @Column(name = "manager_id")
        private int manager_id;
       @Column(name = "market_id")
       private int marketId;
       @Column(name = "created")
       private String created;
       @Column(name = "modified")
       private String modified;
       @Transient
        private List<GeoCode> geoCodes;
}