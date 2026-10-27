import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Public examples of required behaviour. Add independent tests of your own. */
public final class PublicChecks {
    @FunctionalInterface public interface Action { void run() throws Exception; }
    public record Case(String name, Action action) {}
    public static void equal(Object expected, Object actual) {
        if (!Objects.equals(expected, actual)) throw new AssertionError("Expected " + expected + "; got " + actual);
    }
    public static void require(boolean condition, String message) { if (!condition) throw new AssertionError(message); }
    public static void rejects(Class<? extends Throwable> type, Action action) throws Exception {
        try { action.run(); } catch (Throwable ex) {
            if (type.isInstance(ex)) return;
            throw new AssertionError("Expected " + type.getSimpleName() + "; got " + ex, ex);
        }
        throw new AssertionError("Expected " + type.getSimpleName() + "; operation returned normally");
    }
    public static List<Case> cases() {
        List<Case> cases = new ArrayList<>();

for (String mode : new String[]{"replay","legacy"}) cases.add(new Case(mode+" decision", () -> { Provider p=Factory.create(mode); Decision d=p.next(); equal("READ_BOOKING",d.tool()); equal("B1",d.bookingId()); require(p!=Factory.create(mode),"factory reused an instance"); }));
cases.add(new Case("unknown mode", () -> rejects(IllegalArgumentException.class, () -> Factory.create("unknown"))));
cases.add(new Case("null mode", () -> rejects(IllegalArgumentException.class, () -> Factory.create(null))));
for (String wire : new String[]{"READ_BOOKING","READ_BOOKING|B1|EXTRA","READ_BOOKING|","|B1","EXECUTE|B1","READ_BOOKING|B2"}) cases.add(new Case("reject wire "+wire, () -> rejects(IllegalArgumentException.class, () -> new LegacyProvider(() -> wire).next())));
cases.add(new Case("null wire", () -> rejects(IllegalArgumentException.class, () -> new LegacyProvider(() -> null).next())));
cases.add(new Case("invalid Decision", () -> rejects(IllegalArgumentException.class, () -> new Decision("EXECUTE","B1"))));
cases.add(new Case("FINISH decision", () -> equal("FINISH",new Decision("FINISH","B1").tool())));

        return cases;
    }
    public static void main(String[] args) {
        int failed = 0;
        for (Case c : cases()) {
            try { c.action().run(); System.out.println("PASS " + c.name()); }
            catch (Throwable ex) { failed++; System.out.println("FAIL " + c.name() + ": " + ex); }
        }
        System.out.println("CHECKS " + cases().size() + "; FAILED " + failed);
        if (failed != 0) System.exit(1);
    }
}
