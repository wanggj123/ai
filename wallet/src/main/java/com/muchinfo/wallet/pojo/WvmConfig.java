package com.muchinfo.wallet.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "WVMCONFIG")
public class WvmConfig {
    @Id
    @Column(name = "ID")
    private String  id;
    @Column(name = "CODE")
    private String  code;
    @Column(name = "NAME")
    private String  name;
    @Column(name = "VALUE")
    private String  value;
    @Column(name = "ATTECHMENT")
    private String  attechment;
    @Column(name = "STATUS")
    private String  status;
    @Column(name = "REMARK")
    private String  remark;
}
