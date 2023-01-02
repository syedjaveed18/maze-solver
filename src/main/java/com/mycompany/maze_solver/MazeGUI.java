/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.maze_solver;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author ssd
 */
public class MazeGUI extends JFrame {
    int[][] maze = {
        {1,1,1,1,1,1,1,1,1,1,1,1,1},
        {1,0,1,0,1,0,1,0,0,0,0,0,1},
        {1,0,1,0,0,0,1,0,1,1,1,0,1},
        {1,0,1,1,1,1,1,0,0,0,1,0,1},
        {1,0,0,0,0,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,0,0,0,0,1},
        {1,0,1,0,1,0,0,0,1,1,1,0,1},
        {1,0,1,0,1,1,1,0,1,0,1,0,1},
        {1,0,0,0,0,0,0,0,0,0,1,9,1},
        {1,1,1,1,1,1,1,1,1,1,1,1,1}
    };
    
    //List<Integer> path = new ArrayList<>();
    
    ArrayList<Integer> path1 = new ArrayList<>();
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    
    MazeGUI(){
        setTitle("Maze Solver");
        setSize(640,480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //DepthFirst.searchPath(maze, 1, 1, path);
        //System.out.println(path);
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        DepthFirst.path(maze, 1, 1, path1,ans,visited);
        System.out.println(ans);
        int minSize = Integer.MAX_VALUE;
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i).size());
            minSize = Math.min(minSize, ans.get(i).size());
        }
        System.out.println(minSize);
    }
    
    @Override
    public void paint(Graphics g){
        g.translate(100,100);
        super.paint(g);
        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                Color color;
                switch(maze[i][j]){
                    case 1:
                        color = Color.BLACK;
                        break;
                    case 9:
                        color = Color.RED;
                        break;
                    default :
                        color = Color.WHITE;
                        break;
                }
                g.setColor(color);
                g.fillRect(30*j, 30*i, 30, 30);
                g.setColor(color.BLUE);
                g.drawRect(30*j,30*i,30,30);  
            }
        }
        int minSize = Integer.MAX_VALUE;
        for(int i = 0; i < ans.size(); i++){
            System.out.println(ans.get(i).size());
            minSize = Math.min(minSize, ans.get(i).size());
        }
        for(int i = 0; i < ans.size(); i++){
            if(ans.get(i).size() == minSize){
                for(int j = 0; j < minSize; j += 2){
                    int pathx = ans.get(i).get(j);
                    int pathy = ans.get(i).get(j+1);
                    g.setColor(Color.green);
                    g.fillRect(30*pathy+7, 30*pathx+7, 15, 15);
                }
                break;
            }
        }
//        for(int i = 0; i < ans.get(0).size(); i += 2){
//            int pathx = ans.get(0).get(i);
//            int pathy = ans.get(0).get(i+1);
//            g.setColor(Color.green);
//            g.fillRect(30*pathy+7, 30*pathx+7, 15, 15);
//        }
        
    }
    
    public static void main(String[] args){
        MazeGUI view = new MazeGUI();
        view.setVisible(true);
        System.out.println('1');
        //System.out.println(path);
    }
}
