# Lab 03: Replaceable model providers

Session: 2026-10-07. Read the matching Student Brief before editing.

This is optional individual practice and is not graded. Attendance and uploading work
are optional. You may work independently and choose whether and when to upload work
for feedback. There is no submission deadline or penalty for not attending or uploading.
TA support is available during your registered lab session and is encouraged where useful.

You may use your own laptop, or a lab computer where available. Use JDK 21 and the
supplied starter. Ask the TA if you need help with setup.
This is an exercise starter. A clean compile does not mean the exercise is solved.
The public checks are expected to fail initially. Preserve them and add your own tests.
All data is synthetic. No personal paid AI account or model service is needed for the labs.

## First run

Extract the whole ZIP. Open its starter folder, containing this README and src/Main.java.
Use JDK 21. Check java -version and javac -version.

macOS/Linux (or Git Bash on Windows):

    bash run.sh compile
    bash run.sh run
    bash run.sh check
    bash setup-junit.sh
    bash run.sh test

Windows PowerShell:

    ./run.ps1 compile
    ./run.ps1 run
    ./run.ps1 check
    ./setup-junit.ps1
    ./run.ps1 test

If local policy blocks PowerShell scripts, use Git Bash or the lab-supported setup;
do not weaken institution-managed security policies. COURSE_JAVA_HOME may point to
a supported JDK folder. JAVA_HOME is also respected. Scripts always target Java 21.

setup-junit downloads the pinned JUnit 6.0.3 console jar from Maven Central and checks its
SHA-256. The TA can cache it once and provide JUNIT_JAR as an absolute path instead.
Compilation and plain Java checks work offline without JUnit. A missing dependency
is an environment issue; report it separately from failed behavioural checks.

## Your work

Complete Decision validation, Factory.create, and legacy wire conversion. Modes are exactly replay and legacy. Decision accepts only READ_BOOKING or FINISH with booking B1. Legacy wire syntax contains exactly two nonempty fields separated by one vertical bar. Unknown modes and malformed fields use IllegalArgumentException. These are scripted fixtures, not live model outputs.

## Commands and evidence

- compile: compile source with Java 21 and compiler warnings enabled.
- run: small starter orientation or deliberately faulty demonstration, not a test suite.
- check: named plain Java checks, exit 1 when a required behaviour is missing.
- test: the same supplied cases through JUnit Jupiter plus your added test classes.
- lint: compile with -Xlint:all.

Each check creates its own objects. Read the case name and assertion message; do not
delete failing cases or edit the captured output. Add focused Jupiter tests in
test/junit/StudentTests.java. An all-green public suite is not proof of every requirement.

## Optional upload for feedback

If you would like feedback through eClass, upload Lab03_STUDENTNUMBER.zip to the
Lab03 practice activity whenever you choose. Include src/, test/, README.md, AI_USE.md
and results.txt. If you include a diagram, provide a text alternative. Omit build/, lib/,
secrets and IDE caches. In README.md, identify the activities you completed, one
limitation and the exact commands used. You may also ask the TA to look at your work
during the session without uploading it. Feedback carries no marks.

The initial trace/design phase prohibits generative AI; permitted implementation assistance
must be disclosed. The supplied infrastructure is acknowledged in STARTER_PROVENANCE.md.

## References

- Java 21: https://docs.oracle.com/en/java/javase/21/
- JUnit 6.0.3 console: https://docs.junit.org/6.0.3/running-tests/console-launcher.html
