package maudev.portfolio.user.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_portfolio")
@Data
@AllArgsConstructor @NoArgsConstructor @Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "use_id")
    private Long id;
    @Column(name = "use_name")
    private String name;
    @Column(name = "use_lastname")
    private String lastname;
    @Column(name = "use_aboutme")
    private String aboutme;
    @Column(name = "use_jobposition")
    private String jobposition;
    @Column(name = "use_status")
    private String status;
    @Column(name = "use_createat")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createat;
    
}
