package com.muchinfo.wallet.pojo;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "WVMBLOCKTX")
public class WvmBlockTx {

    @Column(name = "ID")
    @Id
    private String id;

    @Column(name = "CURRENCY")
    private String currency;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "CONTRACTADDRESS")
    private String contractAddress;

    @Column(name = "SENDADDRESS")
    private String sendAddress;


    @Column(name = "REFERENCEADDRESS")
    private String referenceAddress;


    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "DIGFEE")
    private BigDecimal digFee;

    @Column(name = "BLOCKTIME")
    private Date blockTime;

    @Column(name = "VALID")
    private Integer valid;

    @Column(name = "PROPERTYID")
    private Integer propertyId;

    @Column(name = "CONFIRMATIONS")
    private Integer confirmations;

    @Column(name = "DIVISIBLE")
    private Integer divisible;


}
