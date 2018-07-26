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

import android.view.View;

import com.chad.library.adapter.base.BaseViewHolder;

import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 项目名称: YOSHOP
 * 类描述：
 * 创建人：Created by tanping
 * 创建时间:2018/7/25 16:39
 */
public class GbBindView {

    private static final int MAX_QUERY = 30;
    static HashMap<Class, List<ViewModel>> cache;
    static ConcurrentLinkedQueue fifoAndWeightQuery;
    public static <T> void bindView(BaseViewHolder holder , T entity) throws Exception {
        List<ViewModel> result = queryCode(entity);
        //bind view
        CodeGenerator.bindView(holder,entity,result);
    }

    public static <T> void bindView(View holder , T entity) throws Exception {
        List<ViewModel> result = queryCode(entity);
        //bind view
        CodeGenerator.bindView(holder,entity,result);
    }

    private static  <T>  List<ViewModel> queryCode(T entity) throws Exception {
        if (cache == null){
            cache = new HashMap<>();
        }

        if (fifoAndWeightQuery == null){
            fifoAndWeightQuery = new ConcurrentLinkedQueue();
        }

        //重新压栈
        fifoAndWeightQuery.remove(entity.getClass());
        fifoAndWeightQuery.offer(entity.getClass());

        List<ViewModel> result =cache.get(entity.getClass());
        if (result == null){
            result = CodeGenerator.parse(entity);
            cache.put(entity.getClass(),result);
        }else {
            //加速返回
            return result;
        }

        //队列溢出
        while (fifoAndWeightQuery.size() > MAX_QUERY){
            fifoAndWeightQuery.poll();
        }



        return result;
    }
}
