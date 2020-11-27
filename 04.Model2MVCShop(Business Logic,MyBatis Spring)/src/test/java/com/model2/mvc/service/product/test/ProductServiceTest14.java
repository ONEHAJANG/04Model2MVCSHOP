package com.model2.mvc.service.product.test;

import java.util.ArrayList;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductDao;
import com.model2.mvc.service.product.ProductService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:config/commonservice.xml" })
public class ProductServiceTest14 {
	//field
	@Autowired
	@Qualifier("productServiceImpl")
	private ProductService productService;
	
	@Autowired
	@Qualifier("productDaoImpl")
	private ProductDao productDao;
	
	//main method
//	public static void main(String[] args) throws Exception{
//		
//		ApplicationContext context =
//				new ClassPathXmlApplicationContext(
//																	new String[] {	"/config/commonservice.xml",
//																						"/config/productservice.xml" }
//									                                  );
//		System.out.println(":: 생성확인");
//		
//		ProductService productService= (ProductService)context.getBean("productServiceImpl");
//	
//		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
//		System.out.println("\n");
//		
//		ProductDaoImpl productDao=new ProductDaoImpl();
//		productDao.setSqlSession(sqlSession);
//		System.out.println(":: ProductDao 확인: " + productDao);
//		
//		ProductServiceImpl productService = new ProductServiceImpl();
//		productService.setProductDao(productDao);
//		System.out.println(":: ProductService 확인 : "+productService);
//		
		@Test
		public void testAddProduct() throws Exception {
		Product product = new Product();
		product.setProdName("마음대로");
		product.setProdDetail("마마음대로");
		product.setManuDate("마마음음대로");
		product.setPrice(1234);
		product.setFileName("마마음음대대로");
		
		productService.addProduct(product);
		
		product=productService.getProduct(10000);
		
		System.out.println(product);
		
//		Assert.assertEquals(10000, product.getProdNo());
		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals("testManuDate", product.getManuDate());
		Assert.assertEquals(100000, product.getPrice());
		Assert.assertEquals(20201010, product.getRegDate());
		}
		
		//@Test
		public void testGetProduct() throws Exception {
		Product product = new Product();
		
		product=productService.getProduct(10101);
		
		Assert.assertEquals("testProdNo", product.getProdNo());
		Assert.assertEquals("testProdName", product.getProdName());
		Assert.assertEquals("testProdDetail", product.getProdDetail());
		Assert.assertEquals("testManuDate", product.getManuDate());
		Assert.assertEquals(100000, product.getPrice());
		Assert.assertEquals(20201010, product.getRegDate());
		}
		
		//@Test
		public void testUpdateProduct() throws Exception{
		
			Product product = new Product();
			
			product=productService.getProduct(10101);
			
			Assert.assertEquals("testProdNo", product.getProdNo());
			Assert.assertEquals("testProdName", product.getProdName());
			Assert.assertEquals("testProdDetail", product.getProdDetail());
			Assert.assertEquals("testManuDat", product.getManuDate());
			Assert.assertEquals(100000, product.getPrice());
			Assert.assertEquals(20201010, product.getRegDate());
			
			product.setProdName("updateProdName");
			product.setProdDetail("updateProdDetail");
			product.setManuDate("updateMenu");
			product.setPrice(9999);
			
			productService.updateProduct(product);
			
			product=productService.getProduct(10101);
			Assert.assertNotNull(product);
			
			Assert.assertEquals("testProdName", product.getProdName());
			Assert.assertEquals("testProdDetail", product.getProdDetail());
			Assert.assertEquals("testManuDate", product.getManuDate());
			Assert.assertEquals(100000, product.getPrice());
			
		}
//		System.out.println(":: 4. getProduct(SELECT)  ? ");
//		Search search=new Search();
//		search.setSearchCondition("prodNo");
//		ArrayList<Integer> arrayList=new ArrayList<Integer>();
//		arrayList.add(10101);
//		search.setProdNo(arrayList);
//		System.out.println(":: "+productService.getProduct(product.getProdNo()) );
//		System.out.println("\n");
//		
//		System.out.println(":: 5. removeProduct (DELETE)  ? ");
//		System.out.println(":: "+productService.removeProduct(product.getProdNo()) );
//		System.out.println("\n");
//		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
//		System.out.println("\n");
//		
//		Search search = new Search();
//		
////		공통test ProductMapper10.getProductList
//		search.setCurrentPage(1);
//		search.setPageSize(3);
//		SqlSessionFactoryBean.printList( productService.selectList("ProductMapper10.getProductList",search) );
//		System.out.println((productService.selectList("ProductMapper10.getProductList",search)));
//		
////		searchCondition("0")test ProductMapper10.getProductList
//		search.setCurrentPage(1);
//		search.setPageSize(3);
//		search.setSearchCondition("0");
//		search.setSearchKeyword("");
//		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
//		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
//		System.out.println("==================================================");
//		
////		searchCondition("1") ProductMapper10.getProductList
//		System.out.println("getProductList prodNo Test");
//		search.setCurrentPage(1);
//		search.setPageSize(3);
//		search.setSearchCondition("0");
//		search.setSearchKeyword("10002");
//		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
//		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
//		System.out.println("==================================================");
//		
////		searchCondition("0") ProductMapper10.getProductList
//		System.out.println("getProductList prodName Test");
//		search.setCurrentPage(1);
//		search.setPageSize(3);
//		search.setSearchCondition("1");
//		search.setSearchKeyword("보르도");
//		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
//		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
//		System.out.println("==================================================");
//		
//		System.out.println("getProductList price Test");
//		search.setCurrentPage(1);
//		search.setPageSize(3);
//		search.setSearchCondition("2");
//		search.setSearchKeyword("10000");
//		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
//		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
//		System.out.println("==================================================");
//		
//		System.out.println("::END::SqlSession 닫기..");
//		sqlSession.close();
		
	}
