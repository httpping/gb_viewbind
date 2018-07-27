package com.gb.bind.adapter;
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

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 项目名称: YOSHOP
 * 类描述： 用于复杂的设计adapter模式
 * 创建人：Created by tanping
 * 创建时间:2018/7/26 9:03
 * @author tanping
 */
public interface GbMultiItemEntity<T> extends MultiItemEntity{

    /**
     * 获取item 对应的值，用于多复杂类型 adapter 使用
     * @return  x
     */
     T getItemValue();
}
