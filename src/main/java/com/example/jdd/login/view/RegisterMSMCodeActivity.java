package com.example.jdd.login.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.example.jdd.R;
import com.example.jdd.base.BaseActivity;
import com.example.jdd.login.bean.VerfiedBean;
import com.example.jdd.login.contract.RegisterMSMContract;
import com.example.jdd.login.presenter.RegisterMSMPresenter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterMSMCodeActivity extends BaseActivity<RegisterMSMPresenter> implements RegisterMSMContract.IRegisterMSMView {

    private EditText reg_phone_num;
    private EditText reg_verfied;
    private Button reg_send_verfied_bug;
    private Button reg_bug;
    private String reg_edit_phone_num;
    private String reg_edit_sms_code;

    @Override
    protected RegisterMSMPresenter initPresenter() {
        return new RegisterMSMPresenter();
    }

    @Override
    public void initView() {
        reg_phone_num = findViewById(R.id.reg_phone_num);
        reg_verfied= findViewById(R.id.reg_verified);
        reg_send_verfied_bug= findViewById(R.id.reg_send_verfied_bug);
        reg_bug= findViewById(R.id.reg_but);
    }

    @Override
    public void initData() {
    }
    @Override
    public void initLinstener() {
//   获得验证码
        reg_send_verfied_bug.setOnClickListener(v->{

            String phonenum = reg_phone_num.getText().toString();
            if( !TextUtils.isEmpty(phonenum) && isMobileNO(phonenum)){
//                  表示可以发送验证码
                mPresenter.getVerified(phonenum,"1");
                Toast.makeText(RegisterMSMCodeActivity.this, "发送验证码", Toast.LENGTH_SHORT).show();
            }else Toast.makeText(RegisterMSMCodeActivity.this, "请输入正确得手机号", Toast.LENGTH_SHORT).show();
        });


//        注册
        reg_bug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reg_edit_phone_num = reg_phone_num.getText().toString();
                reg_edit_sms_code = reg_verfied.getText().toString();
                if(!TextUtils.isEmpty(reg_edit_phone_num) && isMobileNO(reg_edit_phone_num)){
                    if (!TextUtils.isEmpty(reg_edit_sms_code)){
                        Pattern pattern = Pattern.compile("\\d{6}");
                        boolean matches = pattern.matcher(reg_edit_sms_code).matches();
                        if(matches){

                            mPresenter.checkSmsCode(reg_edit_phone_num,reg_edit_sms_code,"1");
                        }
                    }
                }
            }
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_register_smscode;
    }

//    验证码返回获取
    @Override
    public void getVerified(VerfiedBean s) {

        if(s.getCode()==1)
            Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();

    }
    @Override
    public void getLoginResult(String string) {
    }
    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {

        if(verfiedBean.getCode()==1){
//            跳转另一个页面了
            Intent intent = new Intent(this,AffirmRegisterActivity.class);
            intent.putExtra("phoneNum",reg_edit_phone_num);
            startActivity(intent);

        }

    }



    public static boolean isMobileNO(String mobiles){
        boolean flag = false;
        try{
            Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
            Matcher m = p.matcher(mobiles);
            flag = m.matches();
        }catch(Exception e){
            Log.e("TAG","手机号错误"+e.getMessage());
            flag = false;
        }
        return flag;
    }

}
