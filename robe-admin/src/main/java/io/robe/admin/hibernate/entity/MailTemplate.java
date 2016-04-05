package io.robe.admin.hibernate.entity;

import io.robe.hibernate.entity.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;


@Entity
@Table
public class MailTemplate extends BaseEntity {

    @Length(min = 1, max = 32)
    @Column(name = "code", length = 32)
    private String code;

    @NotEmpty
    @Enumerated(EnumType.STRING)
    @Column(name = "lang", nullable = false)
    private Type lang;

    @NotEmpty
    @Column(name = "mailTemplate", nullable = false)
    @Lob
    private char[] template;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Type getLang() {
        return lang;
    }

    public void setLang(Type lang) {
        this.lang = lang;
    }

    public char[] getTemplate() {
        return template;
    }

    public void setTemplate(char[] template) {
        this.template = template;
    }

    public enum Type {
        TR,
        EN;
    }
}
