package edu.nyu.cs9053.homework8;

import java.util.Collection;
import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;

public class ArrayListHashMap<K,V> extends MultimapAbstractClass<K,V> {

	public ArrayListHashMap(HashMap<K, Collection<V>> hashMapObj) {
		super(hashMapObj);
	}

	@Override protected Collection<V> getNewList() {
		return new ArrayList<>();
	}

	@Override protected List<V> combineList(List<V> list1, List<V> list2) {
		ArrayList<V> tempList1 = new ArrayList<>(list1);
		ArrayList<V> tempList2 = new ArrayList<>(list2);
		tempList1.addAll(tempList2);
		return tempList1;
	}

}
