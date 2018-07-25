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

import android.support.annotation.IdRes;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 项目名称: YOSHOP
 * 类描述： v  t method 转换器
 * 创建人：Created by tanping
 * 创建时间:2018/7/25 14:53
 */
public class ViewModel<V,T> {
    public @IdRes int idRes ;
    public Method converter;
    public Field field;


   /* public void one(String abc){

    }

    public void two(){
        Object bok ="ss";
        one((String) bok);
    }*/
}
