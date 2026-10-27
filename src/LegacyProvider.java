public final class LegacyProvider implements Provider {
        private final WireSource source;
        public LegacyProvider(WireSource source) {
            if (source==null) throw new IllegalArgumentException("source required");
            this.source=source;
        }
        public Decision next() {
            String wire=source.read();
            // TODO: exactly two fields, preserve empty fields when splitting, validate Decision.
            throw new UnsupportedOperationException("TODO convert legacy wire: " + wire);
        }
    }