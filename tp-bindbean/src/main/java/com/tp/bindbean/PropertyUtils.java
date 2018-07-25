package com.tp.bindbean;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 属性反射工具
 */
public class PropertyUtils {

    public PropertyUtils() {
    }

    public static Annotation[] getFieldAnnotations(Class<?> clazz, String name) {
        try {
            Field f = clazz.getDeclaredField(name);
            Annotation[] annotations = f.getDeclaredAnnotations();
            return annotations;
        } catch (NoSuchFieldException var4) {
            Class<?> superClazz = clazz.getSuperclass();
            if (!superClazz.getName().equals("java.lang.Object")) {
                return getFieldAnnotations(superClazz, name);
            }

            System.out.println("No such field {}: {}" + name + var4.getMessage());
        } catch (NullPointerException var5) {
            System.out.println("Null Exception {}: {}"+ name + var5.getMessage());
        }

        return null;
    }

    public static Method getMethodForName(String name,Class cls ){
        Method[] methods = cls.getDeclaredMethods();
        if (methods!=null){
            for (Method method : methods){
                if (method.getName().equals(name)){
                    return method;
                }
            }
        }
        return  null;
    }

    /**
     * 根据 annotations 查找 cls
     * @param mAnnotation
     * @param cls
     * @return
     */
    public static Method getMethodForAnnotations(Class mAnnotation,Class cls ){
        for (Method method : cls.getDeclaredMethods()){
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (annotations !=null || annotations.length != 0){
                for (Annotation annotation : annotations){
                        if (annotation.annotationType().equals(mAnnotation)) {
                            return  method;
                        }
                    }
                }
            }
        return  null;
    }

//
//    public static Annotation[] getMethodAnnotations(Class<?> clazz, Method method) {
//        try {
//            Annotation[] annotations = method.getDeclaredAnnotations();
//            return annotations;
//        } catch (NoSuchFieldException var4) {
//            Class<?> superClazz = clazz.getSuperclass();
//            if (!superClazz.getName().equals("java.lang.Object")) {
//                return getFieldAnnotations(superClazz, name);
//            }
//
//            System.out.println("No such field {}: {}" + name + var4.getMessage());
//        } catch (NullPointerException var5) {
//            System.out.println("Null Exception {}: {}"+ name + var5.getMessage());
//        }
//
//        return null;
//    }

    public static Annotation getAnnotation(Object object, String name, Class<? extends Annotation> clazz) {
        try {
            Field f = object.getClass().getDeclaredField(name);
            return f.getAnnotation(clazz);
        } catch (NoSuchFieldException var4) {
            System.out.println("{}"+ var4);
        } catch (NullPointerException var5) {
            System.out.println("Null Exception {}: {}"+ name+ var5.getMessage());
        }

        return null;
    }

    public static void invokeSetter(Object obj, String propertyName, Object propertyValue) {
        try {
            Field field = obj.getClass().getField(propertyName);
            field.setAccessible(true);
            field.set(obj, propertyValue);
        } catch (Exception var5) {
            System.out.println("{}"+var5);
        }

    }

    /**
     * 获取属性值
     * @param obj
     * @param propertyName
     * @return
     */
    public static Object invokeGetter(Object obj, String propertyName) {
        try {
            Field field = obj.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            return field.get(obj);
        } catch(Exception var4) {
            System.out.println("{}"+ var4);
            return null;
        }
    }


}
