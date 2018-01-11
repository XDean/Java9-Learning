package xdean.java9.lang;
import java.util.ArrayList;
import java.util.List;

public class TestSafeVarOnInstanceMethod {
	@SafeVarargs
  private int getLen(List<String>...list) {
		List<String>[] l = list;
		return l.length;
	}

	public static void main(String[] args) {
		TestSafeVarOnInstanceMethod x = new TestSafeVarOnInstanceMethod();
		List<String> l = new ArrayList<>();
		int len = x.getLen(l); // Use Quick Assist of SafeVarargs here<br>
		System.out.println("Length:" + len);
	}
}