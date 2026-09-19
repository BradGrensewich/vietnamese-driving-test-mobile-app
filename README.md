# Vietnamese Driving Practice

Offline Vietnamese driving-theory vocabulary and question practice app.

## Bulk-add vocabulary from clipboard

Open **Word & Phrase Banks** from the home screen. Under **Paste vocabulary in bulk**, paste CSV text containing two fields per line:

```text
"Câu ...","Question ..."
"... nào dưới đây?","which ... below?"
"Biển nào báo hiệu ...?","Which sign indicates ...?"
```

Press **Add all to Word Bank**. Every valid pair is appended to the custom Word Bank and saved immediately in the app's local storage. Existing custom words are not replaced.

The parser supports quoted CSV fields, commas inside fields, doubled quotes, and Windows/Unix line endings. A header such as `Vietnamese,English` is also accepted and skipped.

## Android build

The Android wrapper is under `android/`. GitHub Actions can build the debug APK. The workflow uses `android-actions/setup-android@v4` with default package installation disabled, avoiding the obsolete `tools` SDK package.
