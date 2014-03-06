package skip;

public class ListTest {

	public static void main(String[] args) {
		SkipListOfStrings list = new SkipListOfStrings();
		list.add("abc");
		list.add("huakjsd");
		String str = "a";
		for (int i = 0; i < 30; i++) {
			list.add(str);
			list.add(str + "b");
			str += "a";
		} // for
		System.out.println(list.contains("huakjsd"));
		list.remove("huakjsd");
		System.out.println(list.contains("huakjsd"));
		System.out.println(list.contains("aaaaaaaaaaab"));
		list.remove("aaaaaaaaaaab");
		System.out.println(list.contains("aaaaaaaaaaab"));
		System.out.println(list.highest);
		System.out.println(list);
//		StringNode[] ls = new StringNode[3];
//		System.out.println(Arrays.toString(ls));
	} // main (String[])

} // class ListTest
