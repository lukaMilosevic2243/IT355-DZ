import com.bizdash.dao.ShoppingCartDao;
import com.bizdash.entities.Category;
import com.bizdash.entities.Product;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/BizDash-servlet.xml"})
public class BizDash {

    @Autowired
    protected ShoppingCartDao shoppingCartDao;

    public BizDash() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void addCategoryTest() {
        Category cat = new Category();
        cat.setName("This is a new category");
        Category newCat = shoppingCartDao.addCategory(cat);
        shoppingCartDao.deleteCategory(newCat);
        Assert.assertNotNull(newCat);
    }

    @Test
    public void getCategoryByIdTest() {
        Category cat = new Category();
        cat.setName("This is a new category");
        Category newCat = shoppingCartDao.addCategory(cat);
        Category get = shoppingCartDao.getCategoryByID(newCat.getId());
        shoppingCartDao.deleteCategory(newCat);
        Assert.assertNotNull(get);
    }

    @Test
    public void createProductTest() {
        Product pro = new Product();
        pro.setName("This is a name");
        pro.setPrice(2000d);
        pro.setDescription("This is a description");
        Product newPro = shoppingCartDao.addProduct(pro);
        shoppingCartDao.deleteProduct(newPro);
        Assert.assertNotNull(newPro);
    }
    
    @Test
    public void getProductByIdTest() {
        Product pro = new Product();
        pro.setName("This is a name");
        pro.setPrice(2000d);
        pro.setDescription("This is a description");
        Product newPro = shoppingCartDao.addProduct(pro);
        Product get = shoppingCartDao.getProductByID(newPro.getId());
        shoppingCartDao.deleteProduct(newPro);
        Assert.assertNotNull(get);
    }
    
    @Test
    public void deleteProductTest() {
        Product pro = new Product();
        pro.setName("This is a name");
        pro.setPrice(2000d);
        pro.setDescription("This is a description");
        Product newPro = shoppingCartDao.addProduct(pro);
        shoppingCartDao.deleteProduct(newPro);
        Product deletedProduct = shoppingCartDao.getProductByID(newPro.getId());
        Assert.assertNull(deletedProduct);        
    }

}
