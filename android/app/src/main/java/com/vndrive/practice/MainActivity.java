package com.vndrive.practice;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Toast;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends Activity {
    private static final int CREATE_CSV = 42;
    private String pendingCsv;
    private WebView webView;

    @Override public void onCreate(Bundle b) {
        super.onCreate(b);
        webView = new WebView(this);
        WebSettings s = webView.getSettings();
        s.setJavaScriptEnabled(true);
        s.setDomStorageEnabled(true);
        s.setAllowFileAccess(true);
        s.setAllowContentAccess(true);
        webView.addJavascriptInterface(new AndroidBridge(), "Android");
        webView.loadUrl("file:///android_asset/index.html");
        setContentView(webView);
    }

    private class AndroidBridge {
        @JavascriptInterface public void saveCsv(String filename, String csv) {
            pendingCsv = csv;
            runOnUiThread(() -> {
                Intent intent = new Intent(Intent.ACTION_CREATE_DOCUMENT);
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                intent.setType("text/csv");
                intent.putExtra(Intent.EXTRA_TITLE, filename);
                startActivityForResult(intent, CREATE_CSV);
            });
        }
    }

    @Override protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode != CREATE_CSV || resultCode != RESULT_OK || data == null || pendingCsv == null) return;
        Uri uri = data.getData();
        try (OutputStream out = getContentResolver().openOutputStream(uri)) {
            if (out == null) throw new Exception("Could not open destination");
            out.write(pendingCsv.getBytes(StandardCharsets.UTF_8));
            out.flush();
            Toast.makeText(this, "Word bank exported successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(this, "Export failed: " + e.getMessage(), Toast.LENGTH_LONG).show();
        } finally {
            pendingCsv = null;
        }
    }
}
