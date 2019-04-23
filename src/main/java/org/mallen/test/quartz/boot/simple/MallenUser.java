package org.mallen.test.quartz.boot.simple;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @author mallen
 * @date 4/18/19
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "mallen_user")
public class MallenUser {
    @Id
    @GenericGenerator(name = "id", strategy = "uuid2")
    @GeneratedValue(generator = "id")
    private String id;
    private String name;

}
