package org.dnyanyog.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Roles {

  @Id @GeneratedValue @Column private long roleId;

  @Column private String roleName;

  public static Roles getInstance() {
    return new Roles();
  }

  public long getRoleId() {
    return roleId;
  }

  public Roles setRoleId(long roleId) {
    this.roleId = roleId;
    return this;
  }

  public String getRoleName() {
    return roleName;
  }

  public Roles setRoleName(String roleName) {
    this.roleName = roleName;
    return this;
  }
}
