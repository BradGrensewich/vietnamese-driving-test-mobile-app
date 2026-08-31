# Build the APK without Android Studio

This project includes a GitHub Actions workflow that builds the APK on GitHub's servers.

1. Create a new GitHub repository.
2. Upload the contents of this folder to the repository.
3. Open the repository's **Actions** tab.
4. Select **Build Android APK**.
5. Click **Run workflow** (or push to `main`).
6. When it finishes, open the workflow run and download the artifact named **Vietnamese-Driving-Practice-APK**.
7. Extract the ZIP and install `app-debug.apk` on the Android 12 phone.

No Android Studio is required on your computer.
