package com.example.app_customers.model;


import lombok.*;

import javax.persistence.*;
import java.sql.Date;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="customer")
public class Customer {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="birth_day", columnDefinition = "DATE")
    //@Convert(converter = LocalDateAttributeConverter.class)
    private Date birthDay;

    @Column(name="id_code")
    private String idCode;

    @Column(name="family_status")
    private String familyStatus;

    @Column(name="education")
    private String education;

    @Column(name="group_name")
    private String groupName;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="group_id")
    private Group group;

    public Group getGroup() {
        return group;
    }
    public void setGroup(Group group) {
        this.group = group;
    }
}
