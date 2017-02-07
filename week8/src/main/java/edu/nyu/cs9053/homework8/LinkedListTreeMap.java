package edu.nyu.cs9053.homework8;
import java.util.LinkedList;
import java.util.List;
import java.util.Collection;
import java.util.TreeMap;

public class LinkedListTreeMap<K, V> extends MultimapAbstractClass<K, V> {

	public LinkedListTreeMap(TreeMap<K,Collection<V>> treeMapObj) {
		super(treeMapObj);
	}


	@Override protected Collection<V> getNewList() {
		return new LinkedList<>();
	}

	
	@Override protected List<V> combineList(List<V> list1, List<V> list2) {
		LinkedList<V> tempList1 = new LinkedList<>(list1);
		LinkedList<V> tempList2 = new LinkedList<>(list2);
		tempList1.addAll(tempList2);
		return tempList1;
	}
}
