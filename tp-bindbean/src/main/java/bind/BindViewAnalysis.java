package bind;

import bind.annotations.BindItem;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * bind view analysis
 *
 * @author tanping
 * 2018-7-25 9:59
 **/
public class BindViewAnalysis {

    static   Class[] Annotations = {BindItem.class};


    /**
     * 解析 class
     * @param entity 解析 class
     * @param <T> x
     * @return x
     * @throws Exception x
     */
    public static <T> HashMap<Integer, BindModel>  parse(T entity) throws Exception{
        HashMap<Integer, BindModel> result = new HashMap<>();
        Class cl = entity.getClass();
        for (Method method : cl.getDeclaredMethods()){
            Annotation[] annotations = method.getDeclaredAnnotations();
            if (annotations !=null || annotations.length != 0){
                for (Annotation annotation : annotations){
                    for (Class cls : Annotations) {
                        if (annotation.annotationType().equals(cls)) {
                            BindModel BindModel = new BindModel();
                            BindModel.method = method;
                            Method name = annotation.getClass().getDeclaredMethod("type");
                            int type = (int) name.invoke(annotation);
                            name = annotation.getClass().getDeclaredMethod("layout");
                            int layout = (int) name.invoke(annotation);
                            BindModel.type = type;
                            BindModel.layout = layout;
                            result.put(type,BindModel);
                        }
                    }
                }
            }
        }
        return result;

    }



}
