package datastructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class AllSubSets {

	private static void buildPowerSet(List<String> list, int count,HashSet<List<String>> powerSet)
	{
	    powerSet.add(list);

	    for(int i=0; i<list.size(); i++)
	    {
	        List<String> temp = new ArrayList<String>(list);
	        temp.remove(i);
	        buildPowerSet(temp, temp.size(),powerSet);
	    }
	}
	
	public static void main(String[] args) {
		HashSet<List<String>> powerSet = new HashSet<List<String>>();
		String L="a";
		List<String> mainList = new ArrayList<String>();
		mainList.add(L);
		mainList.add("b");
		mainList.add("c");
		buildPowerSet(mainList,mainList.size(),powerSet);
		System.out.println(powerSet);
	}
}
