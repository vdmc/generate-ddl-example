package nl.generate.ddl.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "PET", indexes = { @Index(columnList = "NAME", name = "IDX_PET_NAME") }, uniqueConstraints = { @UniqueConstraint(columnNames = "NAME", name = "UK_PET_NAME") })
@SequenceGenerator(allocationSize = 1, name = "PET_ID_GENERATOR", sequenceName = "PET_ID_SEQ")
public class Pet {
    @Id
    @GeneratedValue(generator = "PET_ID_GENERATOR", strategy = SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;



}
