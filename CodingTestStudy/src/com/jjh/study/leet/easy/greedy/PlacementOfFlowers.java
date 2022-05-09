package com.jjh.study.leet.easy.greedy;

public class PlacementOfFlowers {
	public static void main(String[] args) {
		PlacementOfFlowers pof = new PlacementOfFlowers();
		pof.canPlaceFlowers(new int[] {0,1,0},1);
	}
	
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		
		if(n == 0) return true;
		
		if(flowerbed.length == 1 && n == 1) {
			if(flowerbed[0] == 1) return false;
			else if(flowerbed[0] == 0) return true;
		}
		for(int i = 0; i < flowerbed.length; i++) {
			System.out.println(i);
			if(flowerbed[i] == 0) {
				
				if((i == 0 && flowerbed[i+1] == 0) 
				   || (i != 0 && i != flowerbed.length -1 && flowerbed[i-1] == 0 && flowerbed[i+1] == 0)
 				   || (i != 0 && i == flowerbed.length -1 && flowerbed[i-1] == 0)
				   ) {
						flowerbed[i] = 1;
						count++;
				}
				
				if(count == n) return true;
			}
		}
		
        return (count == n);
    }

}
