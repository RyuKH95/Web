package rkh.webProject.domain;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class RUser {
    @Id
    @Column(name = "num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long num;

    @Column(name = "id")
    private String id;
    @Column(name = "password")
    private String pw;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name = "cre_ymd")
    private String create_ymd;
    @Column(name = "del_ymd")
    private String delete_ymd;
    @Column(name = "use_yn")
    private String use_yn;

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreate_ymd() {
        return create_ymd;
    }

    public void setCreate_ymd(String create_ymd) {
        this.create_ymd = create_ymd;
    }

    public String getDelete_ymd() {
        return delete_ymd;
    }

    public void setDelete_ymd(String delete_ymd) {
        this.delete_ymd = delete_ymd;
    }

    public String getUse_yn() {
        return use_yn;
    }

    public void setUse_yn(String use_yn) {
        this.use_yn = use_yn;
    }
}
