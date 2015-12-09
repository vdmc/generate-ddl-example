package nl.generate.ddl.example;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.GenerationType.SEQUENCE;

@Entity
@Table(name = "PARENT", indexes = { @Index(columnList = "NAME", name = "IDX_CHILD_NAME") }, uniqueConstraints = { @UniqueConstraint(columnNames = "NAME", name = "UK_NAME") })
@SequenceGenerator(allocationSize = 1, name = "PARENT_ID_GENERATOR", sequenceName = "PARENT_ID_SEQ")
public class Parent {
    @Id
    @GeneratedValue(generator = "PARENT_ID_GENERATOR", strategy = SEQUENCE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PARENT_CHILD", joinColumns = @JoinColumn(name = "PARENT_ID"), foreignKey = @ForeignKey(name ="FK_PARENT_CHILD_PARENT"), inverseJoinColumns = @JoinColumn(name = "CHILD_ID"), inverseForeignKey = @ForeignKey(name ="FK_ABC"), uniqueConstraints = {@UniqueConstraint(columnNames = "CHILD_ID", name = "UK_CHILD_ID") })
    private List<Child> children = new ArrayList<>();

}
