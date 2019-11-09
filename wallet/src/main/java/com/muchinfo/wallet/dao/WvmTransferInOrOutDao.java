package com.muchinfo.wallet.dao;

import com.muchinfo.wallet.dao.repository.BaseRepository;
import com.muchinfo.wallet.pojo.WvmTransferInOrOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WvmTransferInOrOutDao extends BaseRepository<WvmTransferInOrOut,String> {



}
