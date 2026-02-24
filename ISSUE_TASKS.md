# Issue-based task proposals

## 1) Fix a typo
**Task:** Rewrite the README headings and setup text to use proper capitalization and grammar (e.g., `# installation` -> `# Installation`, `## in pc` -> `## On a PC`, `use android studio` -> `Use Android Studio`).

**Why this matters:** The current onboarding text contains multiple visible typos/grammar issues that reduce readability and credibility for new contributors.

**Acceptance criteria:**
- README headings use title case.
- Setup instructions use complete, grammatical sentences.
- Terminology is normalized (`PC`, `Android Studio`, `Gradle`).

## 2) Fix a bug
**Task:** Move the CMake build script to the path Gradle expects (`app/src/main/cpp/CMakeLists.txt`) or update `externalNativeBuild.cmake.path` to the real location.

**Why this matters:** Gradle is configured to load `src/main/cpp/CMakeLists.txt`, but the repository currently stores the file at `src/main/cpp/CMakeLists.txt/CMakeLists.txt`, which can break native configuration/build.

**Acceptance criteria:**
- `./gradlew :app:tasks` (or equivalent native config phase) can resolve the CMake script path.
- Native module configuration no longer fails due to missing `CMakeLists.txt`.

## 3) Fix a code comment / documentation discrepancy
**Task:** Align documentation with actual runtime behavior: either update README to state the app starts an embedded Node HTTP server on `127.0.0.1:3000`, or change implementation/docs so they consistently describe the same architecture.

**Why this matters:** README says this is a "Node.js mobile and Termux dashboard for running Discord bots", while app code actually spins up an inline HTTP server and calls it from the UI.

**Acceptance criteria:**
- README accurately describes what `MainActivity` does at startup.
- Any references to Termux/Discord bot management are either implemented or removed from top-level docs.

## 4) Improve a test
**Task:** Add an Android test that validates the Node call flow and user-visible output update.

**Suggested approach:**
- Refactor networking into a small injectable helper (or use an idling resource).
- Add an instrumentation test that clicks `button_call_node` and asserts `text_output` changes from `Waiting...` to either server text (`Hello from Node on Android!`) or a controlled error state.

**Why this matters:** There are currently no tests in the project, so regressions in the core UI/server interaction would go unnoticed.

**Acceptance criteria:**
- At least one automated test exists for the button->request->TextView flow.
- Test is runnable in CI/emulator and deterministic.
