package com.tp.bindbean;
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

import java.util.HashMap;
import java.util.List;

/**
 * 项目名称: YOSHOP
 * 类描述：
 * 创建人：Created by tanping
 * 创建时间:2018/7/25 16:39
 */
public class GbBindView {

    static HashMap<Class, List<ViewModel>> cache;
    public static <T> void bindView(BaseViewHolder holder , T entity) throws Exception {
        if (cache == null){
            cache = new HashMap<>();
        }

        List<ViewModel> result =cache.get(entity.getClass());
        if (result == null){
            result = CodeGenerator.parse(entity);
            cache.put(entity.getClass(),result);
        }
        //bind view
        CodeGenerator.bindView(holder,entity,result);
    }
}
