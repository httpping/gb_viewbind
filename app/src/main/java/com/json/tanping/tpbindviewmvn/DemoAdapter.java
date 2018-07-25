package com.json.tanping.tpbindviewmvn;
/*

                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         佛祖保佑       永无BUG

*/

import com.chad.library.adapter.base.BaseViewHolder;
import bind.adapter.GBBaseBindAdapter;
import bind.annotations.BindItem;

import java.util.List;

/**
 * 项目名称: YOSHOP
 * 类描述：
 * 创建人：Created by tanping
 * 创建时间:2018/7/25 14:15
 */
public class DemoAdapter extends GBBaseBindAdapter<DemoBean,BaseViewHolder> {
    public DemoAdapter(List<DemoBean> data) {
        super(data);
    }

    @BindItem(layout = R.layout.item_one)
    public void one(BaseViewHolder helper,DemoBean bean) throws Exception {

    }

    @Override
    public boolean isOpenAutoBindView() {
        return true;
    }
}
