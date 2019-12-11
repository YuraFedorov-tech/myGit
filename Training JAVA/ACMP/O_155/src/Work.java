
public class Work {

	public static int[] Find_new_previosIf0(int i, boolean[] may, int[] new_previos) {
		switch (i) {
		case 0:
		case 1:
		case 2:
			return new_previos;
		case 3:
			new_previos[0] = 3;
			return new_previos;
		case 4:
			new_previos[0] = 4;
			return new_previos;
		case 5:
		case 6:may[0]=false;
		return new_previos;
		}

		return null;
	}

	public static int[] Find_new_previosIf3(int i, boolean[] may,
			int[] new_previos) {
		switch (i) {
		case 0:
		case 1:new_previos[0]=31;
		case 2:new_previos[0]=31;
			return new_previos;
		case 3:		
		case 4:			
		case 5:
		case 6:may[0]=false;
		return new_previos;
		}
		
		
		
		
		return null;
	}

	public static int[] Find_new_previosIf4(int i, boolean[] may,
			int[] new_previos) {

		switch (i) {
		case 0:
		case 1:new_previos[0]=41;
		case 2:new_previos[0]=41;
			return new_previos;
		case 3:		
		case 4:			
		case 5:
		case 6:may[0]=false;
		return new_previos;
		}
		
		
		
		return null;
	}

	public static int[] Find_new_previosIf31(int i, boolean[] may,
			int[] new_previos) {

		switch (i) {
		case 0:
		case 1:
		case 2:
			return new_previos;
		case 3:		
		case 4:	may[0]=false;
		        return new_previos;
		case 5:new_previos[0]=0;
		return new_previos;
		case 6:may[0]=false;
		return new_previos;
		}
		
		return null;
	}

	public static int[] Find_new_previosIf41(int i, boolean[] may,
			int[] new_previos) {
		switch (i) {
		case 0:
		case 1:
		case 2:
			return new_previos;
		case 3:		
		case 4:	
		case 5:may[0]=false;
               return new_previos;
		case 6:new_previos[0]=0;
		return new_previos;
		}

		
		return null;
	}

	public static double _Find_r(int[] is, int[] currensy,
			double[] kondensator, double answear, double answearMax, int numberOperacii) {


		
		
		return 0;
	}



}
