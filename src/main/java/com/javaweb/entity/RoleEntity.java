package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "role")
@Table(name = "role")
public class RoleEntity extends BaseEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "code")
    private String code;





    @ManyToMany(mappedBy = "roles",fetch = FetchType.EAGER)
    private List<UserEntity> users = new ArrayList<>();

    public List<UserEntity> getUsers() {
        return users;
    }

    public void setUsers(List<UserEntity> users) {
        this.users = users;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
