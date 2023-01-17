package com.itbook.session.mysql.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 노수연
 * @since 1.0
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "my_session")
public class MySession {
    @Id
    @Column(name = "session_id", nullable = false, columnDefinition = "varchar(255)")
    private String sessionId;

    @Column(name = "attribute", nullable = false, columnDefinition = "varchar(255)")
    private String attribute;

    @Column(name = "creation_time", nullable = false)
    private Long creationTime;

    @Column(name = "last_access_time", nullable = false)
    private Long lastAccessTime;
}
