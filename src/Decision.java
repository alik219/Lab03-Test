public final class Decision {
        private final String tool;
        private final String bookingId;
        public Decision(String tool, String bookingId) {
            // TODO: validate allowed tool values and fixture booking ID B1.
            if (tool == null || tool.isBlank()){
                throw new IllegalArgumentException("tool cannot be blank or null");
            }
            if (bookingId == null || bookingId.isBlank()) {
                throw new IllegalArgumentException("bookid cannot be blank or null");
            }

            if (!tool.equals("READ_BOOKING") && !tool.equals("FINISH")) {
                throw new IllegalArgumentException("unknown tool: " + tool);
            }
            if (!bookingId.equals("B1")) {
                throw new IllegalArgumentException("Unknown BookingID: " + bookingId);
            }
            
            this.tool=tool;
            this.bookingId=bookingId;
        }
        public String tool() { return tool; }
        public String bookingId() { return bookingId; }
    }