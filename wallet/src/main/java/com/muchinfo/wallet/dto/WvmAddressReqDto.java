package com.muchinfo.wallet.dto;

import lombok.Data;

@Data
public class WvmAddressReqDto {

    private String exchTransId;

    private String uid;

    private Integer uidType;

    private String currency;

    private String token;

    private String contractAddress;

    private Integer tradeSystemFlag;

    private String remark;

    private String signature;

}
