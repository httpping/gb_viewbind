package com.tp.cache;
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

import android.content.Context;

import com.tp.cache.hawk.Hawk;


/**
 * 项目名称: YOSHOP
 * 类描述：用于缓存所有类型的数据，并提供了 简单的 base64 加密，防止直接看出文本内容。
 *
 * 创建人：Created by tanping
 * 创建时间:2018/7/31 14:18
 */
public class CacheManager {

    private static CacheManager instance;

    /**
     * 初始化，调用
     * @param context
     */
    public static void init(Context context){
        getInstance();
        try {
            if (!Hawk.isBuilt()){
                Hawk.init(context).setStorage(new DBStorage(context)).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //app 最好不要回收掉。
                Hawk.init(context).setStorage(new DBStorage(context)).build();
        }
    }
    /**
     * 单例
     * @return
     */
    public static CacheManager getInstance(){
        if (instance ==null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public static <T> boolean put(String key ,T value){
        return put(key,value,0);
    }

    /**
     *
     * @param key
     * @param value
     * @param exp 过期 秒
     * @param <T>
     * @return
     */
    public static <T> boolean put(String key ,T value,int exp){
        if (instance == null){
            getInstance();
        }

        /*CachePackage cachePackage  = new CachePackage();
        cachePackage.exp = exp;
        if (cachePackage.exp>0){
            cachePackage.timestamp = System.currentTimeMillis();
        }
        cachePackage.v = value;
        if (value!=null){
            cachePackage.cls = value.getClass().getName();
        }*/


        return Hawk.put(key,value);
    }

    public static <T> T get(String key) {
       return  get(key,null);
    }


    public static <T> T get(String key, T defaultValue) {
       /* if (instance == null){
            getInstance();
        }
        CachePackage result = (CachePackage)Hawk.get(key, defaultValue);
        if (result == null){
            return defaultValue;
        }
        if (result.isExp()){
            //过期了
            delete(key);
            return defaultValue;
        }

        if (result.getValue() == null){
            return (T) result.v;
        }*/

        return  Hawk.get(key,defaultValue);
    }





    /**
     * 统计所有缓存key 数量
     * @return void
     */
    public static long count() {
        if (instance == null){
            getInstance();
        }
        return Hawk.count();
    }

    /**
     * 清空所有缓存
     * @return true
     */
    public static boolean deleteAll() {
        if (instance == null){
            getInstance();
        }
        return Hawk.deleteAll();
    }

    /**
     * 删除制定缓存
     * @return true
     */
    public static boolean delete(String key) {
        if (instance == null){
            getInstance();
        }
        return Hawk.delete(key);
    }

    /**
     * contains 是否包含
     * @return true
     */
    public static boolean contains(String key) {
        if (instance == null){
            getInstance();
        }
        return Hawk.contains(key);
    }

}
