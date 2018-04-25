package stitchr.stitcher2mvc.models;


import org.hibernate.mapping.PrimaryKey;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@MappedSuperclass
@IdClass(User.class)
public abstract class AbstractEntity implements Serializable {

    private int uid;

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "uid", unique = true)

    public int getUid() {

        return uid;
    }

    protected void setUid(int uid) {

        this.uid = uid;

    }

}
