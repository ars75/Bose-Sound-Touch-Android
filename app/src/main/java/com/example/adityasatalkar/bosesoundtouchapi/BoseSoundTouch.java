package com.example.adityasatalkar.bosesoundtouchapi;

import org.json.JSONObject;

public class BoseSoundTouch {

    public JSONObject bass = null;
    public String IPAddress = null;
    public JSONObject source = null;
    public JSONObject volume = null;
    public JSONObject presets = null;
    public JSONObject getGroup = null;
    public JSONObject nowPlaying = null;
    public JSONObject bassCapabilities = null;


    public JSONObject getVolume() throws Exception {
        this.volume = RestCalls.getEndPoint(getIP(),"volume");
        return this.volume;
    }

    public JSONObject setVolume(String value) throws Exception {
        RestCalls.setEndPointValue(getIP(),"volume", value);
        this.volume = getVolume();
        return this.volume;
    }

    public JSONObject setVolumeUp() throws Exception {
        this.volume = getVolume();
        JSONObject jsonObject = null;
        jsonObject = (JSONObject) jsonObject.get("volume");
        String actualvolume = jsonObject.get("actualvolume").toString();
        int volumeUP = Integer.valueOf(actualvolume) + 1;
        return setVolume(String.valueOf(volumeUP));
    }

    public JSONObject setVolumeDown() throws Exception {
        this.volume = getVolume();
        JSONObject jsonObject = null;
        jsonObject = (JSONObject) jsonObject.get("volume");
        String actualvolume = jsonObject.get("actualvolume").toString();
        int volumeDown = Integer.valueOf(actualvolume) - 1;
        return setVolume(String.valueOf(volumeDown));
    }

    public JSONObject getBass() throws Exception {
        this.bass = RestCalls.getEndPoint(getIP(),"bass");
        return this.bass;
    }

    public JSONObject setBass(String value) throws Exception {
        RestCalls.setEndPointValue(getIP(),"bass", value);
        this.bass = getBass();
        return this.bass;
    }

    public JSONObject setBassUp() throws Exception {
        this.volume = getBass();
        JSONObject jsonObject = null;
        jsonObject = (JSONObject) jsonObject.get("bass");
        String actualvolume = jsonObject.get("actualbass").toString();
        int bassUp = Integer.valueOf(actualvolume) + 1;
        return setBass(String.valueOf(bassUp));
    }

    public JSONObject setBassDown() throws Exception {
        this.volume = getBass();
        JSONObject jsonObject = null;
        jsonObject = (JSONObject) jsonObject.get("bass");
        String actualvolume = jsonObject.get("actualbass").toString();
        int bassDown = Integer.valueOf(actualvolume) + 1;
        return setBass(String.valueOf(bassDown));
    }

    public JSONObject getNowPlaying() throws Exception {
        this.nowPlaying = RestCalls.getEndPoint(getIP(), "now_playing");
        return this.nowPlaying;
    }

    public JSONObject getSource() throws Exception {
        this.nowPlaying = RestCalls.getEndPoint(getIP(), "source");
        return this.source;
    }

    public JSONObject getGroup() throws Exception {
        this.getGroup = RestCalls.getEndPoint(getIP(), "getGroup");
        return this.getGroup;
    }

    public JSONObject getBassCapabilities() throws Exception {
        this.bassCapabilities = RestCalls.getEndPoint(getIP(), "bassCapabilities");
        return this.bassCapabilities;
    }

    public JSONObject getPresets() throws Exception {
        this.presets = RestCalls.getEndPoint(getIP(), "presets");
        return this.presets;
    }

    public String getIP() throws Exception {
//        ReadWriteFile readWriteFile = new ReadWriteFile();
//        this.IPAddress = readWriteFile.readFileAsString("IPAddress.txt");
        this.IPAddress = "http://192.168.1.15";
        return this.IPAddress;
    }

    public void setIP(String IPAddress) throws Exception {
        this.IPAddress = "http://";
        this.IPAddress = this.IPAddress + IPAddress;
        ReadWriteFile readWriteFile = new ReadWriteFile();
        readWriteFile.usingFileWriter("IPAddress.txt", this.IPAddress);
    }
}
