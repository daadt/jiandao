package com.example.jdd.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdd.R;
import com.example.jdd.base.BaseActivity;
import com.example.jdd.login.bean.VerfiedBean;
import com.example.jdd.login.contract.AffirmPassWordContract;
import com.example.jdd.login.presenter.AffirmPaswPresenter;


public class AffirmPassWordActivity extends BaseActivity<AffirmPaswPresenter> implements AffirmPassWordContract.IAffirmPaswView {

    private Button update_but;// 完成
    private EditText cell_password;// 密码
    private EditText affirm_psw;// 确认密码
    private String phoneNum;
    private String verified_str;
    
    @Override
    protected AffirmPaswPresenter initPresenter() {
        return new AffirmPaswPresenter();
    }

    @Override
    public void initView() {


        Intent intent = getIntent();
        phoneNum = intent.getStringExtra("phoneNum");
        verified_str = intent.getStringExtra("verified_str");

        cell_password = findViewById(R.id.cell_password);
        affirm_psw = findViewById(R.id.affirm_psw);
        update_but = findViewById(R.id.update_but);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {
        update_but.setOnClickListener(v -> {
            String pasw_str = cell_password.getText().toString().trim();
            String apw = affirm_psw.getText().toString().trim();
            
            if(!TextUtils.isEmpty(pasw_str) && !TextUtils.isEmpty(apw)){
//                当前页面只有验证码
                if(pasw_str.equals(apw)){
                    mPresenter.forgetPasw(phoneNum,verified_str,pasw_str);
                }

            }else Toast.makeText(this, "密码不可以为空", Toast.LENGTH_SHORT).show();
            
        });
    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_affirmpassword;
    }

    @Override
    public void registerResult(VerfiedBean bean) {

        if(bean.getCode()==1){
            //短信验证码正确，且密码修改成功
            Intent its = new Intent(AffirmPassWordActivity.this,LoginActivity.class);
            startActivity(its);
        }else {
            Toast.makeText(this, bean.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
