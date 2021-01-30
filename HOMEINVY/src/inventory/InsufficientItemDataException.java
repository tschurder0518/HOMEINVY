package inventory;

public class InsufficientItemDataException extends Exception {
		private static final long serialVersionUID = 1L;
		private static final String MESSAGE = "MISSING ITEM INFORMATION IN TEXT FILE.\n"
												+ "Each item must have 10 commas in the file, "
												+ "your output may be missing information.";

		public InsufficientItemDataException() {
			System.out.println(MESSAGE);
		}
}
