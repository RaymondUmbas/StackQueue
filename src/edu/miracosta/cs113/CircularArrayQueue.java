package edu.miracosta.cs113;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CircularArrayQueue <E> extends AbstractQueue<E> implements Queue<E>{
	int front, rear, size, capacity;
	E[] array;
	
	public CircularArrayQueue() {this(10);}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int capacity)
	{
		this.capacity = capacity;
		array = (E[]) new Object[capacity];
		front = 0;
		rear = capacity - 1;
		size = 0;	
	}
	
	
	@Override
	public E element()
	{	
		if(size == 0)
			throw new NoSuchElementException();
		return array[front];
	}
	
	@Override
	public E peek() 
	{
		if(size == 0)
			return null;
		
		else
			return array[front];
	}
	
	@Override
	public E poll() 
	{
		if(size == 0)
			return null;

		E value = array[front];
		front = (front + 1) % capacity;
		size--;
		return value;
	}


	@Override
	public int size() {
		return size;
	}


	public boolean addFirst(E e) {
		if(size == capacity)
			reallocate();
		
		size++;
		front = (front - 1 + capacity) % capacity;
		array[front] = e;
		return true;
	}


	@Override
	public boolean offer(E e)
	{
		if(size == capacity) {
			reallocate();
		}
		
		size++;
		rear = (rear + 1) % capacity;
		array[rear] = e;
		return true;
	}


	@Override
	public E remove() {
		
		if(size == 0)
			throw new NoSuchElementException();
		
		E value = array[front];
		front = (front + 1) % capacity;
		size--;
		return value;
	}
	
	 @SuppressWarnings("unchecked")
	    private void reallocate() {
	        int newCapacity = 2 * capacity;
	        E[] newArray = (E[]) new Object[newCapacity];
	        int j = front;
	        
	        System.arraycopy(array, front, newArray, 0, capacity - front);
	        System.arraycopy(array, 0, newArray, capacity-front,front);
	        
	        front = 0;
	        rear = size - 1;
	        capacity = newCapacity;
	        array = newArray;
	    }
	
	 	@Override
		public Iterator<E> iterator() {return new Iter();}
	 
	 private class Iter implements Iterator<E>{
		 private int index;
		 private int count = 0;
		 public Iter() {
			 index = front;
		 }
		 
		 @Override
		 public boolean hasNext() {
			 return count < size;
		 }
		 
		 @Override
		 public E next() {
			 if (!hasNext()) {
	                throw new NoSuchElementException();
	            }
	            E returnValue = array[index];
	            index = (index + 1) % capacity;
	            count++;
	            return returnValue;
		 }
		 
		 @Override
	        public void remove() {
	            throw new UnsupportedOperationException();
	        }
		 
	 }
	 //Not Implemented Methods
		@Override
		public boolean isEmpty() {return false;}
		@Override
		public boolean contains(Object o) {return false;}
		
		@Override
		public Object[] toArray() {return null;}
		@Override
		public Object[] toArray(Object[] a) {return null;}
		@Override
		public boolean remove(Object o) {return false;}
		@Override
		public boolean containsAll(Collection c) {return false;}
		@Override
		public boolean addAll(Collection c) {return false;}
		@Override
		public boolean removeAll(Collection c) {return false;}
		@Override
		public boolean retainAll(Collection c) {return false;}
		@Override
		public void clear() {}
	
}
