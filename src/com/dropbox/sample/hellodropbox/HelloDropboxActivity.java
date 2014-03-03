package com.dropbox.sample.hellodropbox;

import java.io.IOException;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.dropbox.sync.android.DbxAccountManager;
import com.dropbox.sync.android.DbxFile;
import com.dropbox.sync.android.DbxFileInfo;
import com.dropbox.sync.android.DbxFileSystem;
import com.dropbox.sync.android.DbxPath;

public class HelloDropboxActivity extends Activity {

	private static final String appKey = "p78hpiyefxd4p9z";
	private static final String appSecret = "hwjzoa1qoxjoqft";

	private static final int REQUEST_LINK_TO_DBX = 0;

	private TextView mTestOutput;
	private Button mLinkButton;
	private DbxAccountManager mDbxAcctMgr;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hello_dropbox);
		mTestOutput = (TextView) findViewById(R.id.test_output);
		mLinkButton = (Button) findViewById(R.id.link_button);
		mLinkButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				onClickLinkToDropbox();
			}
		});

		mDbxAcctMgr = DbxAccountManager.getInstance(getApplicationContext(),
				appKey, appSecret);
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (mDbxAcctMgr.hasLinkedAccount()) {
			showLinkedView();
			showBooks();
		} else {
			showUnlinkedView();
		}
	}

	private void showLinkedView() {
		mLinkButton.setVisibility(View.GONE);
		mTestOutput.setVisibility(View.VISIBLE);
	}

	private void showUnlinkedView() {
		mLinkButton.setVisibility(View.VISIBLE);
		mTestOutput.setVisibility(View.GONE);
	}

	private void onClickLinkToDropbox() {
		mDbxAcctMgr.startLink((Activity) this, REQUEST_LINK_TO_DBX);
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == REQUEST_LINK_TO_DBX) {
			if (resultCode == Activity.RESULT_OK) {
				showBooks();
			} else {
				mTestOutput.setText("Link to Dropbox failed or was cancelled.");
			}
		} else {
			super.onActivityResult(requestCode, resultCode, data);
		}
	}

	private void showBooks() {
		try {
			final String TEST_DATA = "book";
			final String TEST_FILE_NAME = "book.ebup";
			DbxPath testPath = new DbxPath(DbxPath.ROOT, TEST_FILE_NAME);

			// Create DbxFileSystem for synchronized file access.
			DbxFileSystem dbxFs = DbxFileSystem.forAccount(mDbxAcctMgr
					.getLinkedAccount());

			// Create a test file only if it doesn't already exist.
			if (!dbxFs.exists(testPath)) {
				DbxFile testFile = dbxFs.create(testPath);
				try {
					testFile.writeString(TEST_DATA);
				} finally {
					testFile.close();
				}
			}

			// Print the contents of the root folder.
			List<DbxFileInfo> infos = dbxFs.listFolder(DbxPath.ROOT);
			mTestOutput.append("\nContents of app folder:\n");
			for (DbxFileInfo info : infos) {
				DbxPath mInfoPath = info.path;
				String mInfoString = mInfoPath.toString();
				if (mInfoString.contains(".ebup")) {
					mTestOutput.append("    " + info.path + ", "
							+ info.modifiedTime + '\n');
				}
			}
		} catch (IOException e) {
			mTestOutput.setText("Dropbox test failed: " + e);
		}
	}
}
