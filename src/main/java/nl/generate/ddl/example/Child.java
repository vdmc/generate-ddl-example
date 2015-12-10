package nl.generate.ddl.example;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "CHILD", indexes = { @Index(columnList = "NAME", name = "IDX_CHILD_NAME") }, uniqueConstraints = { @UniqueConstraint(columnNames = "NAME", name = "UK_CHILD_NAME") })
@SequenceGenerator(allocationSize = 1, name = "CHILD_ID_GENERATOR", sequenceName = "CHILD_ID_SEQ")
public class Child {
    @Id
    @GeneratedValue(generator = "CHILD_ID_GENERATOR", strategy = SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany()
    @JoinColumn(name = "CHILD_ID", foreignKey = @ForeignKey(name = "FK_CHILD_PET", foreignKeyDefinition = "FK_ABC foreign key (CHILD_ID) references CHILD"))
    private List<Pet> pets;

}
