package com.example.app_customers.model;


import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="group")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String nameGroup;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="group_id")
    private List<Customer> cmrs;


    public void addCustomerToGroup(Customer customer){
        if(cmrs == null )
        {
            cmrs = new ArrayList<>();
        }
        cmrs.add(customer);
        customer.setGroup(this);
    }

    public List<Customer> getCmrs() {
        return cmrs;
    }
}
