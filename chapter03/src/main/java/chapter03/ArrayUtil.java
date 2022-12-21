package chapter03;

public class ArrayUtil {

	public static double[] intToDouble(int[] is) {
		double[] result = new double[is.length]; //-> 초기화 시켜줘야함 아니면 워닝뜸
		
		// error: double d = result + 10;
		
		for(int i = 0; i < result.length; i++) {
			result[i] = is[i] ;
		}
		return result;
	}

	public static int[] doubleToInt(double[] ds) {
		int[] da = new int[ds.length];
		for(int i = 0; i < da.length; i++) {
			ds[i] = da[i];
		}
		return da;
	}

	public static int[] concat(int[] is, int[] is2) {
		int[] a = new int[is.length+is2.length];
		int index = 0;
		
		for(int i = 0; i<is.length; i++) {
			a[index++]=is[i];
		}
		for(int i = 0; i<is2.length; i++) {
			a[index++]=is2[i];
		}
		
		return a;
	}

}
