package datastructure;

import java.io.*;  
class Stack  
{  
 private int size;  
 private int[] st;  
 private int top;  
 public Stack(int s)  
 {  
  size=s;  
  st=new int[size];  
  top=-1;  
 }  
 public void push(int key)  
 {  
  st[++top]=key;  
 }  
 public int pop()  
 {  
  return(st[top--]);  
 }  
 public int peek()  
 {  
  return(st[top]);  
 }  
 public boolean isEmpty()  
 {  
  return (top==-1);  
 }  
}  
class Queue  
{  
 private int size;  
 private int[] queArray;  
 private int front;  
 private int rear;  
 public Queue(int s)  
 {  
  size=s;  
  queArray=new int[size];  
  front=0;  
  rear=-1;  
 }  
 public void insert(int j)  
 {  
  if(rear==size-1)  
   rear=-1;  
  queArray[++rear]=j;  
 }  
 public int remove()  
 {  
  int temp=queArray[front++];  
  if(front==size)  
   front=0;  
  return temp;  
 }  
 public boolean isEmpty()  
 {  
  return(rear+1==front||(front+size-1==rear));  
 }  
}  
class Vertex  
{  
 public char label;  
 public boolean wasVisited;  
 public Vertex(char lab)  
 {  
  label=lab;  
  wasVisited=false;  
 }  
}  
class Graph  
{  
 private int maxVertex;  
 private Vertex vertexList[];  
 private int adjMat[][];  
 private int nVert;  
 private Stack theStack;  
 private Queue theQueue;  
 public Graph(int s)  
 {  
  maxVertex=s;  
  vertexList=new Vertex[maxVertex];  
  adjMat=new int[maxVertex][maxVertex];  
  nVert=0;  
  for(int j=0;j<maxVertex;j++)  
   for(int k=0;k<maxVertex;k++)  
    adjMat[j][k]=0;  
  theStack=new Stack(s);  
  theQueue=new Queue(s);  
 }  
 public void addVertex(char lab)  
 {  
  if(nVert==maxVertex)  
   System.out.println("Vertex limit exceeded ");  
  else  
   vertexList[nVert++]=new Vertex(lab);  
 }  
 public void addEdge(char start,char end)  
 {  
  int i,j;  
  for(j=0;j<nVert;j++)  
   if(vertexList[j].label==start)  
    break;  
  for(i=0;i<nVert;i++)  
   if(vertexList[i].label==end)  
    break;  
  if(i==nVert||j==nVert)  
   System.out.println("Vertex not found");  
  else  
  {  
   adjMat[j][i]=1;  
   adjMat[i][j]=1;  
  }  
 }  
 public void displayVertex(int v)  
 {  
  System.out.print(vertexList[v].label);  
 }  
 public void dfs()  
 {  
  vertexList[0].wasVisited=true;  
  displayVertex(0);  
  theStack.push(0);  
  while(!theStack.isEmpty())  
  {  
   int v=getAdjUnvisitedVertex(theStack.peek());  
   if(v==-1)  
    theStack.pop();  
   else  
   {  
    vertexList[v].wasVisited=true;  
    displayVertex(v);  
    theStack.push(v);  
   }  
  }  
  for(int j=0;j<nVert;j++)  
   vertexList[j].wasVisited=false;  
 }  
 public void bfs()  
 {  
  vertexList[0].wasVisited=true;  
  displayVertex(0);  
  theQueue.insert(0);  
  int v2;  
  while(!theQueue.isEmpty())  
  {  
   int v1=theQueue.remove();  
   while((v2=getAdjUnvisitedVertex(v1))!=-1)  
   {  
    vertexList[v2].wasVisited=true;  
    displayVertex(v2);  
    theQueue.insert(v2);  
   }  
  }  
  for(int j=0;j<nVert;j++)  
   vertexList[j].wasVisited=false;  
 }  
 private int getAdjUnvisitedVertex(int v)  
 {  
  for(int j=0;j<nVert;j++)  
   if(adjMat[v][j]==1&&vertexList[j].wasVisited==false)  
    return j;  
   return -1;  
 }  
}  
public class GraphAppDFSBFS  
{  
 public static void main(String args[])throws IOException  
 {  
  String ch="y";  
  DataInputStream inp=new DataInputStream(System.in);  
  System.out.println("Enter the limit of vertexes");  
  int max=Integer.parseInt(inp.readLine());  
  Graph g=new Graph(max);  
  while(ch.equals("y"))  
  {  
   System.out.println("Menu");  
   System.out.println("--------");  
   System.out.println("1.Add Vertex");  
   System.out.println("2.Add Edge");  
   System.out.println("3.DFS");  
   System.out.println("4.BFS");  
   System.out.println("Enter your choice ");  
   int n=Integer.parseInt(inp.readLine());  
   switch(n)  
   {  
    case 1: while(ch.equals("y"))  
      {  
       System.out.println("Enter the vertex");  
       String s=inp.readLine();  
       char a=s.charAt(0);  
       g.addVertex(a);  
       System.out.print("Enter y to continue inserting");  
       ch=inp.readLine();  
      }  
      break;  
    case 2:  while(ch.equals("y"))  
      {  
       System.out.println("Enter the edge");  
       String s=inp.readLine();  
       g.addEdge(s.charAt(0),s.charAt(1));  
       System.out.print("Enter y to continue inserting");  
       ch=inp.readLine();  
      }  
      break;  
    case 3:System.out.println("DFS");  
      System.out.println("-------------");  
      g.dfs();  
      System.out.println("");  
      break;  
    case 4: System.out.println("BFS");  
      System.out.println("-------------");  
      g.bfs();  
      System.out.println("");  
      break;  
    default:System.out.println("Invalid Choice");  
   }  
   System.out.println("");  
   System.out.print("Enter y to continue ");  
   ch=inp.readLine();  
  }  
 }  
}  