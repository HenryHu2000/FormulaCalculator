package org.chinaarchitect.testproject.pattern;

import java.util.HashSet;

public class Pattern<T> {
	private T[] pattern;

	public Pattern(T[] pattern) {
		setPattern(pattern);
	}

	public T[] getPattern() {
		return pattern;
	}

	public void setPattern(T[] pattern) {
		this.pattern = pattern;
	}

	@Override
	public String toString() {
		String output = "";
		for (T element : pattern) {
			if (output == "")
				output = element.toString();
			else
				output += "\n" + element.toString();
		}
		return output;
	}

	public String toString(String separator) {
		String output = "";
		for (T element : pattern) {
			if (output == "")
				output = element.toString();
			else
				output += separator + element.toString();
		}
		return output;
	}

	public HashSet<T[]> Iterate() {
		// TODO finish this part
		HashSet<T[]> patterns = new HashSet<T[]>();
		int[] loop = new int[pattern.length];
		// Make all elements in array time equal to pattern's length
		if (loop != null) {

			for (int i = 0; i < loop.length; i++) {

				loop[i] = pattern.length;

			}

		}
		Circulation cir = new Circulation(loop);
		cir.circulate(new Code() {
			public void body(int[] time) {
				T[] pat = pattern.clone(); // Create an array with the same
											// length of pattern
				// TODO Fix bug of empty set
				boolean repeat = false;
				Loop: for (int i = 0; i < time.length; i++) {
					for (int j = i + 1; j < time.length; j++) {
						if (time[i] == time[j]) {
							repeat = true;
							break Loop;
						}
					}
				}
				if (!repeat) {
					if (pat != null) {
						// Give the pattern a new order
						for (int i = 0; i < pat.length; i++) {

							pat[i] = pattern[time[i]];

						}
						patterns.add(pat);
					}
				}

			}
		});

		return patterns;
	}

}