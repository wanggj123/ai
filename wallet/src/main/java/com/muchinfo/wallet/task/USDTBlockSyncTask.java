package com.muchinfo.wallet.task;

import com.alibaba.fastjson.JSON;
import com.muchinfo.wallet.WalletConst;
import com.muchinfo.wallet.config.WalletConfig;
import com.muchinfo.wallet.dao.WvmBlockTxDao;
import com.muchinfo.wallet.dao.WvmConfigDao;
import com.muchinfo.wallet.dto.OmniListTransactionsDto;
import com.muchinfo.wallet.pojo.WvmBlockTx;
import com.muchinfo.wallet.pojo.WvmConfig;
import com.muchinfo.wallet.util.WalletRpcUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 同步USDT区块
 */

@Slf4j
@Component
public class USDTBlockSyncTask {
    @Autowired
    private WvmConfigDao wvmConfigDao;
    @Autowired
    private WalletConfig walletConfig;
    @Autowired
    private WvmBlockTxDao wvmBlockTxDao;

    @Scheduled(cron = "0/10 * * * * *")
    public void scheduled(){
        log.info("同步USDT区块高度任务开始执行");
        WvmConfig wvmConfig = this.wvmConfigDao.findByCode(WalletConst.BLOCK_COUNT);
        //获取当前节点中区块高度
        Long walletCount = WalletRpcUtil.getBlockResult(walletConfig,WalletConst.GET_BLOCK_COUNT,new Object[]{},Long.class);
        //如果数据库配置节点小于节点服务器中的区块链区块高度则取数据库高度进行数据获取
        log.info("处理区块高度:{},节点区块高度:{}",wvmConfig.getValue(),walletCount);
        while(Long.valueOf(wvmConfig.getValue())<walletCount){
            //获取交易数据并入库 一个区块一个区块的轮训取数据
            Object[] param = new Object[]{"*",WalletConst.DEFAULT_PAGE_COUNT,WalletConst.DEFAULT_PAGE_SKIP_COUNT,
                    Long.valueOf(wvmConfig.getValue()),Long.valueOf(wvmConfig.getValue())};
            List<OmniListTransactionsDto> result = WalletRpcUtil.getBlockResult(walletConfig,WalletConst.OMNI_LISTTRANSACTIONS,param, ArrayList.class);
            List<OmniListTransactionsDto> transactionList = JSON.parseArray(result.toString(),OmniListTransactionsDto.class);
            for(OmniListTransactionsDto transaction : transactionList){
                WvmBlockTx block = new WvmBlockTx();
                block.setId(transaction.getTxid());
                block.setCurrency(WalletConst.USDT);
                block.setSendAddress(transaction.getSendingaddress());
                block.setReferenceAddress(transaction.getReferenceaddress());
                block.setAmount(transaction.getAmount());
                block.setDigFee(transaction.getFee());
                block.setBlockTime(transaction.getBlocktime());
                block.setPropertyId(transaction.getPropertyid());
                block.setConfirmations(transaction.getConfirmations());
                this.wvmBlockTxDao.saveAndFlush(block);
            }
            wvmConfig.setValue(String.valueOf(Long.valueOf(wvmConfig.getValue())+1L));
            this.wvmConfigDao.saveAndFlush(wvmConfig);
        }
    }
}
