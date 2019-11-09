package com.muchinfo.wallet.service.impl;

import com.muchinfo.wallet.WalletConst;
import com.muchinfo.wallet.config.WalletConfig;
import com.muchinfo.wallet.dao.WvmAddressDao;
import com.muchinfo.wallet.dto.WvmAddressReqDto;
import com.muchinfo.wallet.dto.WvmAddressRspDto;
import com.muchinfo.wallet.pojo.WvmAddress;
import com.muchinfo.wallet.service.WvmAddressService;
import com.muchinfo.wallet.util.WalletRpcUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class WvmAddressServiceImpl implements WvmAddressService {


    @Autowired
    private WvmAddressDao wvmAddressDao;

    @Autowired
    private WalletConfig walletConfig;

    @Override
    public WvmAddressRspDto getWalletAddress(WvmAddressReqDto dto) {
        WvmAddressRspDto wvmAddressRspDto = new WvmAddressRspDto();
        WvmAddress wvmAddress = this.wvmAddressDao.findByUserIdAndCurrencyAndTokenAndContractAddress(dto.getUid(), dto.getCurrency(), dto.getToken(), dto.getContractAddress());
        //如果从表中查询到数据则直接返回地址,如果没有查询到地址调用RPC生成一个地址
        if (Objects.isNull(wvmAddress)) {
            String address = WalletRpcUtil.getBlockResult(walletConfig, WalletConst.GET_NEW_ADDRESS, new Object[]{dto.getUid()}, String.class);
            log.debug("getnewaddress return token : {}" , address);
            String privateKey = WalletRpcUtil.getBlockResult(walletConfig , WalletConst.DUMP_PRIV_KEY , new Object[]{address} , String.class);
            //获取TOKEN地址
            wvmAddress = new WvmAddress();
            wvmAddress.setPrivateKey(privateKey);
            wvmAddress.setAddress(address);
            wvmAddress.setToken(dto.getToken());
            wvmAddress.setContractAddress(dto.getContractAddress());
            wvmAddress.setCurrency(dto.getCurrency());
            wvmAddress.setUserId(dto.getUid());
            wvmAddress.setIsSendAddress(Boolean.FALSE);
            this.wvmAddressDao.saveAndFlush(wvmAddress);
        }
        wvmAddressRspDto.setAddress(wvmAddress.getAddress());
        wvmAddressRspDto.setCode("0");
        return wvmAddressRspDto;
    }
}
