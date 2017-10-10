package es.upm.miw.apaw.user;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
    SportResourceFunctionalTesting.class,
    UserResourceFunctionalTesting.class
})
public class AllUserFunctionalTestings {

}
