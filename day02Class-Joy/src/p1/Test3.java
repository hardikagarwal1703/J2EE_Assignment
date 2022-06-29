package p1;

import java.util.Arrays;

public class Test3 {

	public static void main(String[] args) {
		// Loads Emp.class in method area, JVM creates immutable instance for this
		// loaded class : empClass
		Class<Emp> empClass = Emp.class;
		System.out.println("\n----------\nAll accessible fields\n");
		Arrays.stream(empClass.getFields()).forEach(System.out::println);

		System.out.println("\n----------\nAll fields of Emp class\n");
		// display all fields of the specified class including private members (no
		// inherited members)
		Arrays.stream(empClass.getDeclaredFields()).forEach(System.out::println);

		// reflection info about constrs
		System.out.println("\n----------\nAll constrs\n");
		Arrays.stream(empClass.getConstructors()).forEach(System.out::println);

		// reflection info about methods
		System.out.println("\n----------\nAll Accessible n inherited Methods\n");
		Arrays.stream(empClass.getMethods()).forEach(System.out::println);

		// reflection info about private methods
		System.out.println("\n----------\nAll private n accessible  Methods  of the specfied class \n");
		Arrays.stream(empClass.getDeclaredMethods()).forEach(System.out::println);
	}
}