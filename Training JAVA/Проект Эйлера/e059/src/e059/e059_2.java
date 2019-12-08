package e059;

public class e059_2 {
	private static String[] s;
	private static String[] p;
	private static String line;
	private static boolean find;
	public e059_2(String s, String[] p) {
		this.s = s.split(",");
		this.p = p;
		find=false;
	}

	public void Job(int j, int j1, int j2) {
		FindLine(j, j1, j2);	
		Chek();
	}

	private void Chek() {
	for(int i=0;i<p.length;i++)
		if(!Have(p[i]))
			return;
	find=true;
	System.out.println(line);
	}

	private boolean Have(String p2) {
		String ss[]=line.split("\\ ",-1);
		for(int i=0;i<ss.length;i++) {
			if(p2.equals(ss[i]))
				return true;
		}
		return false;
	}

	private void FindLine(int j, int j1, int j2) {
		line = "";
		for (int i = 0; i < s.length; i++) {
			if (i % 3 == 0)
				line +=Find( Integer.parseInt(s[i]),j );				
			else if (i % 3 == 1)
				line +=Find( Integer.parseInt(s[i]),j1 );
			else
				line +=Find( Integer.parseInt(s[i]),j2 );
		}
	}

	private String Find(int n,  int j) {
		int z=n^j;
		String x=""+(char)z;
		return x;
	}

	public boolean getFind() {
		return find;
	}

	public int FindAns() {
		int an=0;
		for(int i=0;i<line.length();i++) {
			an+=line.charAt(i);
		}
		return an;
	}
}
