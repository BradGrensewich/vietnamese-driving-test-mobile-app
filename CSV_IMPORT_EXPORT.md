# CSV import/export

The app now has **Export Word Bank (.csv)** and **Import CSV (replace everything)** in Word & Phrase Banks.

## CSV format

```csv
Bank,Vietnamese,English
Word,nhường đường,to give way
Phrase,để bảo đảm an toàn,to ensure safety
```

- Export includes all custom Words and Phrases currently stored on the device.
- Import replaces both custom banks completely.
- Built-in vocabulary/phrases are not deleted by import; only the custom banks are replaced.
- The app keeps the existing `vn-driving-practice-v3` storage key, so the code does not intentionally clear existing data.
- On Android, Export opens the normal Android **Save** dialog so you can choose where to save the CSV.
- On desktop/browser, Export downloads the CSV normally.
