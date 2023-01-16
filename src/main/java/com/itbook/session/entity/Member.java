package com.itbook.session.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Members")
public class Member {

    @Id
    private String username;

    private String pwd;

}
