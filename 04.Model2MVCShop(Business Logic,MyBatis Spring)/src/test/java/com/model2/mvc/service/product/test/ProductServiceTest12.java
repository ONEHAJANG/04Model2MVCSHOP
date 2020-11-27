package com.model2.mvc.service.product.test;

import java.util.ArrayList;
import java.util.List;

import sql.SqlSessionFactoryBean;

import org.apache.ibatis.session.SqlSession;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.impl.ProductDaoImpl;
import com.model2.mvc.service.product.impl.ProductServiceImpl;

public class ProductServiceTest12 {
	
	//main method
	public static void main(String[] args) throws Exception{
	
		SqlSession sqlSession = SqlSessionFactoryBean.getSqlSession();
		System.out.println("\n");
		
		ProductDaoImpl productDao=new ProductDaoImpl();
		productDao.setSqlSession(sqlSession);
		System.out.println(":: ProductDao 확인: " + productDao);
		
		ProductServiceImpl productService = new ProductServiceImpl();
		productService.setProductDao(productDao);
		System.out.println(":: ProductService 확인 : "+productService);
		
		Product product = new Product();
		product.setProdName("testProdName");
		product.setProdDetail("testProdDetail");
		product.setPrice(1234);
		product.setFileName("testFileName");
		product.setManuDate("testMenu");
		
		System.out.println(":: 1. addProduct(INSERT)  ? ");
		System.out.println(":: "+ sqlSession.insert("ProductMapper10.addProduct",product));
		System.out.println("addProduct 확인:\n"+product);
		System.out.println("\n");
		
		System.out.println(":: 2. getProduct(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper10.getProduct",product.getProdName()) );
		System.out.println("\n");
		
		product.setProdNo(10101);
		product.setProdName("updatetest");
		product.setProdDetail("updateprodDetail");
		System.out.println(":: 3. updateProduct(UPDATE)  ? ");
		System.out.println(":: "+ sqlSession.update("ProductMapper10.updateProduct",product));
		System.out.println("\n");
		
		System.out.println(":: 4. getProduct(SELECT)  ? ");
		System.out.println(":: "+sqlSession.selectOne("ProductMapper10.getProduct",product.getProdName()) );
		System.out.println("\n");
		
		System.out.println(":: 5. removeProduct (DELETE)  ? ");
		System.out.println(":: "+sqlSession.delete("ProductMapper10.removeProduct", 
																						   product.getProdNo()) );
		System.out.println("\n");
		System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////");
		System.out.println("\n");
		
		Search search = new Search();
		
//		공통test ProductMapper10.getProductList
		search.setCurrentPage(1);
		search.setPageSize(3);
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
		
//		searchCondition("0")test ProductMapper10.getProductList
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("0");
		search.setSearchKeyword("");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
		System.out.println("==================================================");
		
//		searchCondition("1") ProductMapper10.getProductList
		System.out.println("getProductList prodNo Test");
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("0");
		search.setSearchKeyword("10002");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
		System.out.println("==================================================");
		
//		searchCondition("0") ProductMapper10.getProductList
		System.out.println("getProductList prodName Test");
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("1");
		search.setSearchKeyword("보르도");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
		System.out.println("==================================================");
		
		System.out.println("getProductList price Test");
		search.setCurrentPage(1);
		search.setPageSize(3);
		search.setSearchCondition("2");
		search.setSearchKeyword("10000");
		SqlSessionFactoryBean.printList( sqlSession.selectList("ProductMapper10.getProductList",search) );
		System.out.println((sqlSession.selectList("ProductMapper10.getProductList",search)));
		System.out.println("==================================================");
		
		System.out.println("::END::SqlSession 닫기..");
		sqlSession.close();
		
	}
}