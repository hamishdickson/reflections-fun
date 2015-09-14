package reflectionsFun.com.github.hamishdickson;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BeanUtilsTest extends TestCase {

    @Test
    public void testThat_simpleValidBeanReturnsTrue() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        TestBean bean = new TestBean("String1", false, 1, list);

        BeanUtils beanUtils = new BeanUtils();

        assertEquals(true, beanUtils.isValid(TestBean.class, bean));
    }

    @Test
    public void testThat_noElementsInListReturnsFalse() {
        List<Integer> list = new ArrayList<Integer>();

        TestBean bean = new TestBean("String1", false, 1, list);

        BeanUtils beanUtils = new BeanUtils();

        assertEquals(false, beanUtils.isValid(TestBean.class, bean));
    }

    @Test
    public void testThat_validatorIgnoresJsonIgnoreAnnotatedMethods() {
        List<Integer> list = new ArrayList<Integer>();
        list.add(1);

        TestBean bean = new TestBean(null, true, 1, list);

        BeanUtils beanUtils = new BeanUtils();

        assertEquals(true, beanUtils.isValid(TestBean.class, bean));
    }
}