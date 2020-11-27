package com.model2.mvc.service.product.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;

public class ProductServiceTest13 {
	//field
	private int prodNo;
	//main method
	public static void main(String[] args) throws Exception{
		
		ApplicationContext context =
				new ClassPathXmlApplicationContext(
																	new String[] {	"/config/commonservice.xml",
																						"/config/productservice.xml" }
									                                  );
		System.out.println(":: 생성확인");
		
		ProductService productService= (ProductService)context.getBean("productServiceImpl");
	
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
		Product product = new Product();
		product.setProdName("testProdName");
		product.setProdDetail("testProdDetail");
		product.setManuDate("testMenu");
		product.setPrice(1234);
		product.setFileName("testFileName");
		
		System.out.println(product);
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		productService.addProduct(product);
		System.out.println("addProduct 확인:\n"+product);
		System.out.println("\n");
		
		System.out.println(":: 2. getProduct(SELECT)  ? ");
		System.out.println(":: "+productService.getProduct(product.getProdNo()) );
		System.out.println("\n");
		
		product.setProdNo(10101);
		product.setProdName("updatetest");
		product.setProdDetail("updateprodDetail");
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		productService.updateProduct(product);
		System.out.println("\n");
		
		System.out.println(":: 4. getProduct(SELECT)  ? ");
		Search search=new Search();
		search.setSearchCondition("prodNo");
		ArrayList<Integer> arrayList=new ArrayList<Integer>();
		arrayList.add(10101);
		search.setProdNo(arrayList);
		System.out.println(":: "+productService.getProduct(product.getProdNo()) );
		System.out.println("\n");
		
		System.out.println(":: 5. removeProduct (DELETE)  ? ");
		System.out.println(":: "+productService.removeProduct(product.getProdNo()) );
		System.out.println("\n");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n");
		
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
}