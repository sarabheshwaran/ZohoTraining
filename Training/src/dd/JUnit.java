package dd;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Categories.class)
@IncludeCategory({Slowtest.class})

@SuiteClasses({JUnitTest.class})
public class JUnit {
	
	
	

}
