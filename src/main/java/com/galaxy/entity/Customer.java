package com.galaxy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String email;
    private String  phone;
    private String gender;
    private String password;
    private Integer age;
    @Column(name = "is_status")
    private boolean isStatus;
    @ManyToOne(targetEntity = Bmi.class)
    @JoinColumn(name = "bmi_id", referencedColumnName = "id")
    private Bmi bmi;

    @OneToOne(targetEntity = Order.class)
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;


}
