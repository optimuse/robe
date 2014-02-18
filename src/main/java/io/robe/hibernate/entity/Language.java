package io.robe.hibernate.entity;

import javax.persistence.*;

/**
 * Created by kaanalkim on 13/02/14.
 */
@Entity(name = "Language")
@Table
public class Language extends BaseEntity {

    public enum Type {
        TR,
        EN;
    }

    @Enumerated(EnumType.STRING)
    @Column(name = "code", nullable = false)
    private Type code;

    @Column(name = "name", nullable = false)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getCode() {
        return code;
    }

    public void setCode(Type lang) {
        this.code = lang;
    }
}
