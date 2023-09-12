package de.silke.cinematic.managers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import de.silke.cinematic.Main;
import lombok.Data;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Data
public class VersionManager {
    private final String repositoryUrl;
    private String currentVersion;
    private String latestVersion;
    private boolean updateAvailable;

    public VersionManager() {
        this.repositoryUrl = "https://api.github.com/repos/blackysky/cinematic";
        this.currentVersion = Main.plugin.getDescription().getVersion();
        this.latestVersion = fetchLatestVersion();
        this.updateAvailable = !currentVersion.equals(latestVersion);
    }

    public String fetchLatestVersion() {
        try {
            URL url = new URL(repositoryUrl + "/releases/latest");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            if (connection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                String responseBody = IOUtils.toString(connection.getInputStream(), StandardCharsets.UTF_8);
                return parseLatestVersionFromResponse(responseBody);
            }
        } catch (IOException e) {
            Main.log.warning("Ошибки при проверки обновлений: " + e.getMessage());
        }
        return currentVersion;
    }

    public String isActualVersion() {
        return updateAvailable ? "Доступна новая версия: " + latestVersion : "Вы используете актуальную версию";
    }

    private String parseLatestVersionFromResponse(String responseBody) {
        Gson gson = new Gson();
        JsonObject jsonObject = gson.fromJson(responseBody, JsonObject.class);
        return jsonObject.get("tag_name").getAsString();
    }
}
