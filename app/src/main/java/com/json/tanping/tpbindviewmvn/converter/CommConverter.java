package com.json.tanping.tpbindviewmvn.converter;
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

import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.json.tanping.tpbindviewmvn.DemoBean;
import com.json.tanping.tpbindviewmvn.IDrawImageView;
import com.json.tanping.tpbindviewmvn.OKBean;
import com.json.tanping.tpbindviewmvn.R;
import com.json.tanping.tpbindviewmvn.converter.annotations.GoodsTitleBind;
import com.json.tanping.tpbindviewmvn.converter.annotations.ImageViewBind;
import com.json.tanping.tpbindviewmvn.converter.annotations.PriceViewBind;

/**
 * 项目名称: YOSHOP
 * 类描述：
 * 创建人：Created by tanping
 * 创建时间:2018/7/25 17:35
 */

public class CommConverter {

    @ImageViewBind
    public static void ssss(ImageView view, String data,IDrawImageView demoBean) {
        if (view == null){
            return;
        }
        view.setImageResource(R.drawable.sample_footer_loading);
        Log.d("XX",""+data  + " - " + demoBean);

    }


    @PriceViewBind
    public static void gbBind(TextView view, float data) {

        view.setText("price : "+data);
        Log.d("XX",""+data);

    }

    @GoodsTitleBind
    public static void dsss(ViewGroup view, float data,OKBean bean){

    }
}
