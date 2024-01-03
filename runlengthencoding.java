class GfG
{
	String encode(String str)
	{
		if (str == null || str.length() == 0) {
			return "";
		}

		StringBuilder encodedString = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char currentChar = str.charAt(i);
			int count = 1;
			while (i + 1 < str.length() && str.charAt(i + 1) == currentChar) {
				count++;
				i++;
			}
			encodedString.append(currentChar);
			encodedString.append(count);
		}

		return encodedString.toString();
	}
}
