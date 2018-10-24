class ListDriver {
	public static void main(String [] args) {
	
	  System.out.println("Testing ArrayList");
		List<String> myList = new ArrayList<String>();
		myList.add("zero");
		myList.add("one");
		myList.add("two");
		myList.add("three");
		myList.add("four");
		for (int i=0; i<myList.size(); i++)
		    System.out.println(myList.get(i));
		myList.add(2, "five");
		System.out.println(myList);
		myList.remove(1);
		System.out.println(myList);
		myList.set(3, "six");
		System.out.println(myList);
		myList.remove("four");
		System.out.println(myList);

	  System.out.println("Testing LinkedList");
		List<String> yourList = new LinkedList<String>();
		yourList.add("zero");
		yourList.add("one");
		yourList.add("two");
		yourList.add("three");
		yourList.add("four");
		for (int i=0; i<yourList.size(); i++)
		    System.out.println(yourList.get(i));
		yourList.add(2, "five");
		System.out.println(yourList);
		yourList.remove(1);
		System.out.println(yourList);
		yourList.set(3, "six");
		System.out.println(yourList);
		yourList.remove("four");
		System.out.println(yourList);

	}
}