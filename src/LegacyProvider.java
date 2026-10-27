public final class LegacyProvider implements Provider {
        private final WireSource source;
        public LegacyProvider(WireSource source) {
        
            if (source==null) throw new IllegalArgumentException("source required");
            this.source=source;
        }
        public Decision next() {
            // TODO: exactly two fields, preserve empty fields when splitting, validate Decision.
            String wire=source.read();
            if (wire == null || wire.isBlank()) {
                throw new IllegalArgumentException("wire cannot be blank or null");
            }

            String[] parts = wire.split("\\|", -1);

            if (parts.length != 2) {
                throw new IllegalArgumentException("Wire doesn't have 2 parts, it got" + parts.length + "wire length.");
            }

            Decision legdecision = new Decision(parts[0], parts[1]);
            return legdecision;
        }
    }