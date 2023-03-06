package com.ics.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "supervisor_info")
public class AdminUser implements Serializable {
        @Id
        @GeneratedValue(strategy= GenerationType.IDENTITY)
        @Column(name = "id")
        private Integer id;
        @Column(name = "user_id")
        private int user_id;
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
       private int market;
       @Column(name = "created")
       private String created;
       @Column(name = "modified")
       private String modified;
}