package edu.nyu.cs9053.homework8;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * User: blangel
 * Date: 10/14/14
 * Time: 6:47 PM
 */
public class Sets {
	public static Set<?> resultCartesianProductOfTwoSet=null; 

    public static <T>Set<T> union(Set<T> left, Set<T> right) {
        Set<T> unionSet = new HashSet<>(left.size() + right.size());
        if(left.isEmpty() && right.isEmpty()){
            return null;
        } else{
            unionSet.addAll(left);
            unionSet.addAll(right);
            return unionSet;
        }
    }

    public static <T>Set<T> intersection(Set<T>  left, Set<T>  right) {
        Set<T> intersectionSet = new HashSet<>(left.size() + right.size());
        if(left.isEmpty() && right.isEmpty()){
            return null;
        } else{
            intersectionSet.addAll(left);
            intersectionSet.retainAll(right);
            return intersectionSet;
        }
    }

    public static <T>Set<T> symmetricDifference(Set<T>  left, Set<T>  right) {
        Set<T> symmetricDifferenceSet = new HashSet<>(left.size() + right.size());
        if(left.isEmpty() && right.isEmpty()){
            return null;
        } else{
            symmetricDifferenceSet.addAll(union(left, right));
            symmetricDifferenceSet.removeAll(intersection(left,right));
            return symmetricDifferenceSet;
        }
    }

    public static <S>List<Set<S>> cartesianProduct(List<Set<S>> sets) {
    	Set<Set<S>> setOfSetsInList = new HashSet<Set<S>>();
    	for(Set<S> individualElement : sets ){
    		setOfSetsInList.add(individualElement);
    	}
    	LinkedList<Set<S>> linkedLst=new LinkedList<>();
    	Set<Set<S>> abc=cartesianProductImplement(setOfSetsInList);
    	linkedLst.addAll(abc);    
    	return linkedLst;
    }
    
    
    public static <S> Set<Set<S>> cartesianProductImplement(Set<S>... sets) {
        if (sets.length < 2) throw new IllegalArgumentException();
        return _cartesianProduct(0, sets);
    }

    private static <S> Set<Set<S>> _cartesianProduct(int index, Set<S>... sets) {
        Set<Set<S>> ret = new HashSet<Set<S>>();
        if (index == sets.length) {
            ret.add(new HashSet<S>());
        } else {
            for (S obj : sets[index]) {
                for (Set<S> set : _cartesianProduct(index+1, sets)) {
                    set.add(obj);
                    ret.add(set);
                }
            }
        }
        return ret;
    }
}
