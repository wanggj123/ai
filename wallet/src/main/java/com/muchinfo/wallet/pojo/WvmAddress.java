package com.muchinfo.wallet.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@Table(name = "WVMADDRESS")
public class WvmAddress {

    @Column(name = "ID")
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "USERID")
    private String userId;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "CONTRACTADDRESS")
    private String contractAddress;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "PRIVATEKEY")
    private String privateKey;

    @Column(name = "ISSENDADDRESS")
    private Boolean isSendAddress;

}
