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

import com.json.tanping.tpbindviewmvn.converter.annotations.ImageViewBind;
import com.json.tanping.tpbindviewmvn.converter.annotations.PriceViewBind;
import com.tp.bindbean.annotations.TextViewBind;

/**
 * 项目名称: YOSHOP
 * 类描述：
 * 创建人：Created by tanping
 * 创建时间:2018/7/25 16:55
 */
public class OKBean {

    @TextViewBind(id = R.id.textView)
    public String text ="hello wlord 为2神神道ss道";

    @ImageViewBind(id=R.id.imageView)
    public String url ="url";

    @PriceViewBind(id=R.id.textView1)
    public float price = 2.3f;
}
