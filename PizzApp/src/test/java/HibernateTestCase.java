import modelo.TestUno;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import persistencia.servicios.TestService;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/META-INF/spring-persistence-context.xml",
        "/META-INF/spring-services-context.xml" })
public class HibernateTestCase {

    @Autowired
    private TestService testService;

    @Test
    public void testSave() {
        this.testService.save(new TestUno("1"));
        assertEquals(1, this.testService.retriveAll().size());
    }

    @Test
    public void testDelete() {
        TestUno user = new TestUno("1");
        this.testService.save(user);
        this.testService.delete(user);
        assertEquals(0, this.testService.retriveAll().size());
    }

    @After
    public void cleanup() {
        this.testService.deleteAll();
    }
}
