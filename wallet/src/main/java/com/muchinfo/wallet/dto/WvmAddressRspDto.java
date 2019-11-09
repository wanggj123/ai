package com.muchinfo.wallet.dto;

import lombok.Data;

@Data
public class WvmAddressRspDto {

    private String code;
    private String desc;
    private String exchTransId;
    private String address;
    private String remark;
    private String signature;

}
