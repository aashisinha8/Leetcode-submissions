class Solution {
    public int countValidWords(String sentence) {

        int count = 0;

        String[] words = sentence.split(" ");

        for (String word : words) {

            if (word.length() == 0) {
                continue;
            }

            boolean valid = true;
            int hyphen = 0;
            int punctuation = 0;

            for (int i = 0; i < word.length(); i++) {

                char ch = word.charAt(i);

                // digit
                if (Character.isDigit(ch)) {
                    valid = false;
                    break;
                }

                // hyphen
                if (ch == '-') {
                    hyphen++;

                    if (hyphen > 1 ||
                        i == 0 ||
                        i == word.length() - 1 ||
                        !Character.isLetter(word.charAt(i - 1)) ||
                        !Character.isLetter(word.charAt(i + 1))) {

                        valid = false;
                        break;
                    }
                }

                // punctuation
                if (ch == '!' || ch == '.' || ch == ',') {
                    punctuation++;

                    if (punctuation > 1 || i != word.length() - 1) {
                        valid = false;
                        break;
                    }
                }
            }

            if (valid) {
                count++;
            }
        }

        return count;
    }
}