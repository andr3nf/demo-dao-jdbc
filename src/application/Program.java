package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		System.out.println("=== TESTE 01 - seller findById ===");
		Seller seller = sellerDao.findById(3);
		//Department obj = new Department(1, "Books");
		//Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		System.out.println(seller);
		
		System.out.println("\n=== TESTE 02 - seller findByDepartment ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 03 - seller findAll ===");
		list = sellerDao.findAll();
		for (Seller obj: list) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== TESTE 04 - seller insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
		sellerDao.insert(newSeller);
		System.out.println("Inserido! Novo id = " + newSeller.getId());
		
		System.out.println("\n=== TESTE 05 - seller update ===");
		seller = sellerDao.findById(1);
		seller.setName("André Nunes");
		sellerDao.update(seller);
		System.out.println("Atualizado!");
	}

}
