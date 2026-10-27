

public final class Factory {
        private Factory() {}
        public static Provider create(String mode) {
            // TODO: select a new provider per call; reject null and unknown modes.
            if (mode == null || mode.isBlank()){
                throw new IllegalArgumentException("mode cannot be blank or null");
            }

            if (mode.equals("replay")){
                ReplayProvider provider = new ReplayProvider();
                return provider;
            }
            
            else if (mode.equals("legacy")) {
                LegacyProvider leg = new LegacyProvider(() -> "READ_BOOKING|B1");                
                return leg;
            }
            else {
                throw new IllegalArgumentException("mode must be legacy or replay");
            }
            
        }
    }