package edu.miracosta.cs113;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack <E> implements StackInterface<E>{
	
	ArrayList<E> arrayList;
	//Constructor
	public ArrayListStack() {arrayList = new ArrayList<E>();}
	
	/*
     * Returns true if the stack is empty; otherwise, returns false
     *
     * @return true if empty, false otherwise
     */
    public boolean empty()
    {
    	if(arrayList.isEmpty())
    		return true;
    	else
    		return false;
    	
    }

    /**
     * Returns the object at the top of the stack without removing it
     *
     * @return reference (shallow copy) of object at top of stack
     */
    public E peek()
    {
    	if(this.empty())
    		throw new EmptyStackException();
    	else
    		return arrayList.get(arrayList.size()-1);
    }

    /**
     * Returns the object at the top of the stack and removes it
     *
     * @return reference of removed object from top of stack
     */
    public E pop()
    {
    	if(this.empty())
    		throw new EmptyStackException();
    	else {
    		E value = arrayList.get(arrayList.size()-1);
    		arrayList.remove(arrayList.size()-1);
    		return value;
    	}
    }

    /**
     * Pushes an item onto the top of the stack and returns the item pushed.
     *
     * @param obj object to push onto top of stack
     * @return item that was pushed
     */
   
 
	public E push(E obj) {
		arrayList.add(obj);
    	return obj;
	}  
}

