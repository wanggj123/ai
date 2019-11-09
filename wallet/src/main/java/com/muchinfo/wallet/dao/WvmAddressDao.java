package com.muchinfo.wallet.dao;

import com.muchinfo.wallet.dao.repository.BaseRepository;
import com.muchinfo.wallet.pojo.WvmAddress;
import com.muchinfo.wallet.pojo.WvmTransferInOrOut;
import org.springframework.stereotype.Repository;

@Repository
public interface WvmAddressDao extends BaseRepository<WvmAddress,String> {

    WvmAddress findByUserIdAndCurrencyAndTokenAndContractAddress(String userId,String currency,String token,String contractAddress);

}
