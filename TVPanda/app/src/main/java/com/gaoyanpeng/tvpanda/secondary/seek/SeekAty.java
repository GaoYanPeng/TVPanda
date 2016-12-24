package com.gaoyanpeng.tvpanda.secondary.seek;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.base.BaseActivity;
import com.gaoyanpeng.tvpanda.view.searchview.JJSearchView;
import com.gaoyanpeng.tvpanda.view.searchview.anim.controller.JJCircleToSimpleLineController;


/**搜索跳进来的界面
 * Created by 高研鹏 on 2016/12/17.
 */
public class SeekAty extends BaseActivity implements View.OnClickListener {
    private ImageView mIconReturn,seekShouye;
    /**
     * 之定义 View
     */
    JJSearchView mJJSearchView;
    private EditText mEd;
    @Override
    protected int getLayout() {
        return R.layout.aty_seek;
    }

    @Override
    public void initView() {
        mIconReturn = findView(R.id.seek_ico_returns);
        mJJSearchView = findView(R.id.jjsv);
        /**
         * View 初始化 new 一下
         */
        mJJSearchView.setController(new JJCircleToSimpleLineController());
        mEd =findView(R.id.seek_et_text);
        seekShouye = findView(R.id.seek_shouye);

    }

    @Override
    protected void initThis() {
        mIconReturn.setOnClickListener(this);
        mJJSearchView.setOnClickListener(this);
        seekShouye.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.seek_ico_returns:
                finish();
                break;
            case R.id.jjsv:
                mJJSearchView.startAnim();
                mEd.setVisibility(View.VISIBLE);
                seekShouye.setVisibility(View.VISIBLE);
                mJJSearchView.setClickable(false);
                mEd.setText("");
                break;
            case R.id.seek_shouye:
                mJJSearchView.resetAnim();
                mEd.setVisibility(View.GONE);
                seekShouye.setVisibility(View.GONE);
                mJJSearchView.setClickable(true);
                break;

        }
    }
}
