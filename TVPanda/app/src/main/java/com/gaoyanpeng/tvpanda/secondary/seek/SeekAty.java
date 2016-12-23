package com.gaoyanpeng.tvpanda.secondary.seek;

import android.view.View;
import android.widget.ImageView;

import com.gaoyanpeng.tvpanda.R;
import com.gaoyanpeng.tvpanda.base.BaseActivity;


/**搜索跳进来的界面
 * Created by 高研鹏 on 2016/12/17.
 */
public class SeekAty extends BaseActivity implements View.OnClickListener {
    private ImageView mIconReturn;
    @Override
    protected int getLayout() {
        return R.layout.aty_seek;
    }

    @Override
    public void initView() {
        mIconReturn = findView(R.id.seek_ico_return);

    }

    @Override
    protected void initThis() {
        mIconReturn.setOnClickListener(this);

    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        finish();
    }
}
