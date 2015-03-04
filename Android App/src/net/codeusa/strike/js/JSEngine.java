package net.codeusa.strike.js;

import net.codeusa.strike.StrikeActivity;
import net.codeusa.strike.services.NotficationService;
import net.codeusa.strike.settings.Settings;
import net.codeusa.strike.utils.Utils;
import android.webkit.JavascriptInterface;

public class JSEngine {
	NotficationService notfication = new NotficationService();

	@JavascriptInterface
	public void saveSettings(final String jsResult) {

		Utils.writeFileInternalStorage(jsResult,
				StrikeActivity.activity.getApplicationContext(),
				"strikeconfig.txt");
		Utils.readSettings(StrikeActivity.activity.getApplicationContext());
	}

	@JavascriptInterface
	public String getTorrentClient() {

		return Settings.getTorrentClient();
	}

	@JavascriptInterface
	public String getMPCServer() {

		return Settings.getMPCServer();
	}

	@JavascriptInterface
	public String checkStatus(final String host) {
		return Utils.isUP(host) == true ? "true" : "false";
	}

	@JavascriptInterface
	public void startNotfication() {

		this.notfication.notficationUpdate();

	}

	@JavascriptInterface
	public void removeNotfication() {

	}
}