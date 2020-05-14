package com.example.jdd.login.model;

import android.util.Log;

import com.example.jdd.login.contract.AffirmContract;
import com.example.jdd.net.INetCallBack;
import com.example.jdd.net.NetWorkFactory;
import com.example.jdd.net.ParamsUtils;
import com.example.jdd.net.api.URLConstants;

;import java.util.HashMap;

public class AffirmRegisterModel implements AffirmContract.IAffirmMode {
    @Override
    public <T> void register(String phoneNum, String password, String affirm_password, INetCallBack<T> iNetCallBack) {
        HashMap<String, String> commonParams = ParamsUtils.getCommonParams();
        commonParams.put("mobile",phoneNum);
        commonParams.put("password",password);
        commonParams.put("affirm_password",affirm_password);

        for (String key: commonParams.keySet()) {
            Log.e("TAG","key="+key+",values="+commonParams.get(key));
        }
        NetWorkFactory.getInstance().getNetWork().post(URLConstants.USERREGISTER,commonParams,iNetCallBack);


    }
}
