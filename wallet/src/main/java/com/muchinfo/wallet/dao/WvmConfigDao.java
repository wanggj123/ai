package com.muchinfo.wallet.dao;

import com.muchinfo.wallet.dao.repository.BaseRepository;
import com.muchinfo.wallet.pojo.WvmAddress;
import com.muchinfo.wallet.pojo.WvmConfig;
import org.springframework.stereotype.Repository;

@Repository
public interface WvmConfigDao extends BaseRepository<WvmConfig,String> {


    WvmConfig findByCode(String code);

}
