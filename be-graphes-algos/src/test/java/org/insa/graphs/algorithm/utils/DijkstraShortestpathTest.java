package org.insa.graphs.algorithm.utils;

import org.junit.Test;

public class DijkstraShortestpathTest {

	@Test
	//@Test
	public void testMode0() throws Exception {
		String carte = "/home/bordais-/Gabriel/3AMIC/S2/BeGraphes/BeGraphes/Maps/haute-garonne.mapgr";
		
		ShortestPathTest test = new  ShortestPathTest ();	
		int orgn, dest;
		
		System.out.println("-----------------------------------------------");
		System.out.println("Avec oracle :oui");
		System.out.println("Carte :Haute Garonne");
		System.out.println("Mode: Shortest path, all roads allowed ");
		System.out.println();
		
		System.out.println("chemin nul :");	
		orgn=0;	dest=0;
		test.avecOracle(carte, 0, orgn, dest);  
			
		System.out.println("chemin simple :");
		orgn = 127949; dest = 41899;
		test.avecOracle(carte, 0, orgn, dest);    	
			
		System.out.println("Sommets inexistants :");
		orgn = -1;	dest = 41899;
		test.avecOracle(carte, 0, orgn, dest);    	


	}
	
	@Test
	//@Test
	public void testMode1() throws Exception {
		String carte = "/home/bordais-/Gabriel/3AMIC/S2/BeGraphes/BeGraphes/Maps/haute-garonne.mapgr";
		
		ShortestPathTest test = new  ShortestPathTest ();	
		int orgn, dest;
		
		System.out.println("-----------------------------------------------");
		System.out.println("Avec oracle : oui ");
		System.out.println("Carte : Haute Garonne");
		System.out.println("Mode: Shortest path, only roads open for cars ");
		System.out.println();
			
		System.out.println("chemin simple :");
		orgn = 127949; dest = 41899;
		test.avecOracle(carte, 1, orgn, dest);    	

	}
	
	@Test
	//@Test
	public void testMode2() throws Exception {
		String carte = "/home/bordais-/Gabriel/3AMIC/S2/BeGraphes/BeGraphes/Maps/haute-garonne.mapgr";
		
		ShortestPathTest test = new  ShortestPathTest ();	
		int orgn, dest;
			
		System.out.println("-----------------------------------------------");
		System.out.println("Avec oracle : oui");
		System.out.println("Carte : Toulouse ");
		System.out.println("Mode : Fastest path, all roads allowed  ");
		System.out.println();
		
			
		System.out.println("Chemin simple :");
		orgn = 93657 ; dest= 46591;
		test.avecOracle(carte, 2, orgn, dest);    	

		System.out.println("Sommets inexistants :");
		orgn = -1; dest= 50000;
		test.avecOracle(carte, 2, orgn, dest);    

  	
	}
	
	@Test
	//@Test
	public void testMode3() throws Exception {
		String carte = "/home/bordais-/Gabriel/3AMIC/S2/BeGraphes/BeGraphes/Maps/toulouse.mapgr";
		
		ShortestPathTest test = new  ShortestPathTest ();	
		int orgn, dest;
			
		System.out.println("-----------------------------------------------");
		System.out.println("Avec oracle : oui");
		System.out.println("Carte : Toulouse");
		System.out.println("Mode : Fastest path, only roads open for cars  ");
		System.out.println();
		
			
		System.out.println("Chemin simple :");
		orgn = 4548; dest = 4984;
		test.avecOracle(carte, 3, orgn, dest);    	
 
  	
	}
	
	@Test
	//@Test
	public void testMode4() throws Exception {
		String carte = "/home/bordais-/Gabriel/3AMIC/S2/BeGraphes/BeGraphes/Maps/toulouse.mapgr";
		
		ShortestPathTest test = new  ShortestPathTest ();	
		int orgn, dest;
			
		System.out.println("-----------------------------------------------");
		System.out.println("Avec oracle : oui");
		System.out.println("Carte : Toulouse ");
		System.out.println("Mode : Fastest path for pedestrian ");
		System.out.println();
		
		System.out.println("Chemin simple :");
		orgn = 4548; dest = 4984;
		test.avecOracle(carte, 4, orgn, dest);    	
 
  	
	}
	
	@Test
	//@Test
	public void testSansOracle() throws Exception {
		String carte = "/home/bordais-/Gabriel/3AMIC/S2/BeGraphes/BeGraphes/Maps/toulouse.mapgr";
		
		ShortestPathTest test = new  ShortestPathTest ();	
		int orgn, dest;
			
		System.out.println("-----------------------------------------------");
		System.out.println("Avec oracle : non");
		System.out.println("Caerte : Toulouse");
		System.out.println();
		
		System.out.println("Chemin nul :");	
		orgn=0;	dest=0;
		test.sansOracle(carte, orgn, dest);  
			
		System.out.println("Chemin simple :");
		orgn = 4548; dest = 4984;
		test.sansOracle(carte, orgn, dest);    	

	}
	
}