package com.leetCode;

public class Solution {
    public int islandPerimeter(int[][] grid) {
        int wholeLimits = 0;
		  //
		  for (int i = 0 ; i < grid.length;i++)
		  {
			  for (int j = 0 ; j <grid[0].length;j++)
			  {
				  if(grid[i][j]!=0)
				  {
					  int left = j-1;
					  int right = j+1;
					  int up = i-1;
					  int down = i+1;
					  int limits = 4;
					  //
					  if (left >= 0)
						  if (grid[i][left]==1)
							  limits--;
					  //
					  if (right <=grid[i].length-1 )
						  if (grid[i][right]==1)
							  limits--;
					  //
					  if (up>=0)
						  if (grid[up][j]==1) limits--;
					  //
					  if (down <= grid.length-1)
						  if (grid[down][j]==1)limits--;
					  //
					  wholeLimits+=limits;
				  }
			  }
		  }
		  
		  return wholeLimits;
    }
}
