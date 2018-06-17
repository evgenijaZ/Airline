package com.airline.app.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.Transient;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Data
@ToString(exclude = {"roles"})
@EqualsAndHashCode(exclude = {"roles","aircraftSet"})
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Email(message = "*Please provide a valid Email")
    @NotEmpty(message = "*Please provide an email")
    private String email;
    @Length(min = 6, message = "*Your password must have at least 6 characters")
    @NotEmpty(message = "*Please provide your password")
    @Transient
    private String password;
    private int active;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "m2m_user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    @JsonManagedReference
    private Set<Role> roles;
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private Set<Aircraft> aircraftSet;
    @OneToMany(mappedBy = "author")
    @JsonManagedReference
    private Set<Airline> airlineSet;
}