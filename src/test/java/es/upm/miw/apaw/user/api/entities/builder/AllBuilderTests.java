package es.upm.miw.apaw.user.api.entities.builder;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import es.upm.miw.apaw.user.api.entities.SportTest;
import es.upm.miw.apaw.user.api.entities.UserTest;

@RunWith(Suite.class)
@SuiteClasses({
    UserTest.class,
    SportTest.class
})
public class AllBuilderTests {

}
