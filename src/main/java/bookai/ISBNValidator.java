package bookai;

public class ISBNValidator {
    
    public boolean isValidISBN10(String isbn) {
	    if (isbn == null || isbn.length() != 10) {
	        return false;
	    }
	    try {
	        int sum = 0;
	        for (int i = 0; i < 9; i++) {
	            int digit = Integer.parseInt(isbn.substring(i, i + 1));
	            sum += (digit * (i + 1));
	        }
	        String checksum = isbn.substring(9);
	        if ("X".equals(checksum)) {
	            sum += 10 * 10;
	        } else {
	            sum += Integer.parseInt(checksum) * 10;
	        }
	        return (sum % 11 == 0);
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}

	public boolean isValidISBN13(String isbn) {
	    if (isbn == null || isbn.length() != 13) {
	        return false;
	    }
	    try {
	        int sum = 0;
	        for (int i = 0; i < 12; i++) {
	            int digit = Integer.parseInt(isbn.substring(i, i + 1));
	            sum += (i % 2 == 0) ? digit : digit * 3;
	        }
	        int checksum = 10 - (sum % 10);
	        if (checksum == 10) {
	            checksum = 0;
	        }
	        return checksum == Integer.parseInt(isbn.substring(12));
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
}
