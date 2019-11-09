package com.muchinfo.wallet.service;

import com.muchinfo.wallet.dto.WvmAddressReqDto;
import com.muchinfo.wallet.dto.WvmAddressRspDto;

public interface WvmAddressService {

    WvmAddressRspDto getWalletAddress(WvmAddressReqDto dto);

}
