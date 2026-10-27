public final class ReplayProvider implements Provider{
    public Decision next() {
        return new Decision("READ_BOOKING", "B1");    
    }
    
}
