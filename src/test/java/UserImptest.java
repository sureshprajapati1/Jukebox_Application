import DAOimplClasses.UserImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserImptest {
    UserImpl userImplObj;
    @Before
    public void setup(){
        userImplObj =new UserImpl();
    }
    @After
    public void tearDown(){
        userImplObj=null;
    }
    @Test
    public void loginSuccess() {
       Boolean result= userImplObj.login("abc","abc123");
       assertTrue(true);
    }
}
