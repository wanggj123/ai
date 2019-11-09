package com.muchinfo.wallet.controller;

import com.muchinfo.wallet.dto.WvmAddressReqDto;
import com.muchinfo.wallet.dto.WvmAddressRspDto;
import com.muchinfo.wallet.service.WvmAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 钱包第三方接口
 * @author heyi
 * @date 2019年1月21日 17:15:11
 */

@Api("钱包接口")
@Slf4j
@RestController
public class WalletController {
    @Autowired
    private WvmAddressService wvmAddressService;

    @ApiOperation("获取地址")
    @PostMapping("/third/wallet/getWalletAddress")
    @ResponseBody
    public WvmAddressRspDto getWalletAddress(@RequestBody WvmAddressReqDto dto) {
        return this.wvmAddressService.getWalletAddress(dto);
    }
}
