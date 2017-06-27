package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;


import model.Ave;
import model.Canido;
import model.Felino;
import model.Mascota;
import model.Roedor;

public class TestCollection implements Comparator<Mascota>{

	Comparator<Mascota> comparator = new Comparator<Mascota>(){
		@Override
		public int compare(Mascota o1, Mascota o2) {
			return o1.getNombre().toLowerCase()
					.compareTo(o2.getNombre().toLowerCase()); 	
		}
	};
	
	
	
    //test 1
	//@Test
	public void testArrayList(){
		
		ArrayList<Mascota> list = new ArrayList<Mascota>();
		
		
		list.add(new Ave("Piolin",0.5f,10f,20f));
		list.add(new Ave("Lukas",0.6f,10f,20f));
		list.add(new Felino("Tom",4.5f,15f,20f));
		list.add(new Canido("Dog",10.5f,20f,20f));
		
		Assert.assertEquals(4,list.size()); 
		
		showList(list); 
		
		
		ArrayList<Mascota> newList = new ArrayList<Mascota>();
		
		newList.addAll(list); 
		newList.add(new Roedor("Miki", 0.3f, 1,1.5f)); 
		showList(newList); 
	    
		//Collections.sort(list, comparator );
 		
	}
	
	// test 2 
	//@Test
	public void testArrayListSort1(){
		
		ArrayList<Mascota> list = new ArrayList<Mascota>();
		list.add(new Ave("Piolin",0.5f,10f,20f));
		list.add(new Ave("Lukas",0.3f,10f,20f));
		list.add(new Felino("Tom",4.5f,15f,20f));
		list.add(new Canido("Dog",10.5f,20f,20f));
		
		Assert.assertEquals(4,list.size()); 
		
	
		// Recibe una interface llama Comparator 
		// ver en: 
		// https://docs.oracle.com/javase/7/docs/api/java/util/Comparator.html
		// no debe implementar la interface en la clase del test, eso solo es un 
		// ejemplo, ver test 3
		
		list.sort(this); 
		showList(list); 
 		
	}
	
	
	
	
	    // test 3 
		//@Test
		public void testArrayListSort2(){
			
			ArrayList<Mascota> list = new ArrayList<Mascota>();
			list.add(new Ave("Piolin",0.5f,8f,20f));
			list.add(new Ave("Lukas",0.3f,5f,20f));
			list.add(new Felino("Tom",4.5f,15f,20f));
			list.add(new Canido("Dog",10.5f,20f,20f));
			
			Assert.assertEquals(4,list.size()); 
			
			// Implemetacion de Comparator de forma anonima
			list.sort(new Comparator<Mascota>(){
						@Override
						public int compare(Mascota o1, Mascota o2) {
							int r = 0; 
							if(o1.getAltura()<o2.getAltura()){
								r = -1; 
							}else if(o1.getAltura()>o2.getAltura()){
								r = 1; 
							}
							return r;
						}
					  }
					 ); 
			
			
			showList(list); 
	 		
		}
		
	
		 // test 4
		@Test
		public void testArrayListSort3(){
			
			ArrayList<Mascota> list = new ArrayList<Mascota>();
			list.add(new Ave("aaPiolin",0.5f,8f,20f));
			list.add(new Ave("aabLukas",0.3f,5f,20f));
			list.add(new Felino("Tom",4.5f,15f,20f));
			list.add(new Canido("Dog",10.5f,20f,20f));
			
			Assert.assertEquals(4,list.size()); 
			
	
			// Implemetacion de Comparator de forma anonima
			list.sort(comparator); 
			
			showList(list); 
	 		
		}
		
		
	
	/**
	 * Implementacion de comparator para test 1
	 */
	@Override
	public int compare(Mascota o1, Mascota o2) {
		int r = 0; 
		if(o1.getPeso()>o2.getPeso()){
			r = -1; 
		}else if(o1.getPeso()<o2.getPeso()){
			r = 1; 
		}
		return r;
	}
	


	
	
	
	/**
	 * Muestra una lista de mascotas. 
	 * @param list
	 */
	private void showList(ArrayList<Mascota> list) {
		System.out.println(""); 
		System.out.println("ArrayList size: " + list.size()); 
		for(int i=0; i< list.size(); i++){
			System.out.println(list.get(i).getNombre() +
					" \tpesa: " + list.get(i).getPeso() + 
					" \talto: " + list.get(i).getAltura());  
		}
	}
	
	
}
