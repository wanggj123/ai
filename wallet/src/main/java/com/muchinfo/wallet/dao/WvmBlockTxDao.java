package com.muchinfo.wallet.dao;

import com.muchinfo.wallet.dao.repository.BaseRepository;
import com.muchinfo.wallet.pojo.WvmBlockTx;
import org.springframework.stereotype.Repository;

@Repository
public interface WvmBlockTxDao extends BaseRepository<WvmBlockTx, String> {

}
