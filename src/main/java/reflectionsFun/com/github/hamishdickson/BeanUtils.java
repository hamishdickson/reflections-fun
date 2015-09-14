package reflectionsFun.com.github.hamishdickson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BeanUtils {

    public boolean isValid(Class c, Object o) {
        Class<TestBean> obj = c;

        Method[] declaredMethods = obj.getDeclaredMethods();

        for (Method declaredMethod: declaredMethods) {
            try {
                if (isNotValid(o, declaredMethod)) {
                    if (hasNoJsonIgnoreAnnotation(declaredMethod)) {
                        return false;
                    }
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return true;
    }

    private boolean hasNoJsonIgnoreAnnotation(Method declaredMethod) {
        if (hasNoAnnotation(declaredMethod)) {
            return true;
        } else {
            return declaredMethod.getDeclaredAnnotations().length > 0 && declaredMethod.getDeclaredAnnotations()[0].toString().equals("@JsonIgnore");
        }
    }

    private boolean hasNoAnnotation(Method declaredMethod) {
        return declaredMethod.getDeclaredAnnotations().length < 1;
    }

    private boolean isNotValid(Object o, Method declaredMethod) throws IllegalAccessException, InvocationTargetException {
        return declaredMethod.invoke(o) == null || (declaredMethod.invoke(o) instanceof List && ((List) declaredMethod.invoke(o)).size() < 1);
    }
}
