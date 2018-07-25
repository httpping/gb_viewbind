package com.tp.bindbean;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseViewHolder;
import com.json.tanping.tp_bindbean.R;
import com.tp.bindbean.annotations.TextViewBind;
import com.tp.bindbean.annotations.ViewBind;
import com.tp.bindbean.annotations.ViewBindConverter;
import com.tp.bindbean.converter.TextViewConverter;
import com.tp.bindbean.utils.BindStringUtil;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * analysis
 *
 * @author
 * @create 2018-4-20 9:59
 **/
public class CodeGenerator {


//    static HashMap<Class, List<ViewModel>> cache;

    /**
     * 解析
     * @param entity
     */
     static <T> List<ViewModel>  parse(T entity) throws Exception{
        List<ViewModel> viewModels = new ArrayList<>();

        Class cl = entity.getClass();
        for (Field field : cl.getDeclaredFields()){
            Annotation[] annotations = PropertyUtils.getFieldAnnotations(cl, field.getName());
            if (annotations !=null || annotations.length != 0){
                for (Annotation annotation : annotations){
                    if (isExist(annotation.annotationType().getAnnotations())) {
                        field.setAccessible(true);
                        ViewModel viewModel = new ViewModel();
                        viewModel.field = field;

                        Method name = annotation.getClass().getDeclaredMethod("id");
                        viewModel.idRes = (int) name.invoke(annotation);

                        Method converter = annotation.getClass().getDeclaredMethod("converter");
                        Class ccc = (Class) converter.invoke(annotation);
                        viewModel.converter =  PropertyUtils.getMethodForAnnotations(annotation.annotationType(),ccc);
                        viewModels.add(viewModel);
                    }
                }
            }
        }

        return viewModels;
//        cache.put(entity.getClass(),viewModels);

    }





    /**
     * 是否是 view bind converter 的标注
     * @param annotations
     * @return
     */
    private  static boolean isExist(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ViewBindConverter.class)) {
                return true;
            }
        }
        return  false;
    }


    /**
     *  赋值
     * @param holder
     * @param data
     * @param <T>
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     */
    static  <T> void bindView(BaseViewHolder holder, T data,List<ViewModel> binds) throws IllegalAccessException, InvocationTargetException {
        for (ViewModel viewModel : binds){
            try {
                viewModel.converter.invoke(null,holder.getView(viewModel.idRes),viewModel.field.get(data));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }

    }


}
