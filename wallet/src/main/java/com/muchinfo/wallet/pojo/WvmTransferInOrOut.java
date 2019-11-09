package com.muchinfo.wallet.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Data
@Table(name = "WVMTRANSFERINOROUT")
public class WvmTransferInOrOut {
    @Id
    @Column(name = "WALLETTRANSID")
    private String  walletTransId;
    @Column(name = "EXCHTRANSID")
    private String  exchTransId;
    @Column(name = "USERID")
    private String  userId;
    @Column(name = "CURRENCY")
    private String  currency;
    @Column(name = "TOKEN")
    private String token;
    @Column(name = "CONTRACTADDRESS")
    private String contractAddress;
    @Column(name = "AMOUNT")
    private String amount;
    @Column(name = "INOROUT")
    private String inOrOut;
    @Column(name = "EXCHFEE")
    private String exchFee;
    @Column(name = "DIGFEE")
    private String digFee;
    @Column(name = "FROMADDRESS")
    private String fromAddress;
    @Column(name = "TOADDRESS")
    private String toAddress;
    @Column(name = "TXID")
    private String txid;
    @Column(name = "CODE")
    private String code;
    @Column(name = "DESCD")
    private String descd;
    @Column(name = "TRADESTARTDATE")
    private Date tradeStarDate;
    @Column(name = "BLOCKTIME")
    private Date blockTime;




}
