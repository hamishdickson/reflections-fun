package reflectionsFun.com.github.hamishdickson;

public class Tutorial {
   public static void main(String[] args) {
       BeanUtils beanUtils = new BeanUtils();

       beanUtils.isValid(TestBean.class, beanUtils);
   }
}
