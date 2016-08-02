package com.internetq.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author n.spilanis
 * @version 1.0
 * @since 1/8/2016
 */

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DefaultEntity {

    @Id
    @TableGenerator(name="default", allocationSize = 1, initialValue = 1)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "default")
    @Column(nullable = false)
    Long id;

    String owner;

    String insusr;

    @Temporal(TemporalType.TIMESTAMP)
    Date insdate;

    String updusr;

    @Temporal(TemporalType.TIMESTAMP)
    Date upddate;
}
