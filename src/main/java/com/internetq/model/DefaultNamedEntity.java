package com.internetq.model;

import javax.persistence.MappedSuperclass;

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
public class DefaultNamedEntity extends DefaultEntity {
    String name;
    String description;
}
