package com.muchinfo.wallet.util;

import com.google.common.collect.Lists;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.muchinfo.wallet.config.WalletConfig;
import org.apache.commons.codec.binary.Base64;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WalletRpcUtil {
    /**
     * server=1
     * rpcuser=userName
     * rpcpassword=pwd
     * paytxfee=0.00001
     * minrelaytxfee=0.00001
     * rpcallowip=0.0.0.0/0
     * rpcport=10202
     * txindex=1
     * @param url
     * @param methodName
     * @param userName
     * @param pwd
     * @param obj
     * @param clazz
     * @return
     * @throws Throwable
     */
    public static LinkedHashMap getBlockResult(String url,String methodName,String userName,String pwd,Object[] obj,Class clazz) throws Throwable{
        // 身份认证
        Base64 base64 = new org.apache.commons.codec.binary.Base64();
        String auth = userName + ":" + pwd;
        byte[] textByte = auth.getBytes("UTF-8");
        Map<String, String> headers = new HashMap<>(1);
        headers.put("Authorization", "Basic " + Base64.encodeBase64String(textByte));

        JsonRpcHttpClient client = new JsonRpcHttpClient(
                new URL(url), headers);
        LinkedHashMap result = (LinkedHashMap) client.invoke(methodName, obj, clazz);
        return result;
    }

    public static <T> T getBlockResult(WalletConfig walletConfig, String methodName, Object[] obj, Class<T> clazz) {
        try {
            // 身份认证
            String auth = walletConfig.getName() + ":" + walletConfig.getPassword();
            byte[] textByte = auth.getBytes("UTF-8");
            Map<String, String> headers = new HashMap<>(1);
            headers.put("Authorization", "Basic " + Base64.encodeBase64String(textByte));

            JsonRpcHttpClient client = new JsonRpcHttpClient(
                    new URL(walletConfig.getAddress()), headers);
            return client.invoke(methodName, obj, clazz);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return null;
    }
}
