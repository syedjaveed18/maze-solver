/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.util.*;

/**
 *
 * @author ssd
 */
public class DepthFirst {
    public static boolean searchPath(int[][] maze, int x, int y, List<Integer> path){
        if(maze[x][y] == 9){
            path.add(x);
            path.add(y);
            return true;
        }
        if(maze[x][y] == 0){
            maze[x][y] = 2;
            
            int dx = 0;
            int dy = 1;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
 
            dx = 1;
            dy = 0;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = -1;
            dy = 0;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
            dx = 0;
            dy = -1;
            if(searchPath(maze,x+dx,y+dy,path)){
                path.add(x);
                path.add(y);
                return true;
            }
            
        }
        return false;
    }
    public static void path(int[][] maze,int i,int j,ArrayList<Integer> temp,ArrayList<ArrayList<Integer>> ans,boolean[][] visited){
        int n = maze.length;
        int m = maze[0].length;
        if(i <= 0 || i >= n-1 || j <= 0 || j >= m-1 || maze[i][j] == 1 || visited[i][j] == true){
            return ;
        }
        if(maze[i][j] == 9){
            ans.add(new ArrayList<>(temp));
            return ;
        }
        visited[i][j] = true;
        
        if(maze[i][j] == 0){
            //maze[i][j] = 2;
            temp.add(i);
            temp.add(j);
        }
        
        path(maze,i,j+1,new ArrayList<>(temp),ans,visited);
        path(maze,i+1,j,new ArrayList<>(temp),ans,visited);
        path(maze,i,j-1,new ArrayList<>(temp),ans,visited);
        path(maze,i-1,j,new ArrayList<>(temp),ans,visited);
        
        visited[i][j] = false;
    }
}
