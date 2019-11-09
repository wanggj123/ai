package com.muchinfo.wallet.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@NoArgsConstructor
@Data
public class OmniListTransactionsDto {
    private String txid;
    private BigDecimal fee;
    private String sendingaddress;
    private String referenceaddress;
    private boolean ismine;
    private int version;
    private int type_int;
    private String type;
    private int propertyid;
    private boolean divisible;
    private BigDecimal amount;
    private boolean valid;
    private String blockhash;
    private Date blocktime;
    private Long positioninblock;
    private Long block;
    private Integer confirmations;
}
