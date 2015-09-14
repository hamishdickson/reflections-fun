package reflectionsFun.com.github.hamishdickson;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class BeanUtils {

    public boolean isValid(Class c, Object o) {
        Class<TestBean> obj = c;

        Method[] declaredMethods = obj.getDeclaredMethods();

        System.out.println("Declared methods:");
        for (Method declaredMethod: declaredMethods) {
            System.out.println("Method name: " + declaredMethod.getName() + " found, type " + declaredMethod.getReturnType());
            try {
                if (declaredMethod.invoke(o) == null || (declaredMethod.invoke(o) instanceof List && ((List) declaredMethod.invoke(o)).size() < 1))
                    return false;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return true;
    }
}
