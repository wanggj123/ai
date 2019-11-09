package com.muchinfo.wallet;

import com.alibaba.fastjson.JSON;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.muchinfo.wallet.util.WalletRpcUtil;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WalletApplicationTests {

    @Test
    public void contextLoads() throws Throwable{
        // 身份认证
//        Base64 base64 = new org.apache.commons.codec.binary.Base64();
//        String auth = "heyi" + ":" + "heyi";
//        byte[] textByte = auth.getBytes("UTF-8");
//        Map<String, String> headers = new HashMap<>(1);
//        headers.put("Authorization", "Basic " + Base64.encodeBase64String(textByte));
//
//        JsonRpcHttpClient client = new JsonRpcHttpClient(
//                new URL("http://192.168.21.70:10113"), headers);
//        LinkedHashMap result = (LinkedHashMap) client.invoke("getinfo", new Object[] {}, Object.class);
        Integer[] params = new Integer[] { Integer.valueOf(31) };
        LinkedHashMap result = WalletRpcUtil.getBlockResult("http://192.168.21.67:10202","omni_getproperty","mtpreal","appeon",new Object[] {}, Object.class);
        System.out.println(JSON.toJSONString(result));
    }

}

