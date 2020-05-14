package com.example.jdd.login.view;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jdd.R;
import com.example.jdd.base.BaseActivity;
import com.example.jdd.login.bean.VerfiedBean;
import com.example.jdd.login.contract.ForgetPWContract;
import com.example.jdd.login.presenter.ForgetPWPresenter;


public class ForgetPassWordActivity extends BaseActivity<ForgetPWPresenter> implements ForgetPWContract.IForgetPWView {

    private String phoneNum;
    private EditText cell_phone_num;//手机号
    private EditText import_verified;//输入验证码
    private TextView verified_get;//获取验证码
    private Button next_but;
    private String verified_str;


    @Override
    protected ForgetPWPresenter initPresenter() {
        return new ForgetPWPresenter();
    }

    @Override
    public void initView() {

        Intent intent = getIntent();

        phoneNum = intent.getStringExtra("phoneNum");

        cell_phone_num = findViewById(R.id.cell_phone_num);
          import_verified = findViewById(R.id.import_verified);//输入验证码
          verified_get= findViewById(R.id.verified_get);//获取验证码
          next_but= findViewById(R.id.next_but);



        cell_phone_num.setText(phoneNum);

    }

    @Override
    public void initData() {

    }

    @Override
    public void initLinstener() {

//        在当前页面，设置手机号不可被编辑

        next_but.setOnClickListener(v -> {

            verified_str = import_verified.getText().toString().trim();

            if(!TextUtils.isEmpty(phoneNum) && !TextUtils.isEmpty(verified_str)){

                mPresenter.checkSmsCode(phoneNum, verified_str,"2");

            }else{
                Toast.makeText(this, "手机号和验证码不能为空", Toast.LENGTH_SHORT).show();
            }


        });


//发送验证码

        verified_get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.getVerified(phoneNum,"2");
            }
        });

    }

    @Override
    public int getLayoutID() {
        return R.layout.activity_forgetpassword;
    }

    @Override
    public void getVerified(VerfiedBean bean) {

        if(bean.getCode() ==1)
            Toast.makeText(this, "验证码发送成功", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "验证码发送失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void checkSmsCodeResult(VerfiedBean verfiedBean) {

        if(verfiedBean.getCode()==1){
//            验证成功以后，需要跳转页面

            Intent it = new Intent(ForgetPassWordActivity.this,AffirmPassWordActivity.class);
//            验证码和手机号发送下个页面
            it.putExtra("phoneNum",phoneNum);
            it.putExtra("verified_str",verified_str);
            startActivity(it);
        }
    }
}
