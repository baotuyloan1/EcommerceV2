package com.bnd.ecommerce.entity.customer;

import com.bnd.ecommerce.entity.CreateUpdateTimeStamp;
import com.bnd.ecommerce.entity.Role;
import com.bnd.ecommerce.entity.order.Order;
import com.bnd.ecommerce.enums.GenderEnum;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name = "customer")
public class Customer extends CreateUpdateTimeStamp implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @NotNull
  @Column(nullable = false)
  private String firstName;

  @NotNull private String lastName;

  @Column(unique = true, nullable = false)
  private String email;

  @Column(nullable = false, unique = true)
  private String userName;

  private String phone;

  @Column(nullable = false)
  private String password;

  private String status;

  @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
  @JoinTable(
      name = "customer_roles",
      joinColumns = @JoinColumn(name = "customer_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roleSet = new HashSet<>();

  public Set<Role> getRoleSet() {
    return roleSet;
  }

  public void setRoleSet(Set<Role> roles) {
    this.roleSet = roles;
  }

  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }


  @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
  private Set<CustomerAddress> customerAddressSet = new HashSet<>();

  public void setPassword(String password) {
    this.password = password;
  }



  public Set<CustomerAddress> getCustomerAddressSet() {
    if (customerAddressSet == null) customerAddressSet = new HashSet<>();
    return customerAddressSet;
  }

  public void setCustomerAddressSet(Set<CustomerAddress> customerAddressSet) {
    this.customerAddressSet = customerAddressSet;
  }

  @Column(name = "gender")
  @Enumerated(EnumType.STRING)
  private GenderEnum genderEnum;

  public GenderEnum getGenderEnum() {
    return genderEnum;
  }

  public void setGenderEnum(GenderEnum gender) {
    this.genderEnum = gender;
  }







  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return null;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return this.email;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }


}
