package com.codegym.demo.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Authority
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "authority_id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AuthorityType authorityType;

    @ManyToMany(mappedBy = "authorities")
    private Set<User> users=new HashSet<>();

    public Authority(){}

    public Integer getId()
    {
        return this.id;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public AuthorityType getAuthorityType()
    {
        return this.authorityType;
    }

    public void setAuthorityType(AuthorityType authorityType)
    {
        this.authorityType = authorityType;
    }

    public Set<User> getUsers()
    {
        return this.users;
    }

    public void setUsers(Set<User> users)
    {
        this.users = users;
    }
}
