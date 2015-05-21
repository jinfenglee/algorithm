package com.jinfenglee.stackqueue;

/**
 * 
 * @description:腾讯微信 2013实习生 面试一道题：
 * 原题：实现一个栈，满足min()  pop()  push()方法的时间复杂度都为O(1).( min()返回栈中最小元素 )
 * 
 * 思路1：用一个变量minItem记录栈中的最小值，在push()中 每次加入一个item就跟minItem对比，
 * item更小，把item赋给minItem，然后在 min() 中直接return  minItem;   
 * 这种思路没考虑在pop()过程中，对minItem的影响，当栈顶元素是minItem，执行pop() 后minItem就不知道指向谁了,
 * 因为栈只记录最小值而起，至于最小值之前那些大小关系都没记录。
 * 
 * 比较好的思路就是：
 * 使用空间换时间，使用一个array,  nextMinItem[index]来记录元素大小关系，如果当前最小值对象为 item1，再进来的item2比item1小，
 * 元素个数从a增加到 a+1，  我们就应该把 minItem=item2,    使用 nextMinItem[a+1] = item1来记录item2后面的次小值，这样当item2这个
 * 栈顶被pop()的话，我们可以通过minItem = nextMinItem[n+1];
 * 进行恢复minItem.
 * 
 */
public class StackDemo {
	private int itemCount = 0;
	/* 记录栈中的最小值 */
	private Item minItem = null; 
	private Item[] nextMinItem;
	/* 栈顶元素 */
	private Item stackTop = null;
	private int maxSize = 100;
	
	public StackDemo() {
		nextMinItem = new Item[maxSize];
	}
	
	class Item {
		int data;
		Item nextItem;

		public Item(int data) {
			this.data = data;
		}
	}
	/**
	 *  nextMinItem[1]=5; ....  nextMinItem[4]=2;  
	 * @param item
	 * @return
	 */
	public boolean push(Item item) {
		if(itemCount == maxSize){
			System.out.println("栈已满！");
			return false;
		}
		itemCount++;
		
		// 栈中没有最小值
		if(minItem == null) {
			minItem = item;
		} else {
			if(item.data < minItem.data) {
				nextMinItem[itemCount] = minItem;
				minItem = item;
			}
		}
		item.nextItem = stackTop;
		stackTop = item;
		return true;
	}
	
	public boolean pop() {
		if(itemCount == 0) {
			System.out.println("栈为空，不能出栈！");
			return false;
		}
		if(stackTop == minItem) {
			minItem = nextMinItem[itemCount];
		}
		stackTop = stackTop.nextItem;
		itemCount--;
		return true;
	}
	public Item min() {
		if(itemCount == 0){
			System.out.println("栈为空，无最小值！"); 
			return null;
		}
		return minItem;
	}
	
	public static void main(String[] args) {
		StackDemo stack = new StackDemo();
        stack.push(stack.new Item(5));
        System.out.println("push:min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.push(stack.new Item(4));
        System.out.println("push:min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.push(stack.new Item(3));
        System.out.println("push:min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.push(stack.new Item(2));
        System.out.println("push:min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.push(stack.new Item(1));
        System.out.println("push:min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.pop();
        System.out.println("pop :min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.pop();
        System.out.println("pop :min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.pop();
        System.out.println("pop :min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.pop();
        System.out.println("pop :min=" + stack.min().data+" itemCount="+stack.itemCount);
        stack.pop();
        System.out.println("栈的结构为：\n|____1_____|\n|____2_____|\n|____3_____|\n|____4_____|\n|____5_____|\n");
	}
}
/**
push:min=5 itemCount=1
push:min=4 itemCount=2
push:min=3 itemCount=3
push:min=2 itemCount=4
push:min=1 itemCount=5
pop :min=2 itemCount=4
pop :min=3 itemCount=3
pop :min=4 itemCount=2
pop :min=5 itemCount=1
栈结构为：
|____1_____|
|____2_____|
|____3_____|
|____4_____|
|____5_____|
  */
