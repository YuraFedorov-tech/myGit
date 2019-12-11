import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class O_393 {
	public static void main(String[] args) throws IOException {

		BufferedReader M = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(M.readLine().trim());
		String nameSong[] = new String[n];
		int lineOf_song[] = new int[n];
		for (int i = 0; i < n; i++) {
			String[] s = M.readLine().trim().split(" ");
			nameSong[i] = s[0].trim();
			lineOf_song[i] = Integer.parseInt(s[1]);

		}
		String[] s = M.readLine().trim().split(" ");
		int m = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		int[] qwuee = new int[m];
		for (int i = 0; i < m; i++)
			qwuee[i] = FindSong(nameSong, M.readLine().trim(), n);
		int switching[] = new int[k];
		if (k != 0)			
		s = M.readLine().trim().split(" ");
		for (int i = 0; i < k; i++) {
			switching[i] = Integer.parseInt(s[i]);
			if (i != 0){
				switching[i] -= switching[i - 1];
}
			
		}
	B(n, lineOf_song, m, k, qwuee, switching);
		
	}

	private static void B(int n, int[] lineOf_song, int m, int k, int[] qwuee,
			int[] switching) {
		int[] reiting = new int[n];
		if (m != 0) {
			int time = 0;
			if (k != 0)
				time = switching[0];
			int tOfTime = 0;
			int next = 0;
			if (k == 0)
				time = -1;
			ArrayList<Integer> list = new ArrayList<Integer>();
			list.add(switching[0]);
			for (int i = 1; i < k; i++) {
				if (switching[i] != 0)
					list.add(switching[i]);
			}
			k = list.size();
			switching = new int[k];
			for (int i = 1; i < k; i++)
				switching[i] = list.get(i);

			for (int i = 0; i < m; i++) {
				int numberOfSong = qwuee[i];
				if (next == 1) {
					next = 0;
					reiting[numberOfSong]--;
					continue;
				}
				int timeOsSong = lineOf_song[numberOfSong];
				if (time == -1 | time > timeOsSong) {
					if (time != -1)
						time -= timeOsSong;
					reiting[numberOfSong]++;
					continue;
				}
				if (time < timeOsSong) {
					reiting[numberOfSong]--;
					tOfTime++;
					if (tOfTime == k) {
						time = -1;
					} else {
						time = switching[tOfTime];
					}
					continue;
				}
				if (time == timeOsSong) {
					reiting[numberOfSong]++;
					next = 1;
					tOfTime++;
					if (tOfTime == k) {
						time = -1;
					} else {
						time = switching[tOfTime];
					}
					continue;
				}
			}
		}
		for (int i = 0; i < n; i++)
			System.out.print(reiting[i] + " ");
	}

	private static int FindSong(String[] nameSong, String trim, int n) {
		for (int i = 0; i < n; i++)
			if (nameSong[i].equals(trim))
				return i;
		return -1;
	}
}
