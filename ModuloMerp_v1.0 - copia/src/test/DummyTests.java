package test;

public class DummyTests {

	public static void main(String[] args) {
		String [] array;
		int[] array2 = {1,2};
		String cadena = "Gabriel";
		array = cadena.split(",");
		
		//System.out.println(array[0] + " "+array[1]);
		array[0] = (array2[0] + "");
		System.out.println(array[0]);

	}

}
